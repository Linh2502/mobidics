package org.mobidics.data;

import org.hibernate.Session;
import org.mobidics.model.University;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
public class UniversityDAO
{
    public UniversityDAO()
    {
    }

    public String getUniversityNameById(String id)
    {
        Session session = SessionUtil.getSession();
        University university = session.get(University.class, id);
        String result = university.getName();
        session.close();
        return result;
    }
}
