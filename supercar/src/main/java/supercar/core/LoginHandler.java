/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.core;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import supercar.entities.Account;
import supercar.enums.AccountType;
import supercar.abstracts.IRepositoryAccessor;

/**
 *
 * @author Maxi
 */
@SessionScoped
public class LoginHandler extends IRepositoryAccessor implements Serializable {

    boolean loggedIn;
    long accountId;

    Account account;
    HashMap<Long, Long> cache;

    public Account getAccount() {
        if (account == null || (new GregorianCalendar().getTimeInMillis() - cache.getOrDefault(accountId, (long) 0) >= 100)) {
            account = loggedIn ? Accounts.get(accountId) : null;
            cache.put(accountId, new GregorianCalendar().getTimeInMillis());
        }
        return account;
    }

    public boolean isLoggedIn() {
        return loggedIn && getAccount() != null && getAccount().isActivated();
    }

    public LoginHandler() {
        cache = new HashMap<>();
    }

    public boolean login(String login, String password) {
        Account acc = Accounts.getByLogin(login);
        if (acc == null || !acc.getPassword().equals(password)) {
            return false;
        }

        if (!acc.isActivated() || acc.isBanned()) {
            return false;
        }

        loggedIn = true;
        accountId = acc.getId();

        HttpSession sessionObj = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        SessionHandler.put(accountId, sessionObj);

        return true;
    }

    public void logout() {
        loggedIn = false;
        accountId = 0;
        SessionHandler.removeSession(accountId);
    }

    public boolean hasAccess(AccountType accountType) {
        return isLoggedIn() && getAccount().isAtleast(accountType);
    }

}
