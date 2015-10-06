package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOcvfan
 */
@Entity
@Table(name = "infoentity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Infoentity.findAll", query = "SELECT i FROM Infoentity i"),
    @NamedQuery(name = "Infoentity.findById", query = "SELECT i FROM Infoentity i WHERE i.id = :id"),
    @NamedQuery(name = "Infoentity.findByEmail", query = "SELECT i FROM Infoentity i WHERE i.email = :email")})
public class InfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Email")
    private String email;
    @JoinColumn(name = "PhoneNumber", referencedColumnName = "P_number")
    @ManyToOne
    private Phone phoneNumber;
    @JoinColumn(name = "cvr", referencedColumnName = "cvr")
    @ManyToOne
    private Company cvr;
    @JoinColumn(name = "Person_ID", referencedColumnName = "ID")
    @ManyToOne
    private Person personID;
    @JoinColumn(name = "adr_Id", referencedColumnName = "ID")
    @ManyToOne
    private Address adrId;

    public InfoEntity() {
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

    public Phone getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Phone phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Company getCvr() {
        return cvr;
    }

    public void setCvr(Company cvr) {
        this.cvr = cvr;
    }

    public Person getPersonID() {
        return personID;
    }

    public void setPersonID(Person personID) {
        this.personID = personID;
    }

    public Address getAdrId() {
        return adrId;
    }

    public void setAdrId(Address adrId) {
        this.adrId = adrId;
    }

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
        return "Entity.Infoentity[ id=" + id + " ]";
    }

}
