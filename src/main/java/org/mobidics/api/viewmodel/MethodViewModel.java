package org.mobidics.api.viewmodel;

import com.owlike.genson.annotation.JsonIgnore;
import org.mobidics.model.MobiDicsMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mobidics.config.Config.IMAGES_LOCATION;

/**
 * Created by Long Bui on 27.04.17.
 * E-Mail: longbui1992@gmail.com
 */
public class MethodViewModel
{
    private String id;
    private String language;
    private Date dateCreated;
    private String title;
    private String alternativeTitles;
    private int[] socialForm = new int[0];
    private int[] phase = new int[0];
    private int[] subPhase = new int[0];
    private String result;
    private Integer groupType;
    private int[] courseType = new int[0];
    private Integer groupSizeMin;
    private Integer groupSizeMax;
    private String groupSizeComment;
    private String seating;
    private Integer timeMin;
    private Integer timeMax;
    private String timeComment;
    private String rating;
    private String ourrating;
    private String proceeding;
    private String phaseproceeding;
    private String variation;
    private String examples;
    private String tips;
    private String visualization;
    private String folder;
    private char scope;
    private String author;
    private int userrating;
    private String hyperlinks;
    private String citations;
    private String vendorId;
    private Date dateModified;
    private List<String> imageFileNames = new ArrayList<>();

    private String uploadedThumbnailDataUri;

    public MethodViewModel()
    {
    }

    private int[] splitString(String string)
    {
        if (string.equals(""))
        {
            return new int[0];
        }
        String[] splitString = string.split(":");
        int[] result = new int[splitString.length];
        for (int i = 0; i < splitString.length; i++)
        {
            result[i] = Integer.parseInt(splitString[i]);
        }
        return result;
    }

    public MethodViewModel(MobiDicsMethod method)
    {
        this.id = method.getId();
        this.language = method.getLanguage();
        this.dateCreated = method.getDateCreated();
        this.title = method.getTitle();
        this.alternativeTitles = method.getAlternativeTitles();
        this.socialForm = splitString(method.getSocialform());
        this.phase = splitString(method.getPhase());
        this.subPhase = splitString(method.getSubphase());
        this.result = method.getResult();
        this.groupType = method.getGrouptype();
        this.courseType = splitString(method.getCoursetype());
        this.groupSizeMin = method.getParticipantsMin();
        this.groupSizeMax = method.getParticipantsMax();
        this.groupSizeComment = method.getParticipantsComment();
        this.seating = method.getSeating();
        this.timeMin = method.getTimeMin();
        this.timeMax = method.getTimeMax();
        this.timeComment = method.getTimeComment();
        this.rating = method.getRating();
        this.ourrating = method.getOurrating();
        this.proceeding = method.getProceeding();
        this.phaseproceeding = method.getPhaseproceeding();
        this.variation = method.getVariation();
        this.examples = method.getExamples();
        this.tips = method.getTips();
        this.visualization = method.getVisualization();
        this.folder = method.getFolder();
        this.scope = method.getScope();
        this.author = method.getAuthor();
        this.userrating = method.getUserrating();
        this.hyperlinks = method.getHyperlinks();
        this.citations = method.getCitations();
        this.vendorId = method.getVendorId();
        this.dateModified = method.getDateModified();
        this.imageFileNames = method.getImageFileNames();
    }

    @JsonIgnore
    public String getUploadedThumbnailDataUri()
    {
        return this.uploadedThumbnailDataUri;
    }

    @JsonIgnore
    public List<String> getImageDataUris()
    {
        return this.imageFileNames;
    }

    public String getId()
    {
        return this.id;
    }

