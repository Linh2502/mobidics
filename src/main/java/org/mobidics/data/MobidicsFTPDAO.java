package org.mobidics.data;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.mobidics.data.exceptions.FTPImageUploadException;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.*;

import static org.mobidics.config.Config.*;

/**
 * Created by Long on 10.06.2017.
 * E-Mail: longbui1992@gmail.com
 */
public class MobidicsFTPDAO
{
    private static final String FTP_FILESPATH = "/mobidics/files/";
    private static final String FTP_FILESPATH_IMAGES = "/images/";

    public void uploadThumbnail(String folder, String imageDataUri) throws FTPImageUploadException
    {
        FTPClient ftpClient = new FTPClient();
        try
        {
            initializeClient(ftpClient);

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
            initializeClient(ftpClient);

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

    public void deleteImages(String folder) throws FTPImageUploadException
    {
        FTPClient ftpClient = new FTPClient();
        try
        {
            initializeClient(ftpClient);
            this.removeDirectory(ftpClient, FTP_FILESPATH + folder, "");
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

    private void initializeClient(FTPClient ftpClient) throws IOException
    {
        ftpClient.connect(FTP_SERVER, FTP_PORT);
        ftpClient.login(FTP_USERNAME, FTP_PASSWORD);
        ftpClient.enterLocalPassiveMode();
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
    }

    private void removeDirectory(FTPClient ftpClient, String parentDir,
                                 String currentDir) throws IOException
    {
        String dirToList = parentDir;
        if (!currentDir.equals(""))
        {
            dirToList += "/" + currentDir;
        }
        FTPFile[] subFiles = ftpClient.listFiles(dirToList);
        if (subFiles != null && subFiles.length > 0)
        {
            for (FTPFile aFile : subFiles)
            {
                String currentFileName = aFile.getName();
                if (currentFileName.equals(".") || currentFileName.equals(".."))
                {
                    // skip parent directory and the directory itself
                    continue;
                }
                String filePath = parentDir + "/" + currentDir + "/"
                        + currentFileName;
                if (currentDir.equals(""))
                {
                    filePath = parentDir + "/" + currentFileName;
                }
                if (aFile.isDirectory())
                {
                    // remove the sub directory
                    removeDirectory(ftpClient, dirToList, currentFileName);
                }
                else
                {
                    // delete the file
                    boolean deleted = ftpClient.deleteFile(filePath);
                    if (deleted)
                    {
                        System.out.println("DELETED the file: " + filePath);
                    }
                    else
                    {
                        System.out.println("CANNOT delete the file: "
                                                   + filePath);
                    }
                }
            }
            // finally, remove the directory itself
            boolean removed = ftpClient.removeDirectory(dirToList);
            if (removed)
            {
                System.out.println("REMOVED the directory: " + dirToList);
            }
            else
            {
                System.out.println("CANNOT remove the directory: " + dirToList);
            }
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
