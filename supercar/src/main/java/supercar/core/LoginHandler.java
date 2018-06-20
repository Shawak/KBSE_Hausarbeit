/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.core;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import supercar.entities.Account;
import supercar.interfaces.IRepositoryAccessor;

/**
 *
 * @author Maxi
 */
@SessionScoped
public class LoginHandler extends IRepositoryAccessor implements Serializable {
    
    private boolean loggedIn = false;
    private long accountId = 0;
    
    public Account getAccount() {
        return Accounts.get(accountId);
    }
    
    public boolean isLoggedIn() {
        return loggedIn && getAccount() != null;
    }
    
    public LoginHandler() { }
    
    public boolean login(String login, String password) {
        Account acc = Accounts.getByLogin(login);
        if (!acc.getPassword().equals(password)) {
            return false;
        }
        
        if (!acc.isActivated()) {
            return false;
        }
        
        loggedIn = true;
        accountId = acc.getId();
        return true;
    }
    
    public void logout() {
        loggedIn = false;
        accountId = 0;
    }
    
}
