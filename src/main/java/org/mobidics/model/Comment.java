package org.mobidics.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: longbui1992@gmail.com
 */
@Entity @Table(name = "comments", schema = "mobidics", catalog = "")
public class Comment
{
    private String id;
    private String methodId;
    private Date creationDate;
    private String username;
    private String text;
    private String inResponseTo;
    private String rootCommentId;
    private int thumbsUp;
    private int thumbsDown;
    private int thumbsTotal;
    private Date dateModified;

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
    @Column(name = "timestamp", nullable = true)
    @Temporal(TemporalType.DATE)
    public Date getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }

    @Basic
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
    @Column(name = "text", nullable = false, length = -1)
    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    @Basic
    @Column(name = "in_response_to", nullable = true, length = 36)
    public String getInResponseTo()
    {
        return inResponseTo;
    }

    public void setInResponseTo(String inResponseTo)
    {
        this.inResponseTo = inResponseTo;
    }

    @Basic
    @Column(name = "root_comment_id", nullable = true, length = 36)
    public String getRootCommentId()
    {
        return rootCommentId;
    }

    public void setRootCommentId(String rootCommentId)
    {
        this.rootCommentId = rootCommentId;
    }

    @Basic
    @Column(name = "thumbsup", nullable = false)
    public int getThumbsUp()
    {
        return thumbsUp;
    }

    public void setThumbsUp(int thumbsUp)
    {
        this.thumbsUp = thumbsUp;
    }

    @Basic
    @Column(name = "thumbsdown", nullable = false)
    public int getThumbsDown()
    {
        return thumbsDown;
    }

    public void setThumbsDown(int thumbsDown)
    {
        this.thumbsDown = thumbsDown;
    }

    @Basic
    @Column(name = "thumbstotal", nullable = false)
    public int getThumbsTotal()
    {
        return thumbsTotal;
    }

    public void setThumbsTotal(int thumbsTotal)
    {
        this.thumbsTotal = thumbsTotal;
    }

    @Basic
    @Column(name = "date_modified", nullable = false)
    @Temporal(TemporalType.DATE)
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

        Comment that = (Comment) o;

        if (thumbsUp != that.thumbsUp)
        {
            return false;
        }
        if (thumbsDown != that.thumbsDown)
        {
            return false;
        }
        if (thumbsTotal != that.thumbsTotal)
        {
            return false;
        }
        if (id != null ? !id.equals(that.id) : that.id != null)
        {
            return false;
        }
        if (methodId != null ? !methodId.equals(that.methodId) : that.methodId != null)
        {
            return false;
        }
        if (creationDate != null ? !creationDate.equals(that.creationDate) : that.creationDate != null)
        {
            return false;
        }
        if (username != null ? !username.equals(that.username) : that.username != null)
        {
            return false;
        }
        if (text != null ? !text.equals(that.text) : that.text != null)
        {
            return false;
        }
        if (inResponseTo != null ? !inResponseTo.equals(that.inResponseTo) : that.inResponseTo != null)
        {
            return false;
        }
        if (rootCommentId != null ? !rootCommentId.equals(that.rootCommentId) : that.rootCommentId != null)
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
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (methodId != null ? methodId.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (inResponseTo != null ? inResponseTo.hashCode() : 0);
        result = 31 * result + (rootCommentId != null ? rootCommentId.hashCode() : 0);
        result = 31 * result + thumbsUp;
        result = 31 * result + thumbsDown;
        result = 31 * result + thumbsTotal;
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        return result;
    }
}
