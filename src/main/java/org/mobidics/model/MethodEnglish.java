package org.mobidics.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: longbui1992@gmail.com
 */
@Entity @Table(name = "methods_en", schema = "mobidics")
public class MethodEnglish extends MobiDicsMethod
{
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
    private boolean haspictures;
    private char scope;
    private String author;
    private int userrating;
    private String hyperlinks;
    private String citations;
    private String elxMethodsId;
    private String vendorId;
    private Date dateModified;
    private List<String> imageFileNames;

    @Id
    @Column(name = "id", nullable = false, length = 36)
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "language", nullable = false)
    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    @Basic
    @Column(name = "date_created", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "title", nullable = false)
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @Basic
    @Column(name = "alternative_titles", length = -1)
    public String getAlternativeTitles()
    {
        return alternativeTitles;
    }

    public void setAlternativeTitles(String alternativeTitles)
    {
        this.alternativeTitles = alternativeTitles;
    }

    @Basic
    @Column(name = "socialform", length = 100)
    public String getSocialform()
    {
        return socialform;
    }

    public void setSocialform(String socialform)
    {
        this.socialform = socialform;
    }

    @Basic
    @Column(name = "phase", length = 100)
    public String getPhase()
    {
        return phase;
    }

    public void setPhase(String phase)
    {
        this.phase = phase;
    }

    @Basic
    @Column(name = "subphase", length = 100)
    public String getSubphase()
    {
        return subphase;
    }

    public void setSubphase(String subphase)
    {
        this.subphase = subphase;
    }

    @Basic
    @Column(name = "result", length = -1)
    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    @Basic
    @Column(name = "grouptype")
    public Integer getGrouptype()
    {
        return grouptype;
    }

    public void setGrouptype(Integer grouptype)
    {
        this.grouptype = grouptype;
    }

    @Basic
    @Column(name = "coursetype", length = 100)
    public String getCoursetype()
    {
        return coursetype;
    }

    public void setCoursetype(String coursetype)
    {
        this.coursetype = coursetype;
    }

    @Basic
    @Column(name = "participants_min")
    public Integer getParticipantsMin()
    {
        return participantsMin;
    }

    public void setParticipantsMin(Integer participantsMin)
    {
        this.participantsMin = participantsMin;
    }

    @Basic
    @Column(name = "participants_max")
    public Integer getParticipantsMax()
    {
        return participantsMax;
    }

    public void setParticipantsMax(Integer participantsMax)
    {
        this.participantsMax = participantsMax;
    }

    @Basic
    @Column(name = "participants_comment", length = -1)
    public String getParticipantsComment()
    {
        return participantsComment;
    }

    public void setParticipantsComment(String participantsComment)
    {
        this.participantsComment = participantsComment;
    }

    @Basic
    @Column(name = "seating", length = -1)
    public String getSeating()
    {
        return seating;
    }

    public void setSeating(String seating)
    {
        this.seating = seating;
    }

    @Basic
    @Column(name = "time_min")
    public Integer getTimeMin()
    {
        return timeMin;
    }

    public void setTimeMin(Integer timeMin)
    {
        this.timeMin = timeMin;
    }

    @Basic
    @Column(name = "time_max")
    public Integer getTimeMax()
    {
        return timeMax;
    }

    public void setTimeMax(Integer timeMax)
    {
        this.timeMax = timeMax;
    }

    @Basic
    @Column(name = "time_comment", length = -1)
    public String getTimeComment()
    {
        return timeComment;
    }

    public void setTimeComment(String timeComment)
    {
        this.timeComment = timeComment;
    }

    @Basic
    @Column(name = "rating", length = -1)
    public String getRating()
    {
        return rating;
    }

    public void setRating(String rating)
    {
        this.rating = rating;
    }

    @Basic
    @Column(name = "ourrating", length = -1)
    public String getOurrating()
    {
        return ourrating;
    }

    public void setOurrating(String ourrating)
    {
        this.ourrating = ourrating;
    }

    @Basic
    @Column(name = "proceeding", length = -1)
    public String getProceeding()
    {
        return proceeding;
    }

    public void setProceeding(String proceeding)
    {
        this.proceeding = proceeding;
    }

    @Basic
    @Column(name = "phaseproceeding", length = -1)
    public String getPhaseproceeding()
    {
        return phaseproceeding;
    }

    public void setPhaseproceeding(String phaseproceeding)
    {
        this.phaseproceeding = phaseproceeding;
    }

    @Basic
    @Column(name = "variation", length = -1)
    public String getVariation()
    {
        return variation;
    }

    public void setVariation(String variation)
    {
        this.variation = variation;
    }

    @Basic
    @Column(name = "examples", length = -1)
    public String getExamples()
    {
        return examples;
    }

    public void setExamples(String examples)
    {
        this.examples = examples;
    }

    @Basic
    @Column(name = "tips", length = -1)
    public String getTips()
    {
        return tips;
    }

    public void setTips(String tips)
    {
        this.tips = tips;
    }

    @Basic
    @Column(name = "visualization", length = -1)
    public String getVisualization()
    {
        return visualization;
    }

    public void setVisualization(String visualization)
    {
        this.visualization = visualization;
    }

    @Basic
    @Column(name = "folder")
    public String getFolder()
    {
        return folder;
    }

    public void setFolder(String folder)
    {
        this.folder = folder;
    }

    @Basic
    @Column(name = "haspictures")
    public boolean isHaspictures()
    {
        return haspictures;
    }

    public void setHaspictures(boolean haspictures)
    {
        this.haspictures = haspictures;
    }

    @Basic
    @Column(name = "scope", nullable = false)
    public char getScope()
    {
        return scope;
    }

    public void setScope(char scope)
    {
        this.scope = scope;
    }

    @Basic
    @Column(name = "author", length = 100)
    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    @Basic
    @Column(name = "userrating", nullable = false)
    public int getUserrating()
    {
        return userrating;
    }

    public void setUserrating(int userrating)
    {
        this.userrating = userrating;
    }

    @Basic
    @Column(name = "hyperlinks", length = -1)
    public String getHyperlinks()
    {
        return hyperlinks;
    }

    public void setHyperlinks(String hyperlinks)
    {
        this.hyperlinks = hyperlinks;
    }

    @Basic
    @Column(name = "citations", length = -1)
    public String getCitations()
    {
        return citations;
    }

    public void setCitations(String citations)
    {
        this.citations = citations;
    }

    @Basic
    @Column(name = "elx_methods_id", length = 36)
    public String getElxMethodsId()
    {
        return elxMethodsId;
    }

    public void setElxMethodsId(String elxMethodsId)
    {
        this.elxMethodsId = elxMethodsId;
    }

    @Basic
    @Column(name = "vendor_id", nullable = false, length = 36)
    public String getVendorId()
    {
        return vendorId;
    }

    public void setVendorId(String vendorId)
    {
        this.vendorId = vendorId;
    }

    @Basic
    @Column(name = "date_modified", nullable = false)
    @Temporal(TemporalType.DATE)
    public Date getDateModified()
    {
        return dateModified;
    }

    public void setDateModified(Date dateModified)
    {
        this.dateModified = dateModified;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "files", joinColumns = @JoinColumn(name = "method_id"))
    @Column(name = "filename")
    public List<String> getImageFileNames()
    {
        return this.imageFileNames;
    }

    public void setImageFileNames(List<String> imageFileNames)
    {
        this.imageFileNames = imageFileNames;
    }
}
