/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.repositories;

import javax.ejb.Stateless;
import supercar.entities.Repair;
import supercar.interfaces.IRepository;

/**
 *
 * @author Lukas
 */
@Stateless
public class RepairRepository extends IRepository<Repair> {

    public RepairRepository() { }
    
}
