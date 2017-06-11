package org.mobidics.data.util;

/**
 * Created by Long on 11.06.2017.
 * E-Mail: longbui1992@gmail.com
 */
public class FilenameUtils
{
    public static String generateFilename(String folder, String methodName, int counter)
    {
        return folder + "_" + methodName + "_" + counter + ".jpg";
    }
}
