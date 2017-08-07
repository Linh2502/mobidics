package org.mobidics.data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mobidics.model.Comment;

import java.util.*;

public class CommentDAO
{
    public CommentDAO()
    {
    }

    public Comment getCommentById(String commentId)
    {
        Session session = SessionUtil.getSession();
        Comment result = session.get(Comment.class, commentId);
        session.close();
        return result;
    }

    public List<Comment> getCommentsOfMethodWithId(String methodId)
    {
        Session session = SessionUtil.getSession();
        List<Comment> result;
        Query query = session.getNamedQuery("getCommentsOfMethod");
        query.setParameter("method_id", methodId);
        result = query.list();
        result = this.sortComments(result);
        session.close();
        return result;
    }

    private List<Comment> sortComments(List<Comment> comments)
    {
        List<Comment> result = new ArrayList<>();
        Map<String, List<Comment>> commentGroups = new HashMap<>();
        initializeCommentGroups(comments, commentGroups);
        groupComments(comments, commentGroups);
        sortCommentsInCommentGroups(commentGroups);
        sortAndFlattenCommentGroups(result, commentGroups);
        return result;
    }

    private void sortAndFlattenCommentGroups(List<Comment> result, Map<String, List<Comment>> commentGroups)
    {
        List<List<Comment>> mapAsList = new ArrayList<>();
        mapAsList.addAll(commentGroups.values());
        mapAsList.sort(Comparator.comparing((List<Comment> commentGroup) ->
                                                    commentGroup.get(0).getCreationDate())
                                 .reversed());
        mapAsList.forEach(result::addAll);
    }

    private void sortCommentsInCommentGroups(Map<String, List<Comment>> rootComments)
    {
        for (String key : rootComments.keySet())
        {
            rootComments.get(key)
                        .sort(Comparator.comparing(Comment::getCreationDate));
        }
    }

    private void groupComments(List<Comment> comments, Map<String, List<Comment>> rootComments)
    {
        for (Comment comment : comments)
        {
            if (comment.getRootCommentId() != null)
            {
                rootComments.get(comment.getRootCommentId()).add(comment);
            }
        }
    }

    private void initializeCommentGroups(List<Comment> comments, Map<String, List<Comment>> rootComments)
    {
        for (Comment comment : comments)
        {
            if (comment.getRootCommentId() == null)
            {
                List<Comment> commentGroup = new ArrayList<>();
                commentGroup.add(comment);
                rootComments.put(comment.getId(), commentGroup);
            }
        }
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
