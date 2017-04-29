package org.mobidics.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@Entity @Table(name = "faculties", schema = "mobidics")
public class Faculty implements Serializable
{
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Column(name = "nr", nullable = false)
    private int nr;
    @Column(name = "name")
    private String name;
    @Column(name = "branch", nullable = false)
    private String branch;
    @Column(name = "date_modified", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateModified;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public int getNr()
    {
        return nr;
    }

    public void setNr(int nr)
    {
        this.nr = nr;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getBranch()
    {
        return branch;
    }

    public void setBranch(String branch)
    {
        this.branch = branch;
    }

    public Date getDateModified()
    {
        return dateModified;
    }

    public void setDateModified(Date dateModified)
    {
        this.dateModified = dateModified;
    }
}
