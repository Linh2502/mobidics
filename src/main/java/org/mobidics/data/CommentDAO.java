package org.mobidics.data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mobidics.model.Comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CommentDAO
{
    public CommentDAO()
    {
    }

    public List<Comment> getComments(String methodId)
    {
        Session session = SessionUtil.getSession();
        List<Comment> result;
        Query query = session.getNamedQuery("getCommentsOfMethod");
        query.setParameter("method_id", methodId);
        result = query.list();
        session.close();
        return result;
    }

    public boolean addComment(String methodId, String username, Comment comment)
    {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        boolean transactionSuccessful = true;
        try
        {
            Query query = session.getNamedNativeQuery("insertComment");
            query.setParameter("id", String.valueOf(UUID.randomUUID()));
            query.setParameter("methodId", methodId);
            query.setParameter("timestamp", new Date());
            query.setParameter("username", username);
            query.setParameter("text", comment.getText());
            query.setParameter("inResponseTo", comment.getInResponseTo());
            query.setParameter("rootComment", comment.getRootCommentId());
            query.executeUpdate();
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            transactionSuccessful = false;
            tx.rollback();
        }
        session.close();
        return transactionSuccessful;
    }

    public boolean deleteComment(String commentId)
    {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        boolean transactionSuccessful = true;
        try
        {
            Comment commentToDelete = session.get(Comment.class, commentId);
            session.delete(commentToDelete);
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            transactionSuccessful = false;
            tx.rollback();
        }
        session.close();
        return transactionSuccessful;
    }

}
