package org.mobidics.data;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mobidics.model.User;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
public class UserDAO
{
    public UserDAO()
    {
    }

    public User getUserByUsername(String username)
    {
        User result = null;
        Session session = SessionUtil.getSession();
        result = session.get(User.class, username);
        session.close();
        return result;
    }

    public User authenticateUser(String username, String password)
    {
        User result = null;
        Session session = SessionUtil.getSession();
        byte[] bytesOfPassword = new byte[0];
        byte[] digestedPassword = new byte[0];
        try
        {
            bytesOfPassword = password.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            digestedPassword = md.digest(bytesOfPassword);
        }
        catch (UnsupportedEncodingException | NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        Query query = session.getNamedQuery("authenticate");
        String passwordHashString = new BigInteger(1, digestedPassword).toString(16);
        System.out.println(passwordHashString);
        query.setParameter("username", username);
        query.setParameter("password", passwordHashString);
        List<User> queryResult = query.list();
        if (!queryResult.isEmpty())
        {
            result = queryResult.get(0);
        }
        session.close();
        return result;
    }

}
