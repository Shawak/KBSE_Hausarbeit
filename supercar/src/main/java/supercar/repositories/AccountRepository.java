/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.repositories;

import java.util.Collection;
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
        return query("select e from #table e where e.login = :login")
                .put("login", login)
                .one();
    }
    
    public Collection<Account> getAllUnactivated() {
        return query("select e from #table e where e.activated = false")
                .all();
    }
    
}