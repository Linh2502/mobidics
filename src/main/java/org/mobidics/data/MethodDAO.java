package org.mobidics.data;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mobidics.model.MethodGerman;

import java.util.List;

/**
 * Created by Long Bui on 27.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
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
}
