package org.mobidics.api.viewmodel;

import org.mobidics.model.MobiDicsMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Long Bui on 27.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
public class MethodViewModel
{
    static final String IMAGE_PREFIX = "https://mobidics.org/mobidics/files/";

    private MobiDicsMethod method;

    public MethodViewModel(MobiDicsMethod method)
    {
        this.method = method;
    }

    public String getId()
    {
        return method.getId();
    }

    public String getTitle()
    {
        return method.getTitle();
    }

    public String getAlternativeTitles()
    {
        return method.getAlternativeTitles();
    }

    public String getSocialForm()
    {
        return method.getSocialform();
    }

    public String getPhase()
    {
        return method.getPhase();
    }

    public String getSubPhase()
    {
        return method.getSubphase();
    }

    public String getResult()
    {
        return method.getResult();
    }

    public String getCourseType()
    {
        return method.getCoursetype();
    }

    public Integer getGroupSizeMin()
    {
        return method.getParticipantsMin();
    }

    public Integer getGroupSizeMax()
    {
        return method.getParticipantsMax();
    }

    public String getProceeding()
    {
        return method.getProceeding();
    }

    public Integer getTimeMax()
    {
        return method.getTimeMax();
    }

    public Integer getTimeMin()
    {
        return method.getTimeMin();
    }

    public String getTimeComment()
    {
        return method.getTimeComment();
    }

    public String getVariations()
    {
        return method.getVariation();
    }

    public String getTips()
    {
        return method.getTips();
    }

    public String getExperiences()
    {
        return method.getOurrating();
    }

    public Date getCreationDate()
    {
        return method.getDateCreated();
    }

    public Date getLastModifiedDate()
    {
        return method.getDateModified();
    }

    public String getRating()
    {
        return method.getRating();
    }

    public String getCitations()
    {
        return method.getCitations();
    }

    public int getUserRating()
    {
        return method.getUserrating();
    }

    public String getVisualization()
    {
        return method.getVisualization();
    }

    public List<String> getImages()
    {
        List<String> result = new ArrayList<>(method.getImageFileNames().size());
        for (String string : method.getImageFileNames())
        {
            result.add(IMAGE_PREFIX + method.getFolder() + "/images/" + string);
        }
        return result;
    }

    public String getThumbnail()
    {
        return IMAGE_PREFIX + method.getFolder() + "/default.png";
    }
}
