/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.filters;

import supercar.enums.AccountType;
import supercar.abstracts.IFilter;

/**
 *
 * @author Maximilian Nussbaum
 */
public class EmployeeFilter extends IFilter {

    public EmployeeFilter() {
        this.filter = () -> LoginHandler.hasAccess(AccountType.Employee);
    }

}
