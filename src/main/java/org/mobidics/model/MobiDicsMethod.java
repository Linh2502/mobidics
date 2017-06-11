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

    public abstract char getScope();

    public abstract String getAuthor();

    public abstract int getUserrating();

    public abstract String getHyperlinks();

    public abstract String getCitations();

    public abstract String getElxMethodsId();

    public abstract String getVendorId();

    public abstract Date getDateModified();

    public abstract List<String> getImageFileNames();
}
