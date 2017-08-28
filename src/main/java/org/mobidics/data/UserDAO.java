package org.mobidics.data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mobidics.api.viewmodel.UserViewModel;
import org.mobidics.data.enums.EnumTransformer;
import org.mobidics.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: longbui1992@gmail.com
 */
public class UserDAO
{
    public UserDAO()
    {
    }

    public boolean createUser(UserViewModel userToCreate)
    {
        Session session = SessionUtil.getSession();
        boolean result = true;
        Transaction tx = session.beginTransaction();
        try
        {
            System.out.println(userToCreate);
            Query query = session.getNamedQuery("createUser");
            query.setParameter("username", userToCreate.getUsername());
            query.setParameter("password", messageDigestPassword(userToCreate.getPassword()));
            query.setParameter("email", userToCreate.getEmail());
            query.setParameter("timestamp", new Date().getTime() / 1000);
            query.setParameter("userlevel", 1);
            query.setParameter("language", userToCreate.getLanguage());
            query.setParameter("firstname", userToCreate.getFirstname());
            query.setParameter("lastname", userToCreate.getLastname());
            query.setParameter("gender", userToCreate.getGender() == 0 ? 1 : 2);
            query.setParameter("userstatus", EnumTransformer.transformUserStatus(userToCreate.getUserStatus()));
            query.setParameter("userstatus_other", userToCreate.getUserStatusOther());
            query.setParameter("usertype", EnumTransformer.transformUserType(userToCreate.getUserType()));
            query.setParameter("usertype_other", userToCreate.getUserTypeOther());
            query.setParameter("university_id", userToCreate.getUniversity().getId());
            query.executeUpdate();
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            result = false;
            tx.rollback();
        }
        session.close();
        return result;
    }

    public void updateUser(UserViewModel user)
    {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();

        try
        {
            Query query = session.getNamedQuery("updateUser");
            query.setParameter("username", user.getUsername());
            query.setParameter("email", user.getEmail());
            query.setParameter("timestamp", new Date().getTime() / 1000);
            query.setParameter("language", user.getLanguage());
            query.setParameter("firstname", user.getFirstname());
            query.setParameter("lastname", user.getLastname());
            query.setParameter("gender", user.getGender() == 0 ? 1 : 2);
            query.setParameter("userstatus", EnumTransformer.transformUserStatus(user.getUserStatus()));
            query.setParameter("userstatus_other", user.getUserStatusOther());
            query.setParameter("usertype", EnumTransformer.transformUserType(user.getUserType()));
            query.setParameter("usertype_other", user.getUserTypeOther());
            if (user.getUniversity() != null)
            {
                query.setParameter("university_id", user.getUniversity().getId());
            }
            if (user.getFaculty() != null)
            {
                query.setParameter("faculty_id", user.getFaculty().getNr());
            }
            query.setParameter("birthday", user.getBirthday());
            query.setParameter("department", user.getDepartment());
            query.setParameter("experience", user.getExperience());
            query.executeUpdate();
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            tx.rollback();
        }
        session.close();
    }

    public void deleteUser(String username)
    {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        try
        {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaDelete<User> criteriaDelete = criteriaBuilder.createCriteriaDelete(User.class);
            Root<User> userRoot = criteriaDelete.from(User.class);
            criteriaDelete.where(criteriaBuilder.equal(userRoot.get("username"), username));
            session.createQuery(criteriaDelete).executeUpdate();
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            tx.rollback();
        }
        session.close();
    }

    public void approveUser(String username)
    {
        updateUserApproval(username, true);
    }

    public void disapproveUser(String username)
    {
        updateUserApproval(username, false);
    }

    private void updateUserApproval(String username, boolean newStatus)
    {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        try
        {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaUpdate<User> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(User.class);
            Root<User> userRoot = criteriaUpdate.from(User.class);
            criteriaUpdate.set("approved", newStatus ? 2 : 1)
                          .where(criteriaBuilder.equal(userRoot.get("username"), username));
            session.createQuery(criteriaUpdate).executeUpdate();
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            tx.rollback();
        }
        session.close();
    }

    public List<User> getAllUsers()
    {
        List<User> result = new ArrayList<>();
        Session session = SessionUtil.getSession();
        Query query = session.getNamedQuery("allUsers");
        result = query.list();
        session.close();
        return result;
    }

    public User getUserByUsername(String username)
    {
        User result;
        Session session = SessionUtil.getSession();
        result = session.get(User.class, username);
        session.close();
        return result;
    }

    public User authenticateUser(String username, String password)
    {
        User result = null;
        Session session = SessionUtil.getSession();
        String passwordHashString = messageDigestPassword(password);
        Query query = session.getNamedQuery("authenticate");
        query.setParameter("username", username);
        query.setParameter("password", passwordHashString);
        result = (User) query.getSingleResult();
        session.close();
        return result;
    }

    public void updateLastActiveTimestamp(String username)
    {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.getNamedQuery("updateLastActionDate");
        query.setParameter("timestamp", new Date().getTime() / 1000);
        query.setParameter("username", username);
        query.executeUpdate();
        tx.commit();
        session.close();
    }

    private String messageDigestPassword(String password)
    {
        String result = null;
        byte[] bytesOfPassword;
        byte[] digestedPassword;
        try
        {
            bytesOfPassword = password.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            digestedPassword = md.digest(bytesOfPassword);
            result = new BigInteger(1, digestedPassword).toString(16);
        }
        catch (UnsupportedEncodingException | NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return result;
    }
}
