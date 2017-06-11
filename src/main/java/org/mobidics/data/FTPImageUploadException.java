package org.mobidics.data;

/**
 * Created by Long on 11.06.2017.
 * E-Mail: longbui1992@gmail.com
 */
public class FTPImageUploadException extends Exception
{
    public FTPImageUploadException()
    {
        super("Error occured while uploading image through FTP!");
    }
}
