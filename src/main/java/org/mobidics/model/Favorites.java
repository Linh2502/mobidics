package org.mobidics.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: longbui1992@gmail.com
 */
@Entity @Table(name = "favorites", schema = "mobidics")
public class Favorites
{
    @Id
    @Column(name = "username", nullable = false, length = 100)
    private String username;
    @Id
    @Column(name = "method_id", nullable = false, length = 36)
    private String methodId;
    @Column(name = "date_modified", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateModified;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }


    public String getMethodId()
    {
        return methodId;
    }

    public void setMethodId(String methodId)
    {
        this.methodId = methodId;
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
