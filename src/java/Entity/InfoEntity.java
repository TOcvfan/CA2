package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOcvfan
 */
@Entity
@Table(name = "infoentity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoEntity.findAll", query = "SELECT i FROM InfoEntity i"),
    @NamedQuery(name = "InfoEntity.findById", query = "SELECT i FROM InfoEntity i WHERE i.id = :id"),
    @NamedQuery(name = "InfoEntity.findByEmail", query = "SELECT i FROM InfoEntity i WHERE i.email = :email")})
public class InfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Email")
    private String email;
    @JoinColumn(name = "adr_Id", referencedColumnName = "ID")
    @ManyToOne
    private Address adrId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ie")
    private Collection<Phone> phoneCollection;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "infoEntity")
    private Person person;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "infoEntity")
    private Company company;

    public InfoEntity() {
    }

    public InfoEntity(String email, Address adrId) {
        this.email = email;
        this.adrId = adrId;
    }
   
    public InfoEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAdrId() {
        return adrId;
    }

    public void setAdrId(Address adrId) {
        this.adrId = adrId;
    }

    
    
    
//    @XmlTransient
//    public Collection<Phone> getPhoneCollection() {
//        return phoneCollection;
//    }
//
//    public void setPhoneCollection(Collection<Phone> phoneCollection) {
//        this.phoneCollection = phoneCollection;
//    }
//
//    
//    public void addPhone(Phone p){
//    
//        getPhoneCollection().add(p);
//    }
//    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
//    
//    public Phone getPhone(){
//        return phone;
//    }
//    
//    public void setPhone(Phone phone){
//        this.phone = phone;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoEntity)) {
            return false;
        }
        InfoEntity other = (InfoEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.InfoEntity[ id=" + id + " ]";
    }

}
