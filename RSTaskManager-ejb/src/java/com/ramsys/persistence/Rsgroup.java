/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emaramirez1306
 */
@Entity
@Table(name = "RSGROUP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rsgroup.findAll", query = "SELECT DISTINCT r FROM Rsgroup r LEFT JOIN FETCH r.rsuserCollection ORDER BY r.id ASC")
    , @NamedQuery(name = "Rsgroup.findById", query = "SELECT r FROM Rsgroup r WHERE r.id = :id")
    , @NamedQuery(name = "Rsgroup.findByName", query = "SELECT r FROM Rsgroup r WHERE r.name = :name")})
public class Rsgroup implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(generator="seqGen")
    @SequenceGenerator(name="seqGen",sequenceName="USERGROUP_SEQ", allocationSize=1)
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @JoinTable(name = "RSGROUPUSERS", joinColumns = {
        @JoinColumn(name = "RSGROUP_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "RSUSER_ID", referencedColumnName = "ID")})
    @ManyToMany(fetch=FetchType.EAGER)
    private Collection<Rsuser> rsuserCollection;

    public Rsgroup() {
    }

    public Rsgroup(BigDecimal id) {
        this.id = id;
    }

    public Rsgroup(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
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

    public Collection<Rsuser> getRsuserCollection() {
        return rsuserCollection;
    }

    public void setRsuserCollection(Collection<Rsuser> rsuserCollection) {
        this.rsuserCollection = rsuserCollection;
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
        if (!(object instanceof Rsgroup)) {
            return false;
        }
        Rsgroup other = (Rsgroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ramsys.persistence.Rsgroup[ id=" + id + " ]";
    }
    
}
