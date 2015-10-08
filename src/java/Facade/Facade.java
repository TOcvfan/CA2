package Facade;

import Entity.Company;
import Entity.Person;
import Entity.Phone;
import Entity.CityInfo;
import Entity.InfoEntity;
import java.util.ArrayList;
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
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2DatabasePU");
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
        Query q = em.createNamedQuery("Person.findByZip");
        List<Person> personList;
        q.setParameter("zip", zip);
        personList = q.getResultList();
        em.close();
        return personList;
    }
    
    public Company getCompany(String cvr){
        em = emf.createEntityManager();
        Query q = em.createNamedQuery("Company.findByCvr");
        q.setParameter("cvr", cvr);
        Company comp = (Company) q.getSingleResult();
        em.close();
        return comp;
    }
    
    public Phone getPhone(String num){
        em = emf.createEntityManager();
        Query q = em.createNamedQuery("Phone.findByPnumber");
        q.setParameter("pnumber", num);
        Phone phone = (Phone) q.getSingleResult();
        em.close();
        return phone;
        
    }
    
    public List getZip(String zip){
        em = emf.createEntityManager();
        Query q = em.createNamedQuery("CityInfo.findByZip");
        q.setParameter("zip", zip);
        List<CityInfo> ciList;
        ciList = q.getResultList();
        em.close();
        return ciList;       
    }
}
