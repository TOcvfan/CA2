package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TOcvfan
 */
@Entity
@Table(name = "phone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phone.findAll", query = "SELECT p FROM Phone p"),
    @NamedQuery(name = "Phone.findByPnumber", query = "SELECT p FROM Phone p WHERE p.pnumber = :pnumber"),
    @NamedQuery(name = "Phone.findByDescription", query = "SELECT p FROM Phone p WHERE p.description = :description")})
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "P_number")
    private String pnumber;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "phoneNumber")
    private List<InfoEntity> infoentityList;

    public Phone() {
    }

    public Phone(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<InfoEntity> getInfoentityList() {
        return infoentityList;
    }

    public void setInfoentityList(List<InfoEntity> infoentityList) {
        this.infoentityList = infoentityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pnumber != null ? pnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phone)) {
            return false;
        }
        Phone other = (Phone) object;
        if ((this.pnumber == null && other.pnumber != null) || (this.pnumber != null && !this.pnumber.equals(other.pnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Phone[ pnumber=" + pnumber + " ]";
    }

}
