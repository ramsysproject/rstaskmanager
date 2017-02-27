/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emaramirez1306
 */
@Entity
@Table(name = "RSUSERROLES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rsuserroles.findAll", query = "SELECT r FROM Rsuserroles r")
    , @NamedQuery(name = "Rsuserroles.findById", query = "SELECT r FROM Rsuserroles r WHERE r.id = :id")})
public class Rsuserroles implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "ROLE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Role role;
    @JoinColumn(name = "RSUSER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Rsuser rsuser;

    public Rsuserroles() {
    }

    public Rsuserroles(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Rsuser getRsuser() {
        return rsuser;
    }

    public void setRsuser(Rsuser rsuser) {
        this.rsuser = rsuser;
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
        if (!(object instanceof Rsuserroles)) {
            return false;
        }
        Rsuserroles other = (Rsuserroles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ramsys.persistence.Rsuserroles[ id=" + id + " ]";
    }
    
}
