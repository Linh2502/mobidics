package org.mobidics.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@Entity @Table(name = "favorites", schema = "mobidics", catalog = "") @IdClass(FavoritesEntityPK.class) public class FavoritesEntity
{
    private String username;
    private String methodId;
    private Timestamp dateModified;

    @Id
    @Column(name = "username", nullable = false, length = 100)
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Id
    @Column(name = "method_id", nullable = false, length = 36)
    public String getMethodId()
    {
        return methodId;
    }

    public void setMethodId(String methodId)
    {
        this.methodId = methodId;
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        FavoritesEntity that = (FavoritesEntity) o;

        if (username != null ? !username.equals(that.username) : that.username != null)
        {
            return false;
        }
        if (methodId != null ? !methodId.equals(that.methodId) : that.methodId != null)
        {
            return false;
        }
        if (dateModified != null ? !dateModified.equals(that.dateModified) : that.dateModified != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (methodId != null ? methodId.hashCode() : 0);
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        return result;
    }
}
