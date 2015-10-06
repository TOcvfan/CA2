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
@Table(name = "cityinfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cityinfo.findAll", query = "SELECT c FROM Cityinfo c"),
    @NamedQuery(name = "Cityinfo.findByZip", query = "SELECT c FROM Cityinfo c WHERE c.zip = :zip"),
    @NamedQuery(name = "Cityinfo.findByCity", query = "SELECT c FROM Cityinfo c WHERE c.city = :city")})
public class CityInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Zip")
    private String zip;
    @Column(name = "City")
    private String city;
    @OneToMany(mappedBy = "zip")
    private List<Address> addressList;

    public CityInfo() {
    }

    public CityInfo(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlTransient
    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zip != null ? zip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CityInfo)) {
            return false;
        }
        CityInfo other = (CityInfo) object;
        if ((this.zip == null && other.zip != null) || (this.zip != null && !this.zip.equals(other.zip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Cityinfo[ zip=" + zip + " ]";
    }

}
