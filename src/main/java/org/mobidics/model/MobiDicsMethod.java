package org.mobidics.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Long Bui on 06.05.17.
 * E-Mail: longbui1992@gmail.com
 */
public abstract class MobiDicsMethod
{
    public abstract String getId();

    public abstract String getLanguage();

    public abstract Date getDateCreated();

    public abstract String getTitle();

    public abstract String getAlternativeTitles();

    public abstract String getSocialform();

    public abstract String getPhase();

    public abstract String getSubphase();

    public abstract String getResult();

    public abstract Integer getGrouptype();

    public abstract String getCoursetype();

    public abstract Integer getParticipantsMin();

    public abstract Integer getParticipantsMax();

    public abstract String getParticipantsComment();

    public abstract String getSeating();

    public abstract Integer getTimeMin();

    public abstract Integer getTimeMax();

    public abstract String getTimeComment();

    public abstract String getRating();

    public abstract String getOurrating();

    public abstract String getProceeding();

    public abstract String getPhaseproceeding();

    public abstract String getVariation();

    public abstract String getExamples();

    public abstract String getTips();

    public abstract String getVisualization();

    public abstract String getFolder();

    public abstract boolean isHaspictures();

    public abstract int getScope();

    public abstract String getAuthor();

    public abstract int getUserrating();

    public abstract String getHyperlinks();

    public abstract String getCitations();

    public abstract String getElxMethodsId();

    public abstract String getVendorId();

    public abstract Date getDateModified();

    public abstract List<String> getImageFileNames();

    public abstract void setId(String id);

    public abstract void setLanguage(String language);

    public abstract void setDateCreated(Date dateCreated);

    public abstract void setTitle(String title);

    public abstract void setAlternativeTitles(String alternativeTitles);

    public abstract void setSocialform(String socialform);

    public abstract void setPhase(String phase);

    public abstract void setSubphase(String subphase);

    public abstract void setResult(String result);

    public abstract void setGrouptype(Integer grouptype);

    public abstract void setCoursetype(String coursetype);

    public abstract void setParticipantsMin(Integer participantsMin);

    public abstract void setParticipantsMax(Integer participantsMax);

    public abstract void setParticipantsComment(String participantsComment);

    public abstract void setSeating(String seating);

    public abstract void setTimeMin(Integer timeMin);

    public abstract void setTimeMax(Integer timeMax);

    public abstract void setTimeComment(String timeComment);

    public abstract void setRating(String rating);

    public abstract void setOurrating(String ourrating);

    public abstract void setProceeding(String proceeding);

    public abstract void setPhaseproceeding(String phaseproceeding);

    public abstract void setVariation(String variation);

    public abstract void setExamples(String examples);

    public abstract void setTips(String tips);

    public abstract void setVisualization(String visualization);

    public abstract void setFolder(String folder);

    public abstract void setHaspictures(boolean haspictures);

    public abstract void setScope(int scope);

    public abstract void setAuthor(String author);

    public abstract void setUserrating(int userrating);

    public abstract void setHyperlinks(String hyperlinks);

    public abstract void setCitations(String citations);

    public abstract void setElxMethodsId(String elxMethodsId);

    public abstract void setVendorId(String vendorId);

    public abstract void setDateModified(Date dateModified);
}
