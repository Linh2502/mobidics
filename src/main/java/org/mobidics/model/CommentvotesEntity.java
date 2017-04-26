package org.mobidics.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@Entity @Table(name = "commentvotes", schema = "mobidics", catalog = "") @IdClass(CommentvotesEntityPK.class) public class CommentvotesEntity
{
    private String username;
    private String commentId;
    private byte value;
    private Timestamp dateModified;
    private boolean deleted;

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

    @Id
    @Column(name = "comment_id", nullable = false, length = 36)
    public String getCommentId()
    {
        return commentId;
    }

    public void setCommentId(String commentId)
    {
        this.commentId = commentId;
    }

    @Basic
    @Column(name = "value", nullable = false)
    public byte getValue()
    {
        return value;
    }

    public void setValue(byte value)
    {
        this.value = value;
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

    @Basic
    @Column(name = "deleted", nullable = false)
    public boolean isDeleted()
    {
        return deleted;
    }

    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
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

        CommentvotesEntity that = (CommentvotesEntity) o;

        if (value != that.value)
        {
            return false;
        }
        if (deleted != that.deleted)
        {
            return false;
        }
        if (username != null ? !username.equals(that.username) : that.username != null)
        {
            return false;
        }
        if (commentId != null ? !commentId.equals(that.commentId) : that.commentId != null)
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
        result = 31 * result + (commentId != null ? commentId.hashCode() : 0);
        result = 31 * result + (int) value;
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        result = 31 * result + (deleted ? 1 : 0);
        return result;
    }
}
