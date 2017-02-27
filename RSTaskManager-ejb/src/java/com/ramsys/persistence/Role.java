/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
    , @NamedQuery(name = "Role.findById", query = "SELECT r FROM Role r WHERE r.id = :id")
    , @NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.name = :name")
    , @NamedQuery(name = "Role.findByDescription", query = "SELECT r FROM Role r WHERE r.description = :description")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "ROLESTATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Rolestatus rolestatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<Roleelements> roleelementsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "role")
    private List<Rsuserroles> rsuserrolesList;

    public Role() {
    }

    public Role(BigDecimal id) {
        this.id = id;
    }

    public Role(BigDecimal id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Rolestatus getRolestatus() {
        return rolestatus;
    }

    public void setRolestatus(Rolestatus rolestatus) {
        this.rolestatus = rolestatus;
    }

    @XmlTransient
    public List<Roleelements> getRoleelementsList() {
        return roleelementsList;
    }

    public void setRoleelementsList(List<Roleelements> roleelementsList) {
        this.roleelementsList = roleelementsList;
    }

    @XmlTransient
    public List<Rsuserroles> getRsuserrolesList() {
        return rsuserrolesList;
    }

    public void setRsuserrolesList(List<Rsuserroles> rsuserrolesList) {
        this.rsuserrolesList = rsuserrolesList;
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
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ramsys.persistence.Role[ id=" + id + " ]";
    }
    
}
