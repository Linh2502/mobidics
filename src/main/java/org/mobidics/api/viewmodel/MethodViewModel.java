package org.mobidics.api.viewmodel;

import com.owlike.genson.annotation.JsonIgnore;
import org.mobidics.model.MethodGerman;
import org.mobidics.model.MobiDicsMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Long Bui on 27.04.17.
 * E-Mail: longbui1992@gmail.com
 */
public class MethodViewModel
{
    // TODO change to liveserver
    static final String IMAGE_PREFIX = "http://lb-staging.dynv6.net:2480/mobidics/files/";
    private String id;
    private String language;
    private Date dateCreated;
    private String title;
    private String alternativeTitles;
    private String socialform;
    private String phase;
    private String subphase;
    private String result;
    private Integer grouptype;
    private String coursetype;
    private Integer participantsMin;
    private Integer participantsMax;
    private String participantsComment;
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

    public MethodViewModel(MobiDicsMethod method)
    {
        this.id = method.getId();
        this.language = method.getLanguage();
        this.dateCreated = method.getDateCreated();
        this.title = method.getTitle();
        this.alternativeTitles = method.getAlternativeTitles();
        this.socialform = method.getSocialform();
        this.phase = method.getPhase();
        this.subphase = method.getSubphase();
        this.result = method.getResult();
        this.grouptype = method.getGrouptype();
        this.coursetype = method.getCoursetype();
        this.participantsMin = method.getParticipantsMin();
        this.participantsMax = method.getParticipantsMax();
        this.participantsComment = method.getParticipantsComment();
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
            result.add(IMAGE_PREFIX + this.folder + "/images/" + string);
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

    public String getSocialForm()
    {
        return this.socialform;
    }

    public String getPhase()
    {
        return this.phase;
    }

    public String getSubPhase()
    {
        return this.subphase;
    }

    public String getResult()
    {
        return this.result;
    }

    public String getCourseType()
    {
        return this.coursetype;
    }

    public Integer getGroupType()
    {
        return this.grouptype;
    }

    public Integer getGroupSizeMin()
    {
        return this.participantsMin;
    }

    public Integer getGroupSizeMax()
    {
        return this.participantsMax;
    }

    public String getGroupSizeComment()
    {
        return this.participantsComment;
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
        return IMAGE_PREFIX + this.folder + "/default.png";
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

    public void setSocialform(String socialform)
    {
        this.socialform = socialform;
    }

    public void setPhase(String phase)
    {
        this.phase = phase;
    }

    public void setSubphase(String subphase)
    {
        this.subphase = subphase;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public void setGrouptype(Integer grouptype)
    {
        this.grouptype = grouptype;
    }

    public void setCoursetype(String coursetype)
    {
        this.coursetype = coursetype;
    }

    public void setParticipantsMin(Integer participantsMin)
    {
        this.participantsMin = participantsMin;
    }

    public void setParticipantsMax(Integer participantsMax)
    {
        this.participantsMax = participantsMax;
    }

    public void setParticipantsComment(String participantsComment)
    {
        this.participantsComment = participantsComment;
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
