/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author emaramirez1306
 */
@Entity
@Table(name = "RSUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rsuser.findAll", query = "SELECT r FROM Rsuser r")
    , @NamedQuery(name = "Rsuser.findById", query = "SELECT r FROM Rsuser r WHERE r.id = :id")
    , @NamedQuery(name = "Rsuser.findByName", query = "SELECT r FROM Rsuser r WHERE r.name = :name")
    , @NamedQuery(name = "Rsuser.findByStatusSw", query = "SELECT r FROM Rsuser r WHERE r.statusSw = :statusSw")})
public class Rsuser implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS_SW")
    private BigInteger statusSw;
    @ManyToMany(mappedBy = "rsuserCollection")
    private Collection<Rsgroup> rsgroupCollection;

    public Rsuser() {
    }

    public Rsuser(BigDecimal id) {
        this.id = id;
    }

    public Rsuser(BigDecimal id, String name, BigInteger statusSw) {
        this.id = id;
        this.name = name;
        this.statusSw = statusSw;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getStatusSw() {
        return statusSw;
    }

    public void setStatusSw(BigInteger statusSw) {
        this.statusSw = statusSw;
    }

    @XmlTransient
    public Collection<Rsgroup> getRsgroupCollection() {
        return rsgroupCollection;
    }

    public void setRsgroupCollection(Collection<Rsgroup> rsgroupCollection) {
        this.rsgroupCollection = rsgroupCollection;
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
        if (!(object instanceof Rsuser)) {
            return false;
        }
        Rsuser other = (Rsuser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ramsys.persistence.Rsuser[ id=" + id + " ]";
    }
    
}
