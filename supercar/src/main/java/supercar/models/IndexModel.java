/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.models;

import javax.inject.Inject;
import javax.inject.Named;
import supercar.repositories.DB;

/**
 *
 * @author Maxi
 */
@Named("indexModel")
public class IndexModel {

    @Inject
    private DB DB;

    public IndexModel() { }

}