package org.mobidics.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: longbui1992@gmail.com
 */
@Entity @Table(name = "universities", schema = "mobidics")
public class University
{
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;
    @Basic
    @Column(name = "hsnr", nullable = false)
    private int hsnr;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "city", nullable = false, length = 64)
    private String city;
    @Basic
    @Column(name = "state", nullable = false, length = 32)
    private String state;
    @Basic
    @Column(name = "country", nullable = false, length = 2)
    private String country;
    @Basic
    @Column(name = "operator", nullable = false)
    private String operator;
    @Basic
    @Column(name = "type", nullable = false)
    private String type;
    @Basic
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

    public int getHsnr()
    {
        return hsnr;
    }

    public void setHsnr(int hsnr)
    {
        this.hsnr = hsnr;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getOperator()
    {
        return operator;
    }

    public void setOperator(String operator)
    {
        this.operator = operator;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
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
