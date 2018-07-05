/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.repositories;

import javax.ejb.Stateless;
import supercar.entities.Lending;
import supercar.entities.Repair;
import supercar.interfaces.IRepository;

/**
 *
 * @author Lukas
 */
@Stateless
public class RepairRepository extends IRepository<Repair> {

    public RepairRepository() { }
    
    public Repair getRepairByCarid( long id){
        return query("select e from #table e where e.car.id = :id and e.repairEndDate IS NULL")
                .put("id", id)
                .one();
    }
    
}
