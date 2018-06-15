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
    
    public AccountRepository() { 
        //this.entityClass = Account.class;
    }
    
}
