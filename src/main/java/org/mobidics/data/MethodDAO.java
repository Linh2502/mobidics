package org.mobidics.data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mobidics.api.viewmodel.MethodViewModel;
import org.mobidics.data.util.FilenameUtils;
import org.mobidics.model.*;

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

    public List<MobiDicsMethod> getAllMethodsByName(String methodName)
    {
        Session session = SessionUtil.getSession();
        List<MobiDicsMethod> result;
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

    public MobiDicsMethod getMethodById(String id)
    {
        Session session = SessionUtil.getSession();
        MobiDicsMethod result = session.get(MethodGerman.class, id);
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

    public List<MobiDicsMethod> getFavoritesOfUsername(String username)
    {
        List<MobiDicsMethod> result;
        Session session = SessionUtil.getSession();
        Query namedQuery = session.getNamedNativeQuery("getFavoritesOfUser");
        namedQuery.setParameter("username", username);
        result = namedQuery.list();
        session.close();
        return result;
    }

    public boolean addFavorite(String username, String newFavoriteId)
    {
        boolean transactionSuccessful = true;
        Session session = SessionUtil.getSession();
        Query namedQuery = session.getNamedNativeQuery("insertFavoriteId");
        Transaction tx = session.beginTransaction();
        try
        {
            namedQuery.setParameter(0, username);
            namedQuery.setParameter(1, newFavoriteId);
            namedQuery.executeUpdate();
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

    public boolean deleteFavorite(String username, String favoriteId)
    {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        boolean transactionSuccessful = true;
        try
        {
            Favorites favoriteToDelete = session.get(Favorites.class, new FavoritesPK(username, favoriteId));
            session.delete(favoriteToDelete);
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            transactionSuccessful = false;
            tx.rollback();
        }
        session.close();
        return transactionSuccessful;
    }

    public boolean addMethod(MethodViewModel newMethod)
    {
        boolean transactionSuccessful = true;
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
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
            namedQuery.setParameter(26, newMethod.getImageDataUris().isEmpty() ? 1 : 2);
            namedQuery.setParameter(27, newMethod.getScope());
            namedQuery.setParameter(28, newMethod.getWeblinks());
            namedQuery.setParameter(29, newMethod.getCitations());
            namedQuery.setParameter(30, 0);
            namedQuery.setParameter(31, new Date());
            namedQuery.executeUpdate();

            if (!newMethod.getImageDataUris().isEmpty())
            {
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
            }
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
            String folder = null;
            MobiDicsMethod methodGerman = session.get(MethodGerman.class, id);
            MobiDicsMethod methodEnglish = session.get(MethodEnglish.class, id);
            MobiDicsMethod methodFrench = session.get(MethodFrench.class, id);
            MobiDicsMethod methodSpanish = session.get(MethodSpanish.class, id);
            if (methodGerman != null)
            {
                folder = methodGerman.getFolder();
                session.delete(methodGerman);
            }
            if (methodEnglish != null)
            {
                folder = methodEnglish.getFolder();
                session.delete(methodEnglish);
            }
            if (methodFrench != null)
            {
                folder = methodFrench.getFolder();
                session.delete(methodFrench);
            }
            if (methodSpanish != null)
            {
                folder = methodSpanish.getFolder();
                session.delete(methodSpanish);
            }
            if (folder != null)
            {
                MobidicsFTPDAO ftpDAO = new MobidicsFTPDAO();
                ftpDAO.deleteImages(folder);
            }
            Query query = session.getNamedNativeQuery("cleanUpComments");
            query.setParameter("method_id", id);
            query.executeUpdate();
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            transactionSuccessful = false;
            tx.rollback();
        }
        session.close();
        return transactionSuccessful;
    }
}
