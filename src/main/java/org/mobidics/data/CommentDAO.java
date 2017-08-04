package org.mobidics.data;

import org.hibernate.Session;
import org.mobidics.model.CommentsEntity;

import java.util.ArrayList;
import java.util.List;

public class CommentDAO
{
    public CommentDAO()
    {
    }

    public List<CommentsEntity> getComments(String methodId)
    {
        Session session = SessionUtil.getSession();
        List<CommentsEntity> result;

        session.close();
        return new ArrayList<>();
    }

    public boolean addComment(String methodId, CommentsEntity comment)
    {
        Session session = SessionUtil.getSession();
        List<CommentsEntity> result;

        session.close();
        return true;
    }

    public boolean deleteComment(String methodId, String commentId)
    {
        Session session = SessionUtil.getSession();
        List<CommentsEntity> result;

        session.close();
        return true;
    }

}
