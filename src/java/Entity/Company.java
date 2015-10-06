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
@Table(name = "company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findByCName", query = "SELECT c FROM Company c WHERE c.cName = :cName"),
    @NamedQuery(name = "Company.findByDescription", query = "SELECT c FROM Company c WHERE c.description = :description"),
    @NamedQuery(name = "Company.findByCvr", query = "SELECT c FROM Company c WHERE c.cvr = :cvr"),
    @NamedQuery(name = "Company.findByAdditionalInfo", query = "SELECT c FROM Company c WHERE c.additionalInfo = :additionalInfo"),
    @NamedQuery(name = "Company.findByNumEmployees", query = "SELECT c FROM Company c WHERE c.numEmployees = :numEmployees"),
    @NamedQuery(name = "Company.findByMarketValue", query = "SELECT c FROM Company c WHERE c.marketValue = :marketValue")})
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "C_Name")
    private String cName;
    @Column(name = "description")
    private String description;
    @Id
    @Basic(optional = false)
    @Column(name = "cvr")
    private String cvr;
    @Column(name = "AdditionalInfo")
    private String additionalInfo;
    @Column(name = "NumEmployees")
    private Integer numEmployees;
    @Column(name = "MarketValue")
    private Integer marketValue;
    @OneToMany(mappedBy = "cvr")
    private List<InfoEntity> infoentityList;

    public Company() {
    }

    public Company(String cvr) {
        this.cvr = cvr;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCvr() {
        return cvr;
    }

    public void setCvr(String cvr) {
        this.cvr = cvr;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Integer getNumEmployees() {
        return numEmployees;
    }

    public void setNumEmployees(Integer numEmployees) {
        this.numEmployees = numEmployees;
    }

    public Integer getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Integer marketValue) {
        this.marketValue = marketValue;
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
        hash += (cvr != null ? cvr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.cvr == null && other.cvr != null) || (this.cvr != null && !this.cvr.equals(other.cvr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Company[ cvr=" + cvr + " ]";
    }

}
