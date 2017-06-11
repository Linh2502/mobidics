package org.mobidics.data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mobidics.api.viewmodel.MethodViewModel;
import org.mobidics.data.util.FilenameUtils;
import org.mobidics.model.MethodGerman;
import org.mobidics.model.MobidicsFile;

import java.util.*;

/**
 * Created by Long Bui on 27.04.17.
 * E-Mail: longbui1992@gmail.com
 */
public class MethodDAO
{
    public MethodDAO()
    {
    }

    public List<MethodGerman> getAllMethodsByName(String methodName)
    {
        Session session = SessionUtil.getSession();
        List<MethodGerman> result = null;
        Query query;
        if (methodName.isEmpty())
        {
            query = session.getNamedQuery("getAllMethods");
        }
        else
        {
            query = session.getNamedQuery("getAllMethodsByName")
                           .setParameter("name", methodName);
        }
        result = query.list();
        session.close();
        return result;
    }

    public MethodGerman getMethodById(String id)
    {
        Session session = SessionUtil.getSession();
        MethodGerman result = session.get(MethodGerman.class, id);
        session.close();
        return result;
    }

    public Set<String> getFavoriteIdsOfUsername(String username)
    {
        Set<String> result;
        Session session = SessionUtil.getSession();
        Query namedQuery = session.getNamedNativeQuery("getFavoriteIdsOfUser");
        namedQuery.setParameter("username", username);
        result = new HashSet<>(namedQuery.list());
        session.close();
        return result;
    }

    public boolean addMethod(MethodViewModel newMethod)
    {
        boolean transactionSuccessful = true;
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        // TODO
        try
        {
            String newUuid = String.valueOf(UUID.randomUUID());
            String folder = new Date().getTime() + "." + (int) (Math.random() * 100);
            Query namedQuery = session.getNamedNativeQuery("insertMethod_" + newMethod.getLanguage());
            namedQuery.setParameter(0, newUuid);
            namedQuery.setParameter(1, newMethod.getLanguage());
            namedQuery.setParameter(2, newMethod.getTitle());
            namedQuery.setParameter(3, newMethod.getAlternativeTitles());
            namedQuery.setParameter(4, newMethod.getSocialForm());
            namedQuery.setParameter(5, newMethod.getPhase());
            namedQuery.setParameter(6, newMethod.getSubPhase());
            namedQuery.setParameter(7, newMethod.getResult());
            namedQuery.setParameter(8, newMethod.getGroupType());
            namedQuery.setParameter(9, newMethod.getCourseType());
            namedQuery.setParameter(10, newMethod.getGroupSizeMin());
            namedQuery.setParameter(11, newMethod.getGroupSizeMax());
            namedQuery.setParameter(12, newMethod.getGroupSizeComment());
            namedQuery.setParameter(13, newMethod.getSeating());
            namedQuery.setParameter(14, newMethod.getTimeMin());
            namedQuery.setParameter(15, newMethod.getTimeMax());
            namedQuery.setParameter(16, newMethod.getTimeComment());
            namedQuery.setParameter(17, newMethod.getRating());
            namedQuery.setParameter(18, newMethod.getExperiences());
            namedQuery.setParameter(19, newMethod.getProceeding());
            namedQuery.setParameter(20, newMethod.getPhaseProceeding());
            namedQuery.setParameter(21, newMethod.getVariations());
            namedQuery.setParameter(22, newMethod.getExamples());
            namedQuery.setParameter(23, newMethod.getTips());
            namedQuery.setParameter(24, newMethod.getVisualization());
            namedQuery.setParameter(25, folder);
            namedQuery.setParameter(26, !newMethod.getImageDataUris().isEmpty());
            namedQuery.setParameter(27, newMethod.getScope());
            namedQuery.setParameter(28, newMethod.getWeblinks());
            namedQuery.setParameter(29, newMethod.getCitations());
            namedQuery.setParameter(30, 0);
            namedQuery.setParameter(31, new Date());
            namedQuery.executeUpdate();

            for (short i = 0; i < newMethod.getImageDataUris().size(); i++)
            {
                MobidicsFile newImageFile = new MobidicsFile();
                newImageFile.setMethodId(newUuid);
                newImageFile.setDisplayOrder(i);
                newImageFile.setFilename(FilenameUtils.generateFilename(folder, newMethod.getTitle(), i));
                newImageFile.setDateModified(new Date());
                session.save(newImageFile);
            }
            uploadImagesToServer(folder,
                                 newMethod.getTitle(),
                                 newMethod.getUploadedThumbnailDataUri(),
                                 newMethod.getImageDataUris());
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            tx.rollback();
            transactionSuccessful = false;
        }
        session.close();
        return transactionSuccessful;
    }

    private void uploadImagesToServer(String folder, String methodName, String thumbnailDataUri,
                                      List<String> imageDataUris)
            throws FTPImageUploadException
    {
        MobidicsFTPDAO ftpDAO = new MobidicsFTPDAO();
        if (!thumbnailDataUri.isEmpty())
        {
            ftpDAO.uploadThumbnail(folder, thumbnailDataUri);
        }
        if (!imageDataUris.isEmpty())
        {
            for (int i = 0; i < imageDataUris.size(); i++)
            {
                ftpDAO.uploadImage(folder, FilenameUtils.generateFilename(folder, methodName, i), imageDataUris.get(i));
            }
        }
    }

    public boolean deleteMethodById(String id)
    {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        boolean transactionSuccessful = true;
        try
        {

            tx.commit();
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        return transactionSuccessful;
    }
}
