/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import java.util.Collection;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import supercar.entities.Lending;
import supercar.interfaces.IModel;

/**
 *
 * @author Patrick
 */
@Named("return")
@SessionScoped
public class ReturnModel extends IModel{

    private Collection<Lending> lendings;
    
    public ReturnModel(){
        
    }
    
    @PostConstruct
    public void init(){
        lendings = LoginHandler.getAccount().getLendings().stream().filter((Lending l)-> l.getReturnDate() == null).collect(Collectors.toList());
                
                //Lendings.getLendingCarsByAccountId(LoginHandler.getAccount().getId());
    }

    public Collection<Lending> getLendings() {
        return lendings;
    }

    public void setLendings(Collection<Lending> lendings) {
        this.lendings = lendings;
    }
    
    
}
