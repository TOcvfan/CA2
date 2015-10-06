package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOcvfan
 */
@Entity
@Table(name = "hobby")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hobby.findAll", query = "SELECT h FROM Hobby h"),
    @NamedQuery(name = "Hobby.findByHobbyNAME", query = "SELECT h FROM Hobby h WHERE h.hobbyNAME = :hobbyNAME"),
    @NamedQuery(name = "Hobby.findByDescription", query = "SELECT h FROM Hobby h WHERE h.description = :description")})
public class Hobby implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "HobbyNAME")
    private String hobbyNAME;
    @Column(name = "description")
    private String description;
    @JoinTable(name = "personhobby", joinColumns = {
        @JoinColumn(name = "HobbyNAME", referencedColumnName = "HobbyNAME")}, inverseJoinColumns = {
        @JoinColumn(name = "PersonId", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Person> personCollection;

    public Hobby() {
    }

    public Hobby(String hobbyNAME) {
        this.hobbyNAME = hobbyNAME;
    }

    public String getHobbyNAME() {
        return hobbyNAME;
    }

    public void setHobbyNAME(String hobbyNAME) {
        this.hobbyNAME = hobbyNAME;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Person> getPersonCollection() {
        return personCollection;
    }

    public void setPersonCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hobbyNAME != null ? hobbyNAME.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hobby)) {
            return false;
        }
        Hobby other = (Hobby) object;
        if ((this.hobbyNAME == null && other.hobbyNAME != null) || (this.hobbyNAME != null && !this.hobbyNAME.equals(other.hobbyNAME))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Hobby[ hobbyNAME=" + hobbyNAME + " ]";
    }

}
