package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOcvfan
 */
@Entity
@Table(name = "person")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByZip", query = "SELECT p FROM Person p WHERE p.infoEntity.adrId.zip = :zip"),
    @NamedQuery(name = "Person.findByPhone", query = "SELECT p FROM Person p WHERE p.infoEntity.phoneCollection = :pnumber"),
    @NamedQuery(name = "Person.findByFirstname", query = "SELECT p FROM Person p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Person.findByLastname", query = "SELECT p FROM Person p WHERE p.lastname = :lastname")})
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer Pid;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    @ManyToMany(mappedBy = "personCollection")
    private Collection<Hobby> hobbyCollection;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private InfoEntity infoEntity;

    public Person() {
    }

   
    public Person(Integer Pid, String firstname, String lastname) {
        this.Pid = Pid;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    public Person(Integer Pid) {
        this.Pid = Pid;
    }

    public Integer getPId() {
        return Pid;
    }

    public void setPId(Integer Pid) {
        this.Pid = Pid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @XmlTransient
    public Collection<Hobby> getHobbyCollection() {
        return hobbyCollection;
    }

    public void setHobbyCollection(Collection<Hobby> hobbyCollection) {
        this.hobbyCollection = hobbyCollection;
    }

    public InfoEntity getInfoEntity() {
        return infoEntity;
    }

    public void setInfoEntity(InfoEntity infoEntity) {
        this.infoEntity = infoEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Pid != null ? Pid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.Pid == null && other.Pid != null) || (this.Pid != null && !this.Pid.equals(other.Pid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Person[ id=" + Pid + " ]";
    }

}
