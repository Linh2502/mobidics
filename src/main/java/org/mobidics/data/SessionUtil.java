package org.mobidics.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.InputStream;

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
        configuration.configure("hibernate.cfg.xml")
                     .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                     .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mobidics?serverTimezone=GMT")
                     .setProperty("hibernate.connection.username", "root")
                     .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                     .setProperty("hibernate.show_sql", "true")
                     .setProperty("hibernate.format_sql", "true");
        sessionFactory = configuration.buildSessionFactory();
    }

    public static Session getSession()
    {
        return getInstance().sessionFactory.openSession();
    }
}