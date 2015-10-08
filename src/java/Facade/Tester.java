package Facade;

/**
 *
 * @author TOcvfan
 */
public class Tester {
    static Facade f = new Facade();
    public static void main(String[] args) {
        String phone = "60864820";
        String cvr = "70995177";
        String zip = "2800";
        int id = 1;
        
        System.out.println("Person first name(s): \t \t Last name:");
        System.out.println(f.getPerson(id).getFirstname()+ " \t " + f.getPerson(id).getLastname());
        System.out.println("");
        System.out.println("Person from phone: ");
        System.out.println(f.getPersonByPhone(phone).getFirstname());
     
        
        System.out.println("");
        System.out.println("Company name: \t \t CVR:");
        System.out.println(f.getCompany(cvr).getName() + "\t " + f.getCompany(cvr).getCvr());
        
        System.out.println("");
        System.out.println("Persons from /all:");
        System.out.println("");
        for (int i = 1; i < f.getPersons().size(); i++) {
            System.out.println(f.getPersons().get(i).getFirstname()+" "+f.getPersons().get(i).getLastname());
        }
        
    }
}
