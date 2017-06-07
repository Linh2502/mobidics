package org.mobidics.api.filter.auth;

/**
 * Created by Long Bui on 01.03.17.
 * E-Mail: longbui1992@gmail.com
 */
public class Roles
{
    public static final String ADMIN = "admin";
    public static final String USER = "user";
    public static final String TRIAL = "trial";
    public static final String UNSUPPORTED = "unsupported";

    public static String getNameOfRole(int role)
    {
        switch (role)
        {
            case 1:
                return TRIAL;
            case 2:
                return USER;
            case 9:
                return ADMIN;
            default:
                return UNSUPPORTED;
        }
    }
}
