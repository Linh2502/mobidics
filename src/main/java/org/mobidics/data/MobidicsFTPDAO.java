package org.mobidics.data;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.mobidics.api.viewmodel.MethodViewModel;
import org.mobidics.data.util.FilenameUtils;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

/**
 * Created by Long on 10.06.2017.
 * E-Mail: longbui1992@gmail.com
 */
public class MobidicsFTPDAO
{
    private final String FTP_SERVER = "localhost";
    private final int FTP_PORT = 21;
    private final String FTP_USERNAME = "admin";
    private final String FTP_PASSWORD = "lb92bl29";
    private final String FTP_FILESPATH = "/mobidics/files/";
    private final String FTP_FILESPATH_IMAGES = "/images/";

    public void uploadThumbnail(String folder, String imageDataUri) throws FTPImageUploadException
    {
        FTPClient ftpClient = new FTPClient();
        try
        {
            ftpClient.connect(FTP_SERVER, FTP_PORT);
            ftpClient.login(FTP_USERNAME, FTP_PASSWORD);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            ftpClient.makeDirectory(FTP_FILESPATH + folder);
            String thumbnailFileName = FTP_FILESPATH + folder + "/default.png";
            byte[] imagedata = DatatypeConverter.parseBase64Binary(imageDataUri.substring(imageDataUri.indexOf(",") + 1));
            ImageIO.setUseCache(false);
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
            OutputStream outputStream = ftpClient.storeFileStream(thumbnailFileName);
            ImageIO.write(bufferedImage, "png", outputStream);
            outputStream.close();
            boolean completed = ftpClient.completePendingCommand();
            if (completed)
            {
                System.out.println("File Upload complete!");
            }
            else
            {
                throw new FTPImageUploadException();
            }
        }
        catch (IOException ex)
        {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
        finally
        {
            gracefullyDisconnect(ftpClient);
        }
    }

    public void uploadImage(String folder, String filename, String imageDataUri)
            throws FTPImageUploadException
    {
        FTPClient ftpClient = new FTPClient();
        try
        {
            ftpClient.connect(FTP_SERVER, FTP_PORT);
            ftpClient.login(FTP_USERNAME, FTP_PASSWORD);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            ftpClient.makeDirectory(FTP_FILESPATH + folder + FTP_FILESPATH_IMAGES);
            String imageFileName = FTP_FILESPATH + folder + "/" + FTP_FILESPATH_IMAGES + filename;
            byte[] imagedata = DatatypeConverter.parseBase64Binary(imageDataUri.substring(imageDataUri.indexOf(",") + 1));
            ImageIO.setUseCache(false);
            BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagedata));
            OutputStream outputStream = ftpClient.storeFileStream(imageFileName);
            ImageIO.write(bufferedImage, "jpg", outputStream);
            outputStream.close();
            boolean completed = ftpClient.completePendingCommand();
            if (completed)
            {
                System.out.println("File Upload complete!");
            }
            else
            {
                throw new FTPImageUploadException();
            }
        }
        catch (IOException ex)
        {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
        }
        finally
        {
            gracefullyDisconnect(ftpClient);
        }
    }

    private void gracefullyDisconnect(FTPClient ftpClient)
    {
        try
        {
            if (ftpClient.isConnected())
            {
                ftpClient.logout();
                ftpClient.disconnect();
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
