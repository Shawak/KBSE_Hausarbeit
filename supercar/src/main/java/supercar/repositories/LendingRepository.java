/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.repositories;

import java.util.Collection;
import javax.ejb.Stateless;
import supercar.entities.Lending;
import supercar.abstracts.IRepository;

/**
 *
 * @author Lukas
 */
@Stateless
public class LendingRepository extends IRepository<Lending> {

    public LendingRepository() {
    }

    public Lending getLendingByCarId(Long id) {
        return query("select e from #table e where e.car.id = :id and e.returnDate IS NULL")
                .put("id", id)
                .one();
    }

    public Collection<Lending> getLendingsByCarId(Long id) {
        return query("select e from #table e where e.car.id = :id order by e.rentMileage ASC")
                .put("id", id)
                .all();
    }

    public Lending getLastLendingByCarId(Long id) {
        return query("select e from #table e where e.car.id = :id and e.returnMileage IS NOT NULL order by e.returnMileage desc")
                .put("id", id)
                .one();
    }

    public Long getAccountIdFromLendingId(Long id) {
        return (Long) em.createNativeQuery("select ACCOUNT_ID from LENDING where ID = " + id).getSingleResult();
    }
}
