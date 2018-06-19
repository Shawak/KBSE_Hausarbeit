/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.repositories;

import javax.ejb.Stateless;
import supercar.entities.Account;
import supercar.interfaces.IRepository;

/**
 *
 * @author Maxi
 */
@Stateless
public class AccountRepository extends IRepository<Account> {
    
    public AccountRepository() { }
    
    public Account getByLogin(String login) {
        try {
            return query("select e from #{table} e where e.login = :login")
                .setParameter("login", login)
                .getSingleResult();
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    
}