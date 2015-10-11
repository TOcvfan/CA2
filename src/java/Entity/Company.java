package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TOcvfan
 */
@Entity
@Table(name = "company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findById", query = "SELECT c FROM Company c WHERE c.ie = :id"),
    @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name"),
    @NamedQuery(name = "Company.findByDescription", query = "SELECT c FROM Company c WHERE c.description = :description"),
    @NamedQuery(name = "Company.findByCvr", query = "SELECT c FROM Company c WHERE c.cvr = :cvr"),
    @NamedQuery(name = "Company.findByZip", query = "SELECT c FROM Company c WHERE c.infoEntity.adrId.zip = :zip"),
    @NamedQuery(name = "Company.findByNumEmployees", query = "SELECT c FROM Company c WHERE c.numEmployees = :numEmployees"),
    @NamedQuery(name = "Company.findByMarketValue", query = "SELECT c FROM Company c WHERE c.marketValue = :marketValue")})
    
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer ie;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "cvr")
    private String cvr;
    @Column(name = "NumEmployees")
    private Integer numEmployees;
    @Column(name = "MarketValue")
    private Integer marketValue;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private InfoEntity infoEntity;

    public Company() {
    }

    public Company(Integer ie) {
        this.ie = ie;
    }

    public Company(Integer ie, String name, String description, String cvr, Integer numEmployees, Integer marketValue) {
        this.ie = ie;
        this.name = name;
        this.description = description;
        this.cvr = cvr;
        this.numEmployees = numEmployees;
        this.marketValue = marketValue;
        
    }
    
    

    public Integer getIe() {
        return ie;
    }

    public void setIe(Integer ie) {
        this.ie = ie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public InfoEntity getInfoEntity() {
        return infoEntity;
    }

    public void setInfoEntity(InfoEntity infoEntity) {
        this.infoEntity = infoEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ie != null ? ie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the ie fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.ie == null && other.ie != null) || (this.ie != null && !this.ie.equals(other.ie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Company[ id=" + ie + " ]";
    }

}
