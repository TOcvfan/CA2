package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private InfoEntity ie;
    //InfoEntity ie = new InfoEntity();
    
    public Phone() {
    }

    public Phone(String pnumber, String description, InfoEntity ie) {
        this.pnumber = pnumber;
        this.description = description;
        this.ie = ie;
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

    public InfoEntity getIe() {
        return ie;
    }

    public void setIe(InfoEntity id) {
        this.ie = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pnumber != null ? pnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the ie fields are not set
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
