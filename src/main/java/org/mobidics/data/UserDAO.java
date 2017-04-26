package org.mobidics.data;

import org.hibernate.Session;
import org.mobidics.model.User;

import javax.persistence.Query;
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
        Session session = SessionUtil.getSession();
        return session.load(User.class, username);
    }

}
