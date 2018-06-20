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
    
    @Inject public AccountRepository Accounts;
    @Inject public CarRepository Cars;
    @Inject public GarageRepository Garages;
    @Inject public LendingRepository Lendings;
    @Inject public ManufacturerRepository Manufacturers;
    @Inject public ModelRepository Models;
    @Inject public RepairRepository Repairs;

}