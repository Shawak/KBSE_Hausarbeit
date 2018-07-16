/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.core;

import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import supercar.entities.Account;
import supercar.enums.AccountType;
import supercar.abstracts.IRepositoryAccessor;

/**
 *
 * @author Maxi
 */
@RequestScoped
public class LoginHandler extends IRepositoryAccessor {

    Account account;

    Map<String, Object> SessionMap() {
        try {
            return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        } catch (Exception ex) {
            return null;
        }
    }

    <T extends Object> T get(String key, T defaultValue) {
        Map<String, Object> map = SessionMap();
        if (map != null) {
            return (T) map.getOrDefault(key, defaultValue);
        } else {
            Object ret = session.getAttribute(key);
            return (T) (ret != null ? ret : defaultValue);
        }
    }

    void put(String key, Object value) {
        Map<String, Object> map = SessionMap();
        if (map != null) {
            map.put(key, value);
        } else {
            session.setAttribute(key, value);
        }
    }

    Boolean session_loggedIn() {
        return get("loggedIn", false);
    }

    void session_loggedIn(Boolean loggedIn) {
        put("loggedIn", loggedIn);
    }

    Long session_accountId() {
        return get("accountId", 0L);
    }

    void session_accountId(Long id) {
        put("accountId", id);
    }

    public Account getAccount() {
        return account;
    }

    private HttpSession session;

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public boolean isLoggedIn() {
        return session_loggedIn() && account != null && account.isActivated();
    }

    public LoginHandler() {
    }

    @PostConstruct
    void init() {
        if (session_loggedIn()) {
            account = Accounts.get(session_accountId());
        }
    }

    public boolean login(String login, String password) {
        Account acc = Accounts.getByLogin(login);
        if (acc == null || !acc.getPassword().equals(password)) {
            return false;
        }

        if (!acc.isActivated() || acc.isBanned()) {
            return false;
        }

        account = acc;
        session_loggedIn(true);
        session_accountId(acc.getId());
        return true;
    }

    public void logout() {
        account = null;
        session_loggedIn(false);
        session_accountId(0L);
    }

    public boolean hasAccess(AccountType accountType) {
        return isLoggedIn() && account.isAtleast(accountType);
    }

}
