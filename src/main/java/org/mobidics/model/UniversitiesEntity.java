package org.mobidics.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@Entity @Table(name = "universities", schema = "mobidics", catalog = "") public class UniversitiesEntity
{
    private String id;
    private int hsnr;
    private String name;
    private String city;
    private String state;
    private String country;
    private String operator;
    private String type;
    private Timestamp dateModified;

    @Id
    @Column(name = "id", nullable = false, length = 36)
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "hsnr", nullable = false)
    public int getHsnr()
    {
        return hsnr;
    }

    public void setHsnr(int hsnr)
    {
        this.hsnr = hsnr;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 64)
    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    @Basic
    @Column(name = "state", nullable = false, length = 32)
    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    @Basic
    @Column(name = "country", nullable = false, length = 2)
    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    @Basic
    @Column(name = "operator", nullable = false)
    public String getOperator()
    {
        return operator;
    }

    public void setOperator(String operator)
    {
        this.operator = operator;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    @Basic
    @Column(name = "date_modified", nullable = false)
    public Timestamp getDateModified()
    {
        return dateModified;
    }

    public void setDateModified(Timestamp dateModified)
    {
        this.dateModified = dateModified;
    }
}
