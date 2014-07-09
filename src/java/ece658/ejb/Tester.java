/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ece658.ejb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "TESTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tester.findAll", query = "SELECT t FROM Tester t order by t.id"),
    @NamedQuery(name = "Tester.findById", query = "SELECT t FROM Tester t WHERE t.id = :id"),
    @NamedQuery(name = "Tester.findByName", query = "SELECT t FROM Tester t WHERE lower(t.name) = :name order by t.id"),
    @NamedQuery(name = "Tester.findByDept", query = "SELECT t FROM Tester t WHERE t.dept = :dept"),
    @NamedQuery(name = "Tester.findByAge", query = "SELECT t FROM Tester t WHERE t.age = :age"),
    @NamedQuery(name = "Tester.findByEmail", query = "SELECT t FROM Tester t WHERE t.email = :email"),
    @NamedQuery(name = "Tester.findByPhone", query = "SELECT t FROM Tester t WHERE t.phone = :phone"),
    @NamedQuery(name = "Tester.findByStatus", query = "SELECT t FROM Tester t WHERE lower(t.status) = :status order by t.id"),
    @NamedQuery(name = "Tester.findBySkype", query = "SELECT t FROM Tester t WHERE t.skype = :skype")})
public class Tester implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "NAME")
    private String name;
    @Size(max = 50)
    @Column(name = "DEPT")
    private String dept;
    @Column(name = "AGE")
    private Integer age;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE")
    private String phone;
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 20)
    @Column(name = "SKYPE")
    private String skype;

    public Tester() {
    }

    public Tester(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
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
        if (!(object instanceof Tester)) {
            return false;
        }
        Tester other = (Tester) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ece658.ejb.Tester[ id=" + id + " ]";
    }
    
}
