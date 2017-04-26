package org.mobidics.data;

import org.hibernate.Session;
import org.mobidics.model.UniversitiesEntity;

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
        UniversitiesEntity universitiesEntity = session.load(UniversitiesEntity.class, id);
        return universitiesEntity.getName();
    }
}
