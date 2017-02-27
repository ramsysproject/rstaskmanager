/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramsys.persistence;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emaramirez1306
 */
@Entity
@Table(name = "TASK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t")
    , @NamedQuery(name = "Task.findById", query = "SELECT t FROM Task t WHERE t.id = :id")
    , @NamedQuery(name = "Task.findByName", query = "SELECT t FROM Task t WHERE t.name = :name")
    , @NamedQuery(name = "Task.findByPlannedstart", query = "SELECT t FROM Task t WHERE t.plannedstart = :plannedstart")
    , @NamedQuery(name = "Task.findByPlannedend", query = "SELECT t FROM Task t WHERE t.plannedend = :plannedend")
    , @NamedQuery(name = "Task.findByCompletiondate", query = "SELECT t FROM Task t WHERE t.completiondate = :completiondate")})
public class Task implements Serializable {

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
    @Column(name = "PLANNEDSTART")
    @Temporal(TemporalType.TIMESTAMP)
    private Date plannedstart;
    @Column(name = "PLANNEDEND")
    @Temporal(TemporalType.TIMESTAMP)
    private Date plannedend;
    @Column(name = "COMPLETIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completiondate;
    @JoinColumn(name = "RSUSER", referencedColumnName = "ID")
    @ManyToOne
    private Rsuser rsuser;
    @JoinColumn(name = "TASKSTATUS", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Taskstatus taskstatus;
    @JoinColumn(name = "TASKTYPE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Tasktype tasktype;

    public Task() {
    }

    public Task(BigDecimal id) {
        this.id = id;
    }

    public Task(BigDecimal id, String name) {
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

    public Date getPlannedstart() {
        return plannedstart;
    }

    public void setPlannedstart(Date plannedstart) {
        this.plannedstart = plannedstart;
    }

    public Date getPlannedend() {
        return plannedend;
    }

    public void setPlannedend(Date plannedend) {
        this.plannedend = plannedend;
    }

    public Date getCompletiondate() {
        return completiondate;
    }

    public void setCompletiondate(Date completiondate) {
        this.completiondate = completiondate;
    }

    public Rsuser getRsuser() {
        return rsuser;
    }

    public void setRsuser(Rsuser rsuser) {
        this.rsuser = rsuser;
    }

    public Taskstatus getTaskstatus() {
        return taskstatus;
    }

    public void setTaskstatus(Taskstatus taskstatus) {
        this.taskstatus = taskstatus;
    }

    public Tasktype getTasktype() {
        return tasktype;
    }

    public void setTasktype(Tasktype tasktype) {
        this.tasktype = tasktype;
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
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ramsys.persistence.Task[ id=" + id + " ]";
    }
    
}
