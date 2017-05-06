package org.mobidics.data;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mobidics.model.MethodsDeEntity;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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

    public List<MethodsDeEntity> getAllMethodsByName(String methodName)
    {
        Session session = SessionUtil.getSession();
        List<MethodsDeEntity> result = null;
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

    public MethodsDeEntity getMethodById(String id)
    {
        Session session = SessionUtil.getSession();
        MethodsDeEntity result = session.get(MethodsDeEntity.class, id);
        session.close();
        return result;
    }
}
