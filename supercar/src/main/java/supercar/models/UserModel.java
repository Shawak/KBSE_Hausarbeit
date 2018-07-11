/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.util.Collection;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import supercar.entities.Account;
import supercar.abstracts.IModel;

/**
 *
 * @author Lukas
 */
@Named("usermanager")
@SessionScoped
public class UserModel extends IModel {

    private boolean checkbox = false;

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }

    public Collection<Account> getAll() {
        if (checkbox) {
            return Accounts.getAllUnactivated();
        } else {
            return Accounts.getAll();
        }
    }

    public Collection<Account> getAllUnactivated() {
        return Accounts.getAllUnactivated();
    }

    public void banUser(long id) {
        Account acc = Accounts.get(id);
        acc.setBanned(true);
        Accounts.update(acc);
    }

    public void unbanUser(long id) {
        Account acc = Accounts.get(id);
        acc.setBanned(false);
        Accounts.update(acc);
    }

    public void activateUser(long id) {
        Account acc = Accounts.get(id);
        acc.setActivated(true);
        Accounts.update(acc);
    }
    
    public boolean isSameUser(long id){
        if(Accounts.get(id).equals(LoginHandler.getAccount()))
            return true;
        return false;
    }
}
