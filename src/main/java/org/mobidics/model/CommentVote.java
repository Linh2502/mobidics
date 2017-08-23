package org.mobidics.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: longbui1992@gmail.com
 */
@Entity @Table(name = "commentvotes", schema = "mobidics")
@IdClass(CommentVotePK.class)
public class CommentVote
{
    private String username;
    private String commentId;
    private int value;
    private Date dateModified;

    public CommentVote()
    {
    }

    public CommentVote(String username, String commentId, int value)
    {
        this.username = username;
        this.commentId = commentId;
        this.value = value;
        this.dateModified = new Date();
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
    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    @Basic
    @Column(name = "date_modified", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateModified()
    {
        return dateModified;
    }

    public void setDateModified(Date dateModified)
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

        CommentVote that = (CommentVote) o;

        if (value != that.value)
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
        return dateModified != null ? dateModified.equals(that.dateModified) : that.dateModified == null;
    }

    @Override
    public int hashCode()
    {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (commentId != null ? commentId.hashCode() : 0);
        result = 31 * result + (int) value;
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        return result;
    }
}
