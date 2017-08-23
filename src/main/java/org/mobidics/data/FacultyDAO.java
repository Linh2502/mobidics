package org.mobidics.data;

import org.hibernate.Session;
import org.mobidics.model.Faculty;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: longbui1992@gmail.com
 */
public class FacultyDAO
{
    public FacultyDAO()
    {
    }

    public List<Faculty> getAllFaculties()
    {
        Session session = SessionUtil.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Faculty> criteriaQuery = criteriaBuilder.createQuery(Faculty.class);
        Root<Faculty> universityRoot = criteriaQuery.from(Faculty.class);
        criteriaQuery.select(universityRoot);
        return session.createQuery(criteriaQuery).getResultList();
    }
}
