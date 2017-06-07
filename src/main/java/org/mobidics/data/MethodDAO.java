package org.mobidics.data;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mobidics.model.MethodGerman;
import org.mobidics.model.MobiDicsMethod;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Long Bui on 27.04.17.
 * E-Mail: longbui1992@gmail.com
 */
public class MethodDAO
{
    public MethodDAO()
    {
    }

    public List<MethodGerman> getAllMethodsByName(String methodName)
    {
        Session session = SessionUtil.getSession();
        List<MethodGerman> result = null;
        Query query = null;
        if (methodName.isEmpty())
        {
            query = session.getNamedQuery("getAllMethods");
        }
        else
        {
            query = session.getNamedQuery("getAllMethodsByName")
                           .setParameter("name", methodName);
        }
        result = query.list();
        session.close();
        return result;
    }

    public MethodGerman getMethodById(String id)
    {
        Session session = SessionUtil.getSession();
        MethodGerman result = session.get(MethodGerman.class, id);
        session.close();
        return result;
    }

    public Set<String> getFavoriteIdsOfUsername(String username)
    {
        Set<String> result;
        Session session = SessionUtil.getSession();
        Query namedQuery = session.getNamedNativeQuery("getFavoriteIdsOfUser");
        namedQuery.setParameter("username", username);
        result = new HashSet<>(namedQuery.list());
        session.close();
        return result;
    }
}
