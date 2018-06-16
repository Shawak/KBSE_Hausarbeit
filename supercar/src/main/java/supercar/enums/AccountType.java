/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supercar.enums;

/**
 *
 * @author Maxi
 */
/*public class AccountType {
    
    public static final int User = 1 << 0;
    public static final int Employee = 1 << 1;
    public static final int Administrator = 1 << 2;
    
}*/

/*public class AccountType {
    
    public static final int User = 1;
    public static final int Employee = 2;
    public static final int Administrator = 3;
    
}*/

public enum AccountType {
    
    /*User(1 << 0),
    Employee(1 << 1),
    Administrator(1 << 2);*/
    
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