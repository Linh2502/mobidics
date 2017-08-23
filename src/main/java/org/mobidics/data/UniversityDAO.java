package org.mobidics.data;

import org.hibernate.Session;
import org.mobidics.model.Faculty;
import org.mobidics.model.University;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: longbui1992@gmail.com
 */
public class UniversityDAO
{
    public UniversityDAO()
    {
    }

    public List<University> getAllUniversites()
    {
        Session session = SessionUtil.getSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<University> criteriaQuery = criteriaBuilder.createQuery(University.class);
        Root<University> universityRoot = criteriaQuery.from(University.class);
        criteriaQuery.select(universityRoot);
        return session.createQuery(criteriaQuery).getResultList();
    }
}
