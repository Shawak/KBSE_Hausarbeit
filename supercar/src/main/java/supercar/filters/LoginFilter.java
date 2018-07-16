/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.filters;

import supercar.abstracts.IFilter;

/**
 *
 * @author Patrick Wiethoff
 */
public class LoginFilter extends IFilter {

    public LoginFilter() {
        this.filter = () -> LoginHandler.isLoggedIn();
        this.redirect = "/faces/login.xhtml";
    }
}
