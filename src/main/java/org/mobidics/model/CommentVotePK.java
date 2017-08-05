package org.mobidics.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: longbui1992@gmail.com
 */
public class CommentVotePK implements Serializable
{
    private String username;
    private String commentId;

    @Column(name = "username", nullable = false, length = 30)
    @Id
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Column(name = "comment_id", nullable = false, length = 36)
    @Id
    public String getCommentId()
    {
        return commentId;
    }

    public void setCommentId(String commentId)
    {
        this.commentId = commentId;
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

        CommentVotePK that = (CommentVotePK) o;

        if (username != null ? !username.equals(that.username) : that.username != null)
        {
            return false;
        }
        if (commentId != null ? !commentId.equals(that.commentId) : that.commentId != null)
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
        return result;
    }
}
