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

import static org.mobidics.data.util.DBArrayUtils.intArrayToString;

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
            namedQuery.setParameter("uuid", newUuid);
            namedQuery.setParameter("language", newMethod.getLanguage());
            namedQuery.setParameter("title", newMethod.getTitle());
            namedQuery.setParameter("alternative_titles", newMethod.getAlternativeTitles());
            namedQuery.setParameter("socialform", intArrayToString(newMethod.getSocialForm()));
            namedQuery.setParameter("phase", intArrayToString(newMethod.getPhase()));
            namedQuery.setParameter("subphase", intArrayToString(newMethod.getSubPhase()));
            namedQuery.setParameter("result", newMethod.getResult());
            namedQuery.setParameter("grouptype", newMethod.getGroupType());
            namedQuery.setParameter("coursetype", intArrayToString(newMethod.getCourseType()));
            namedQuery.setParameter("participants_min", newMethod.getGroupSizeMin());
            namedQuery.setParameter("participants_max", newMethod.getGroupSizeMax());
            namedQuery.setParameter("participants_comment", newMethod.getGroupSizeComment());
            namedQuery.setParameter("seating", newMethod.getSeating());
            namedQuery.setParameter("time_min", newMethod.getTimeMin());
            namedQuery.setParameter("time_max", newMethod.getTimeMax());
            namedQuery.setParameter("time_comment", newMethod.getTimeComment());
            namedQuery.setParameter("rating", newMethod.getRating());
            namedQuery.setParameter("ourrating", newMethod.getExperiences());
            namedQuery.setParameter("proceeding", newMethod.getProceeding());
            namedQuery.setParameter("phaseproceeding", newMethod.getPhaseProceeding());
            namedQuery.setParameter("variation", newMethod.getVariations());
            namedQuery.setParameter("examples", newMethod.getExamples());
            namedQuery.setParameter("tips", newMethod.getTips());
            namedQuery.setParameter("visualization", newMethod.getVisualization());
            namedQuery.setParameter("folder", folder);
            namedQuery.setParameter("haspictures", newMethod.getImageDataUris().isEmpty() ? 1 : 2);
            namedQuery.setParameter("scope", newMethod.getScope());
            namedQuery.setParameter("hyperlinks", newMethod.getWeblinks());
            namedQuery.setParameter("citations", newMethod.getCitations());
            namedQuery.setParameter("vendor_id", 0);
            namedQuery.setParameter("date_created", new Date());
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

    public boolean updateMethod(MethodViewModel method)
    {
        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();
        boolean success = true;
        try
        {
            Query namedQuery = session.getNamedNativeQuery("updateMethod_" + method.getLanguage());
            namedQuery.setParameter("title", method.getTitle());
            namedQuery.setParameter("alternative_titles", method.getAlternativeTitles());
            namedQuery.setParameter("socialform", intArrayToString(method.getSocialForm()));
            namedQuery.setParameter("phase", intArrayToString(method.getPhase()));
            namedQuery.setParameter("subphase", intArrayToString(method.getSubPhase()));
            namedQuery.setParameter("result", method.getResult());
            namedQuery.setParameter("grouptype", method.getGroupType());
            namedQuery.setParameter("coursetype", intArrayToString(method.getCourseType()));
            namedQuery.setParameter("participants_min", method.getGroupSizeMin());
            namedQuery.setParameter("participants_max", method.getGroupSizeMax());
            namedQuery.setParameter("participants_comment", method.getGroupSizeComment());
            namedQuery.setParameter("seating", method.getSeating());
            namedQuery.setParameter("time_min", method.getTimeMin());
            namedQuery.setParameter("time_max", method.getTimeMax());
            namedQuery.setParameter("time_comment", method.getTimeComment());
            namedQuery.setParameter("rating", method.getRating());
            namedQuery.setParameter("ourrating", method.getExperiences());
            namedQuery.setParameter("proceeding", method.getProceeding());
            namedQuery.setParameter("phaseproceeding", method.getPhaseProceeding());
            namedQuery.setParameter("variation", method.getVariations());
            namedQuery.setParameter("examples", method.getExamples());
            namedQuery.setParameter("tips", method.getTips());
            namedQuery.setParameter("visualization", method.getVisualization());
            namedQuery.setParameter("haspictures", method.getImageDataUris().isEmpty() ? 1 : 2);
            namedQuery.setParameter("scope", method.getScope());
            namedQuery.setParameter("hyperlinks", method.getWeblinks());
            namedQuery.setParameter("citations", method.getCitations());
            namedQuery.setParameter("methodId", method.getId());
            namedQuery.executeUpdate();
            tx.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            tx.rollback();
            success = false;
        }
        session.close();
        return success;
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
            cleanUpComments(id, session);
            cleanUpRatings(id, session);
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

    private void cleanUpComments(String id, Session session)
    {
        cleanUpCommentVotes(id, session);
        Query query = session.getNamedNativeQuery("cleanUpComments");
        query.setParameter("method_id", id);
        query.executeUpdate();
    }

    private void cleanUpCommentVotes(String id, Session session)
    {
        List<Comment> comments;
        Query query = session.getNamedQuery("getCommentsOfMethod");
        query.setParameter("method_id", id);
        comments = query.list();
        for (Comment comment : comments)
        {
            query = session.getNamedQuery("cleanUpCommentVotes");
            query.setParameter("commentId", comment.getId());
            query.executeUpdate();
        }
    }

    private void cleanUpRatings(String id, Session session)
    {
        Query query;
        query = session.getNamedNativeQuery("cleanUpRatings");
        query.setParameter("method_id", id);
        query.executeUpdate();
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
