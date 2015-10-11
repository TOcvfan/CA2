/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions.Person;

/**
 *
 * @author Silas
 */
public class PersonNotFoundException extends Exception {
    
    public static final long serialVersionUID = 42L;
    
    
    @Override
    public String getMessage() {
        return "Person not found! Check spelling or ID.";
    }
    
    
}
