/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.core;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import supercar.entities.Account;
import supercar.enums.AccountType;
import supercar.interfaces.IRepositoryAccessor;

/**
 *
 * @author Maxi
 */
@RequestScoped
public class LoginHandler extends IRepositoryAccessor{
    
    @Inject
    LoginSession session;
    
    Account account;
    
    public Account getAccount() {
        return account;
    }
    
    public boolean isLoggedIn() {
        return session != null && session.loggedIn && account != null && account.isActivated();
    }
    
    public LoginHandler() { }
    
    @PostConstruct
    void init() {
        account = Accounts.get(session.accountId);
    }
    
    public boolean login(String login, String password) {
        Account acc = Accounts.getByLogin(login);
        if (!acc.getPassword().equals(password)) {
            return false;
        }
        
        if (!acc.isActivated()) {
            return false;
        }
        
        session.loggedIn = true;
        session.accountId = acc.getId();
        return true;
    }
    
    public void logout() {
        session.loggedIn = false;
        session.accountId = 0;
    }
    
    public boolean hasAccess(AccountType accountType) {
        return isLoggedIn() && account.isAtleast(accountType);
    }
    
}