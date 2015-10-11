package Facade;

import Entity.Address;
import Entity.InfoEntity;
import Exceptions.Person.PersonNotFoundException;

/**
 *
 * @author TOcvfan
 */
public class Tester {

    static Facade f = new Facade();

    public static void main(String[] args) throws PersonNotFoundException {
        String pPhone = "60864820";
        String cPhone = "72359556";
        String cvr = "70995177";
        String zip = "2800";
        String hobby = "Lystfiskeri";
        int id = 1;

        System.out.println("Welcome to the test class!");

        //----------------------------------------------------------------------
        System.out.println("Person from ID: " + id);
        System.out.println(f.getPerson(id).getFirstname() + " \t " + f.getPerson(id).getLastname());
        System.out.println("----------------------------------------------------------------------");
//
//        //----------------------------------------------------------------------
//        System.out.println("Person from phone number: " + pPhone);
//        System.out.println(f.getPersonByPhone(pPhone).getFirstname() + " " + f.getPersonByPhone(pPhone).getLastname());
//        System.out.println("----------------------------------------------------------------------");
//
//        //----------------------------------------------------------------------
//        System.out.println("Company from CVR: " + cvr);
//        System.out.println(f.getCompany(cvr).getName());
//        System.out.println("----------------------------------------------------------------------");
//
//        //----------------------------------------------------------------------
//        System.out.println("Company from phone: " + cPhone);
//        System.out.println("CVR: " + f.getCompanyByPhone(cPhone).getCvr() + ", Company name: " + f.getCompanyByPhone(cPhone).getName());
//        System.out.println("----------------------------------------------------------------------");
//
//        //----------------------------------------------------------------------
//        
//        System.out.println("Company from /all:");
//        System.out.println("");
//        for (int i = 1; i < f.getCompanies().size(); i++) {
//            System.out.println("CVR: " + f.getCompanies().get(i).getCvr() + ", Company name: " + f.getCompanies().get(i).getName());
//        }
//        System.out.println("----------------------------------------------------------------------");
//
//        //----------------------------------------------------------------------
//        System.out.println("Company from zip: " + zip);
//        System.out.println("");
//        for (int i = 1; i < f.getCompanyByZip(zip).size(); i++) {
//            System.out.println("CVR: " + f.getCompanyByZip(zip).get(i).getCvr() + ", Company name: " + f.getCompanyByZip(zip).get(i).getName());
//        }
//        System.out.println("----------------------------------------------------------------------");
//
//        //----------------------------------------------------------------------
//        System.out.println("Persons from /all:");
//        System.out.println("");
//        for (int i = 1; i < f.getPersons().size(); i++) {
//            System.out.println(f.getPersons().get(i).getFirstname() + " " + f.getPersons().get(i).getLastname());
//        }
//        System.out.println("----------------------------------------------------------------------");
//
//        //----------------------------------------------------------------------
//        System.out.println("Persons from Zip: " + zip);
//        System.out.println("");
//        for (int i = 1; i < f.getPersonsByZip(zip).size(); i++) {
//            System.out.println(f.getPersonsByZip(zip).get(i).getFirstname() + " " + f.getPersonsByZip(zip).get(i).getLastname());
//        }
//        System.out.println("----------------------------------------------------------------------");
//
//        //----------------------------------------------------------------------
//        System.out.println("All hobbies");
//        System.out.println(f.getHobbies());
//        System.out.println("");
//        System.out.println("Specific Hobby");
//        System.out.println(f.getHobby(hobby));
//        System.out.println("");
//        System.out.println("----------------------------------------------------------------------");
//        System.out.println("create new info");
////        Address a = new Address();
////        a.setId(9);
////        InfoEntity ie = new InfoEntity("niels@hansen.dk", a);
////        System.out.println(f.createInfo(ie));
////        System.out.println("----------------------------------------------------------------------");
    }

}
