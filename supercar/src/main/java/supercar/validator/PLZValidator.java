/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Patrick
 */
public class PLZValidator implements ConstraintValidator<PLZ, Integer>{

    @Override
    public void initialize(PLZ a) {
        ConstraintValidator.super.initialize(a); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(Integer t, ConstraintValidatorContext cvc) {
        return String.valueOf(t).length()==5;
    }
}
