/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.validator;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Patrick
 */
public class LicensePlateValidator implements ConstraintValidator<LicensePlate, String> {

    @Override
    public void initialize(LicensePlate a) {
        ConstraintValidator.super.initialize(a); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {

        return t != null && Pattern.matches("[A-ZÄÖÜ]{1,3} [A-Z]{0,2} [0-9]{1,4}[H]{0,1}", t) == true && t.length() <= 10;
    }
}
