package org.mobidics.api.viewmodel.enums;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: longbui1992@gmail.com
 */
public class UserEnums
{
    public static String getUserStatus(int userStatus)
    {
        switch (userStatus)
        {
            case 0:
                return "Prof.";
            case 1:
                return "Dr.";
            case 2:
                return "Dipl.";
            default:
                return "Anderes";
        }
    }
}
