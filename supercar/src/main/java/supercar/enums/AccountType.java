/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.enums;

import java.io.Serializable;

/**
 *
 * @author Maxi
 */
public enum AccountType implements Serializable {
    
    User(1),
    Employee(2),
    Administrator(3);
    
    private final int value;
    
    public int getValue() {
        return value;
    }
    
    AccountType(int value) {
        this.value = value;
    }

}