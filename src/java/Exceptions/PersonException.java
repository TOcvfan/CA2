/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author Silas
 */
public class PersonException extends Exception {
    
    public PersonException(){
    
    }
    
    public PersonException(String msg){
    super(msg);
    }
    
}
