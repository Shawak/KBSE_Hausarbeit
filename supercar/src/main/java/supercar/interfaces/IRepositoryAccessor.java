/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.interfaces;

import javax.inject.Inject;
import supercar.repositories.*;

/**
 *
 * @author Maxi
 */
public abstract class IRepositoryAccessor {
    
    @Inject protected AccountRepository Accounts;
    @Inject protected CarRepository Cars;
    @Inject protected GarageRepository Garages;
    @Inject protected LendingRepository Lendings;
    @Inject protected ManufacturerRepository Manufacturers;
    @Inject protected ModelRepository Models;
    @Inject protected RepairRepository Repairs;

}