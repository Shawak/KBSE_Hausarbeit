/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.interfaces;

import javax.inject.Inject;
import supercar.core.LoginHandler;

/**
 *
 * @author Maxi
 */
public abstract class IRestrictedRepositoryAccessor extends IRepositoryAccessor {
    
    @Inject protected LoginHandler LoginHandler;
    
}
