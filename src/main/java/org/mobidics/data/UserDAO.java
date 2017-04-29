package org.mobidics.data;

import org.hibernate.Session;
import org.mobidics.model.User;

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

}
