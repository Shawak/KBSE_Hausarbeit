/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.filters;

import supercar.interfaces.IFilter;

/**
 *
 * @author Patrick
 */
public class NotLoginFilter extends IFilter {
    
    public NotLoginFilter() {
        this.filter = () -> LoginHandler.isLoggedIn();
    }
}