    public List<String> getImages()
    {
        List<String> result = new ArrayList<>(imageFileNames.size());
        for (String string : this.imageFileNames)
        {
            result.add(IMAGES_LOCATION + this.folder + "/images/" + string);
        }
        return result;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getAlternativeTitles()
    {
        return this.alternativeTitles;
    }

    public int[] getSocialForm()
    {
        return this.socialForm;
    }

    public int[] getPhase()
    {
        return this.phase;
    }

    public int[] getSubPhase()
    {
        return this.subPhase;
    }

    public String getResult()
    {
        return this.result;
    }

    public int[] getCourseType()
    {
        return this.courseType;
    }

    public Integer getGroupType()
    {
        return this.groupType;
    }

    public Integer getGroupSizeMin()
    {
        return this.groupSizeMin;
    }

    public Integer getGroupSizeMax()
    {
        return this.groupSizeMax;
    }

    public String getGroupSizeComment()
    {
        return this.groupSizeComment;
    }

    public String getProceeding()
    {
        return this.proceeding;
    }

    public String getPhaseProceeding()
    {
        return this.phaseproceeding;
    }

    public String getSeating()
    {
        return this.seating;
    }

    // TODO Material and MethodMaterial

    public Integer getTimeMin()
    {
        return this.timeMin;
    }

    public Integer getTimeMax()
    {
        return this.timeMax;
    }

    public String getTimeComment()
    {
        return this.timeComment;
    }

    public String getRating()
    {
        return this.rating;
    }

    public String getExperiences()
    {
        return this.ourrating;
    }

    public String getVariations()
    {
        return this.variation;
    }

    public String getExamples()
    {
        return this.examples;
    }

    public String getTips()
    {
        return this.tips;
    }

    public String getVisualization()
    {
        return this.visualization;
    }

    public String getWeblinks()
    {
        return this.hyperlinks;
    }

    public String getCitations()
    {
        return this.citations;
    }

    public char getScope()
    {
        return this.scope;
    }

    public int getUserRating()
    {
        return this.userrating;
    }

    public String getThumbnail()
    {
        return IMAGES_LOCATION + this.folder + "/default.png";
    }

    public Date getCreationDate()
    {
        return this.dateCreated;
    }

    public Date getLastModifiedDate()
    {
        return this.dateModified;
    }

    public String getLanguage()
    {
        return this.language;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public void setDateCreated(Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setAlternativeTitles(String alternativeTitles)
    {
        this.alternativeTitles = alternativeTitles;
    }

    public void setSocialForm(int[] socialform)
    {
        this.socialForm = socialform;
    }

    public void setPhase(int[] phase)
    {
        this.phase = phase;
    }

    public void setSubPhase(int[] subphase)
    {
        this.subPhase = subphase;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public void setGroupType(Integer groupType)
    {
        this.groupType = groupType;
    }

    public void setCourseType(int[] coursetype)
    {
        this.courseType = coursetype;
    }

    public void setGroupSizeMin(Integer groupSizeMin)
    {
        this.groupSizeMin = groupSizeMin;
    }

    public void setGroupSizeMax(Integer groupSizeMax)
    {
        this.groupSizeMax = groupSizeMax;
    }

    public void setGroupSizeComment(String groupSizeComment)
    {
        this.groupSizeComment = groupSizeComment;
    }

    public void setSeating(String seating)
    {
        this.seating = seating;
    }

    public void setTimeMin(Integer timeMin)
    {
        this.timeMin = timeMin;
    }

    public void setTimeMax(Integer timeMax)
    {
        this.timeMax = timeMax;
    }

    public void setTimeComment(String timeComment)
    {
        this.timeComment = timeComment;
    }

    public void setRating(String rating)
    {
        this.rating = rating;
    }

    public void setOurrating(String ourrating)
    {
        this.ourrating = ourrating;
    }

    public void setProceeding(String proceeding)
    {
        this.proceeding = proceeding;
    }

    public void setPhaseproceeding(String phaseproceeding)
    {
        this.phaseproceeding = phaseproceeding;
    }

    public void setVariation(String variation)
    {
        this.variation = variation;
    }

    public void setExamples(String examples)
    {
        this.examples = examples;
    }

    public void setTips(String tips)
    {
        this.tips = tips;
    }

    public void setVisualization(String visualization)
    {
        this.visualization = visualization;
    }

    public void setFolder(String folder)
    {
        this.folder = folder;
    }

    public void setScope(char scope)
    {
        this.scope = scope;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setUserrating(int userrating)
    {
        this.userrating = userrating;
    }

    public void setHyperlinks(String hyperlinks)
    {
        this.hyperlinks = hyperlinks;
    }

    public void setCitations(String citations)
    {
        this.citations = citations;
    }

    public void setVendorId(String vendorId)
    {
        this.vendorId = vendorId;
    }

    public void setDateModified(Date dateModified)
    {
        this.dateModified = dateModified;
    }

    public void setImages(List<String> imageFileNames)
    {
        this.imageFileNames = imageFileNames;
    }

    public void setThumbnail(String thumbnail)
    {
        this.uploadedThumbnailDataUri = thumbnail;
    }


}
