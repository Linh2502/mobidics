package org.mobidics.data;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.mobidics.model.MethodsDeEntity;

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

    public List<MethodsDeEntity> getAllMethods()
    {
        Session session = SessionUtil.getSession();
        Query query = session.createQuery("from org.mobidics.model.MethodsDeEntity");
        List<MethodsDeEntity> result = query.list();
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
