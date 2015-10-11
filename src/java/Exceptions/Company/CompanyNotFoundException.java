/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions.Company;

/**
 *
 * @author Silas
 */
public class CompanyNotFoundException extends Exception {
    
    
    public static final long serialVersionUID = 42L;
    
    
    @Override
    public String getMessage() {
        return "Company not found!";
    }
    
}
