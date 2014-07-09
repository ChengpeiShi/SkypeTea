/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ece658.ejb;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wanfeiliu, b27lu
 */
@Entity
@Table(name = "MACHINE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Machine.findAll", query = "SELECT m FROM Machine m order by m.id"),
    @NamedQuery(name = "Machine.findById", query = "SELECT m FROM Machine m WHERE m.id = :id order by m.id"),
    @NamedQuery(name = "Machine.findByPlatform", query = "SELECT m FROM Machine m WHERE lower(m.platform) LIKE (:platform) order by m.id"),
    @NamedQuery(name = "Machine.findByPowerstate", query = "SELECT m FROM Machine m WHERE lower(m.powerstate) = :powerstate order by m.id"),
    @NamedQuery(name = "Machine.findByOwner", query = "SELECT m FROM Machine m WHERE m.owner = :owner")})
public class Machine implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "PLATFORM")
    private String platform;
    @Size(max = 20)
    @Column(name = "POWERSTATE")
    private String powerstate;
    @Size(max = 50)
    @Column(name = "OWNER")
    private String owner;

    public Machine() {
    }

    public Machine(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPowerstate() {
        return powerstate;
    }

    public void setPowerstate(String powerstate) {
        this.powerstate = powerstate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
        if (!(object instanceof Machine)) {
            return false;
        }
        Machine other = (Machine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ece658.ejb.Machine[ id=" + id + " ]";
    }
    
}
