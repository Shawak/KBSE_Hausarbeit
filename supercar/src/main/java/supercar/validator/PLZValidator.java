/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.validator;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import supercar.core.PlzApi;

/**
 *
 * @author Patrick
 */
public class PLZValidator implements ConstraintValidator<PLZ, Integer> {

    PlzApi plzapi = new PlzApi();

    @Override
    public void initialize(PLZ a) {
        ConstraintValidator.super.initialize(a); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(Integer t, ConstraintValidatorContext cvc) {
        try {
            if (t == null) {
                return false;
            }
            return !plzapi.getName(t).isEmpty();
            //return String.valueOf(t).length()==5;
        } catch (Exception ex) {
            Logger.getLogger(PLZValidator.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
    }
}
