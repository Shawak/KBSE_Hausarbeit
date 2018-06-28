/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.filters;

import supercar.enums.AccountType;
import supercar.interfaces.IFilter;

/**
 *
 * @author Maxi
 */
public class AdministratorFilter extends IFilter {
    
    public AdministratorFilter() {
        this.filter = () -> LoginHandler.hasAccess(AccountType.Administrator);
    }
    
}