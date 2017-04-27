package org.mobidics.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
public class SessionUtil
{

    private static SessionUtil instance = null;
    private SessionFactory sessionFactory;

    public static SessionUtil getInstance()
    {
        if (instance == null)
        {
            instance = new SessionUtil();
        }
        return instance;
    }

    private SessionUtil()
    {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession()
    {
        return getInstance().sessionFactory.openSession();
    }
}