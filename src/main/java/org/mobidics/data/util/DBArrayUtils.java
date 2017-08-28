package org.mobidics.data.util;

import java.util.Arrays;

public class DBArrayUtils
{
    public static String intArrayToString(int[] array)
    {
        if (array != null && array.length > 0)
        {
            return String.join(":", Arrays.toString(array).split("[\\[\\]]")[1].split(", "));
        }
        return "";
    }
}
