/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.interfaces;

import java.io.Serializable;
import javax.inject.Inject;
import supercar.core.LoginHandler;
import supercar.core.PlzApi;
import supercar.enums.AccountType;

/**
 *
 * @author Maxi
 */
public abstract class IModel extends IRestrictableRepositoryAccessor implements Serializable {

    @Inject
    protected transient PlzApi PlzApi;
     
    protected boolean LOGGEDIN, ISUSER, ISEMPLOYEE, ISADMIN;

    public boolean isLOGGEDIN() {
        return LoginHandler.isLoggedIn();
    }

    public boolean isISUSER() {
        return LoginHandler.hasAccess(AccountType.User);
    }

    public boolean isISEMPLOYEE() {
        return LoginHandler.hasAccess(AccountType.Employee);
    }

    public boolean isISADMIN() {
        return LoginHandler.hasAccess(AccountType.Administrator);
    }

    public LoginHandler getLoginHandler() {
        return LoginHandler;
    }

}
