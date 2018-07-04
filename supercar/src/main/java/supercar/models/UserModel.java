/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.util.Collection;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import supercar.entities.Account;
import supercar.interfaces.IModel;

/**
 *
 * @author Lukas
 */
@Named("usermanager")
@RequestScoped
public class UserModel extends IModel{
    public Collection<Account> getAll()
    {
        return Accounts.getAll();
    }
    
    public Collection<Account> getAllUnactivated()
    {
        return Accounts.getAllUnactivated();
    }
    
    public void banUser(long id)
    {
        
    }
    
    public void unbanUser(long id)
    {
        
    }
    
    public boolean isBanned(long id)
    {
        return false;
    }
}
