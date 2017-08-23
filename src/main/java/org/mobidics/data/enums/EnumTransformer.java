package org.mobidics.data.enums;

public class EnumTransformer
{
    public static Integer transformUserStatus(int userStatus)
    {
        switch (userStatus)
        {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 99:
                return 4;
            default:
                return null;
        }
    }

    public static Integer transformUserType(int userType)
    {
        switch (userType)
        {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 99:
                return 5;
            default:
                return null;
        }
    }
}
