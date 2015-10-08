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
}
