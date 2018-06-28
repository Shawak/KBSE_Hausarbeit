/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.interfaces;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import supercar.enums.AccountType;

/**
 *
 * @author Maxi
 */
public abstract class IModel extends IRestrictableRepositoryAccessor implements Serializable {
    
    protected boolean LOGGEDIN, ISUSER, ISEMPLOYEE, ISADMIN;
    
    @PostConstruct
    void init() {
        LOGGEDIN = LoginHandler.isLoggedIn();
        ISUSER = LoginHandler.hasAccess(AccountType.User);
        ISEMPLOYEE = LoginHandler.hasAccess(AccountType.Employee);
        ISADMIN = LoginHandler.hasAccess(AccountType.Administrator);
    }

}