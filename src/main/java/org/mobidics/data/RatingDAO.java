package org.mobidics.data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mobidics.model.Rating;
import org.mobidics.model.RatingPK;

import java.util.Date;
import java.util.List;

public class RatingDAO
{
    public RatingDAO()
    {
    }

    public Rating getRatingOfUserOnMethodWithId(String username, String methodId)
    {
        Rating result;
        Session session = SessionUtil.getSession();
        result = session.get(Rating.class, new RatingPK(methodId, username));
        return result;
    }

    public boolean updateRatingOfUserOnMethodWithId(String username, String methodId, int ratingValue)
    {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        boolean transactionSuccessful = true;
        try
        {
            Rating newRating = new Rating(methodId, username, ratingValue, new Date(), new Date());
            session.saveOrUpdate(newRating);
            int newAvgRating = calculateAvgRating(methodId, session);
            updateMethodUserrating(methodId, session, newAvgRating);
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            transactionSuccessful = false;
            tx.rollback();
        }
        return transactionSuccessful;
    }

    private void updateMethodUserrating(String methodId, Session session, int newAvgRating)
    {
        Query query1 = session.getNamedNativeQuery("updateMethodDeRating");
        query1.setParameter("methodId", methodId);
        query1.setParameter("userrating", newAvgRating);
        query1.executeUpdate();
    }

    private int calculateAvgRating(String methodId, Session session)
    {
        Query query = session.getNamedQuery("getRatingsOfMethodWithId");
        query.setParameter("methodId", methodId);
        List<Rating> allMethodRatings = query.list();
        int ratingSum = 0;
        for (Rating rating : allMethodRatings)
        {
            ratingSum += rating.getRating();
        }
        return ratingSum / allMethodRatings.size();
    }
}
