/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import supercar.interfaces.IModel;

/**
 *
 * @author Patrick
 */
@Named("menu")
@RequestScoped
public class MenuModel extends IModel {

    public MenuModel() {

    }

    @PostConstruct
    public void init() {

    }

}
