package Facade;

import Entity.Address;
import Entity.Company;
import Entity.Person;
import Entity.Phone;
import Entity.CityInfo;
import Entity.Hobby;
import Entity.InfoEntity;
import deploy.DeploymentConfiguration;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author TOcvfan
 */
public class Facade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.puName);
    EntityManager em;

    public Person getPerson(int id) {
        
        em = emf.createEntityManager();
        Person p = em.find(Person.class, id);
        em.close();
        
        
        return p;
        
    }
    
    public List<Person> getPersons() {
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Person.findAll");
        List<Person> personList;
        personList = query.getResultList();
        em.close();
        return personList;
    }

    public Person getPersonByPhone(String phone) {
        em = emf.createEntityManager();
        Phone p = em.find(Phone.class, phone);
        int id = p.getIe().getId();
        Person person = em.find(Person.class, id);
        em.close();
        return person;
    }

    public List<Person> getPersonsByZip(String zip) {

        em = emf.createEntityManager();
        CityInfo ci = em.find(CityInfo.class, zip);

        Query q = em.createNamedQuery("Person.findByZip");
        q.setParameter("zip", ci);

        List<Person> personList;
        personList = q.getResultList();
        em.close();
        return personList;
    }

    public Company getCompany(String cvr) {
        em = emf.createEntityManager();
        Query q = em.createNamedQuery("Company.findByCvr");
        q.setParameter("cvr", cvr);
        Company company = (Company) q.getSingleResult();
        em.close();
        return company;
    }

    public List<Company> getCompanies() {
        em = emf.createEntityManager();
        Query query = em.createNamedQuery("Company.findAll");
        List<Company> companyList;
        companyList = query.getResultList();
        em.close();
        return companyList;
    
    }

    public Company getCompanyByPhone(String phone) {
        em = emf.createEntityManager();
        Phone p = em.find(Phone.class, phone);
        int id = p.getIe().getId();
        Company company = em.find(Company.class, id);
        em.close();
        return company;
    }

    public List<Company> getCompanyByZip(String zip) {

        em = emf.createEntityManager();
        CityInfo ci = em.find(CityInfo.class, zip);

        Query q = em.createNamedQuery("Company.findByZip");
        q.setParameter("zip", ci);

        List<Company> companyList;
        companyList = q.getResultList();
        em.close();
        return companyList;
    }

    public Phone getPhone(String num) {
        em = emf.createEntityManager();
        Query q = em.createNamedQuery("Phone.findByPnumber");
        q.setParameter("pnumber", num);
        Phone phone = (Phone) q.getSingleResult();
        em.close();
        return phone;

    }

    public List getZip(String zip) {
        em = emf.createEntityManager();
        Query q = em.createNamedQuery("CityInfo.findByZip");
        q.setParameter("zip", zip);
        List<CityInfo> ciList;
        ciList = q.getResultList();
        em.close();
        return ciList;
    }
    public List<Hobby> getHobbies(){
        em = emf.createEntityManager();
        Query q = em.createNamedQuery("Hobby.findAll");
        List<Hobby> hobbyList;
        hobbyList = q.getResultList();
        em.close();
        return hobbyList;
    }
    
    public Hobby getHobby(String hobbyName) {
        
        em = emf.createEntityManager();
        Hobby h = em.find(Hobby.class, hobbyName);
        em.close();
        
        return h;
    }
    public InfoEntity createInfo(InfoEntity ie){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(ie);
        em.getTransaction().commit();
        em.close();
        
        return ie;
    }
    public Phone CreatePhone(Phone ph){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(ph);
        em.getTransaction().commit();
        em.close();
        
        return ph;
    }
    
    public Person createPerson(Person p){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        
        return p;
    }
    
    public Address CreateAdress(Address a){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
        
        return a;
    }
    
    public Company CreateCompany(Company c){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        
        return c;
    }
    
    public Hobby CreateHobby(Hobby h){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(h);
        em.getTransaction().commit();
        em.close();
        
        return h;
    }
    

}
