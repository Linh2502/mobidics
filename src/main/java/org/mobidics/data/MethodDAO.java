package org.mobidics.data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.mobidics.api.viewmodel.MethodViewModel;
import org.mobidics.data.exceptions.FTPImageUploadException;
import org.mobidics.data.util.FilenameUtils;
import org.mobidics.model.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

    public List<MethodGerman> getMethodsWithFilters(String searchString,
                                                    List<String> phases,
                                                    List<String> subphases,
                                                    List<String> coursetypes,
                                                    int groupType,
                                                    int maxGroupSize,
                                                    int maxTime,
                                                    int minRating,
                                                    List<String> socialforms)
    {
        Session session = SessionUtil.getSession();
        List<MethodGerman> result;
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<MethodGerman> criteriaQuery = criteriaBuilder.createQuery(MethodGerman.class);
        Root<MethodGerman> methodRoot = criteriaQuery.from(MethodGerman.class);
        List<Predicate> predicates = new ArrayList<>();
        if (searchString != null)
        {
            addSearchStringPredicates(searchString, criteriaBuilder, methodRoot, predicates);
        }
        addFilterPredicates(predicates,
                            methodRoot,
                            criteriaBuilder,
                            phases,
                            subphases,
                            coursetypes,
                            groupType,
                            maxGroupSize,
                            maxTime,
                            minRating,
                            socialforms);
        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        result = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return result;
    }

    private void addFilterPredicates(List<Predicate> predicates,
                                     Root<MethodGerman> methodRoot,
                                     CriteriaBuilder builder,
                                     List<String> phases,
                                     List<String> subphases,
                                     List<String> coursetypes,
                                     int groupType,
                                     int maxGroupSize,
                                     int maxTime,
                                     int minRating,
                                     List<String> socialforms)
    {
        if (phases != null)
        {
            for (String phase : phases)
            {
                predicates.add(builder.like(methodRoot.get("phase"), "%" + phase + "%"));
            }
        }
        if (subphases != null)
        {
            for (String subphase : subphases)
            {
                predicates.add(builder.like(methodRoot.get("subphase"), "%" + subphase + "%"));
            }
        }
        if (coursetypes != null)
        {
            for (String coursetype : coursetypes)
            {
                predicates.add(builder.like(methodRoot.get("coursetype"), "%" + coursetype + "%"));
            }
        }
        if (groupType != 0)
        {
            predicates.add(builder.equal(methodRoot.get("grouptype"), groupType));
        }
        if (maxGroupSize != 0)
        {
            predicates.add(builder.le(methodRoot.get("participantsMax"), maxGroupSize));
        }
        if (maxTime != 0)
        {
            predicates.add(builder.le(methodRoot.get("timeMax"), maxTime));
        }
        if (minRating != 0)
        {
            predicates.add(builder.ge(methodRoot.get("userrating"), minRating));
        }
        if (socialforms != null)
        {
            for (String socialform : socialforms)
            {
                predicates.add(builder.like(methodRoot.get("socialform"), "%" + socialform + "%"));
            }
        }
    }

    private void addSearchStringPredicates(String searchString, CriteriaBuilder builder, Root<MethodGerman> methodRoot,
                                           List<Predicate> predicates)
    {
        List<Predicate> searchStringPredicates = new ArrayList<>();
        String searchStringWithWildcards = "%" + searchString + "%";
        searchStringPredicates.add(builder.like(
                methodRoot.get("title"),
                searchStringWithWildcards
        ));
        searchStringPredicates.add(builder.like(
                methodRoot.get("alternativeTitles"),
                searchStringWithWildcards
        ));
        searchStringPredicates.add(builder.like(
                methodRoot.get("result"),
                searchStringWithWildcards
        ));
        searchStringPredicates.add(builder.like(
                methodRoot.get("proceeding"),
                searchStringWithWildcards
        ));
        searchStringPredicates.add(builder.like(
                methodRoot.get("phaseproceeding"),
                searchStringWithWildcards
        ));
        searchStringPredicates.add(builder.like(
                methodRoot.get("rating"),
                searchStringWithWildcards
        ));
        searchStringPredicates.add(builder.like(
                methodRoot.get("ourrating"),
                searchStringWithWildcards
        ));
        searchStringPredicates.add(builder.like(
                methodRoot.get("participantsComment"),
                searchStringWithWildcards
        ));
        searchStringPredicates.add(builder.like(
                methodRoot.get("seating"),
                searchStringWithWildcards
        ));
        searchStringPredicates.add(builder.like(
                methodRoot.get("timeComment"),
                searchStringWithWildcards
        ));
        searchStringPredicates.add(builder.like(
                methodRoot.get("variation"),
                searchStringWithWildcards
        ));
        searchStringPredicates.add(builder.like(
                methodRoot.get("examples"),
                searchStringWithWildcards
        ));
        searchStringPredicates.add(builder.like(
                methodRoot.get("tips"),
                searchStringWithWildcards
        ));
        searchStringPredicates.add(builder.like(
                methodRoot.get("visualization"),
                searchStringWithWildcards
        ));
        searchStringPredicates.add(builder.like(
                methodRoot.get("author"),
                searchStringWithWildcards
        ));
        searchStringPredicates.add(builder.like(
                methodRoot.get("citations"),
                searchStringWithWildcards
        ));
        predicates.add(builder.or(searchStringPredicates.toArray(new Predicate[0])));
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
            query = session.getNamedNativeQuery("cleanUpRatings");
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

    public MinMaxSummary getMinMaxes()
    {
        Session session = SessionUtil.getSession();
        Query query = session.getNamedQuery("minMaxes");
        MinMaxSummary minMaxSummary = (MinMaxSummary) query.getSingleResult();
        session.close();
        return minMaxSummary;
    }
}
