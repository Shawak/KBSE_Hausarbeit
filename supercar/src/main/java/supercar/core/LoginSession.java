/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.core;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Maxi
 */
@SessionScoped
public class LoginSession implements Serializable {
    
    protected boolean loggedIn = false;
    protected long accountId = 0;
    
}
