package org.mobidics.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@Entity @Table(name = "ratings", schema = "mobidics", catalog = "") @IdClass(RatingsEntityPK.class) public class RatingsEntity
{
    private String methodId;
    private String username;
    private int rating;
    private Timestamp timestamp;
    private Timestamp dateModified;

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

    @Id
    @Column(name = "username", nullable = false, length = 30)
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Basic
    @Column(name = "rating", nullable = false)
    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    @Basic
    @Column(name = "timestamp", nullable = false)
    public Timestamp getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp)
    {
        this.timestamp = timestamp;
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

        RatingsEntity that = (RatingsEntity) o;

        if (rating != that.rating)
        {
            return false;
        }
        if (methodId != null ? !methodId.equals(that.methodId) : that.methodId != null)
        {
            return false;
        }
        if (username != null ? !username.equals(that.username) : that.username != null)
        {
            return false;
        }
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null)
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
        int result = methodId != null ? methodId.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + rating;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        return result;
    }
}
