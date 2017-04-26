package org.mobidics.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@Entity @Table(name = "methods_es", schema = "mobidics", catalog = "") public class MethodsEsEntity
{
    private String id;
    private String language;
    private Timestamp dateCreated;
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
    private int scope;
    private String author;
    private int userrating;
    private String hyperlinks;
    private String citations;
    private String elxMethodsId;
    private String vendorId;
    private Timestamp dateModified;

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
    @Column(name = "language", nullable = false, length = 255)
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
    public Timestamp getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 255)
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    @Basic
    @Column(name = "alternative_titles", nullable = true, length = -1)
    public String getAlternativeTitles()
    {
        return alternativeTitles;
    }

    public void setAlternativeTitles(String alternativeTitles)
    {
        this.alternativeTitles = alternativeTitles;
    }

    @Basic
    @Column(name = "socialform", nullable = true, length = 100)
    public String getSocialform()
    {
        return socialform;
    }

    public void setSocialform(String socialform)
    {
        this.socialform = socialform;
    }

    @Basic
    @Column(name = "phase", nullable = true, length = 100)
    public String getPhase()
    {
        return phase;
    }

    public void setPhase(String phase)
    {
        this.phase = phase;
    }

    @Basic
    @Column(name = "subphase", nullable = true, length = 100)
    public String getSubphase()
    {
        return subphase;
    }

    public void setSubphase(String subphase)
    {
        this.subphase = subphase;
    }

    @Basic
    @Column(name = "result", nullable = true, length = -1)
    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    @Basic
    @Column(name = "grouptype", nullable = true)
    public Integer getGrouptype()
    {
        return grouptype;
    }

    public void setGrouptype(Integer grouptype)
    {
        this.grouptype = grouptype;
    }

    @Basic
    @Column(name = "coursetype", nullable = true, length = 100)
    public String getCoursetype()
    {
        return coursetype;
    }

    public void setCoursetype(String coursetype)
    {
        this.coursetype = coursetype;
    }

    @Basic
    @Column(name = "participants_min", nullable = true)
    public Integer getParticipantsMin()
    {
        return participantsMin;
    }

    public void setParticipantsMin(Integer participantsMin)
    {
        this.participantsMin = participantsMin;
    }

    @Basic
    @Column(name = "participants_max", nullable = true)
    public Integer getParticipantsMax()
    {
        return participantsMax;
    }

    public void setParticipantsMax(Integer participantsMax)
    {
        this.participantsMax = participantsMax;
    }

    @Basic
    @Column(name = "participants_comment", nullable = true, length = -1)
    public String getParticipantsComment()
    {
        return participantsComment;
    }

    public void setParticipantsComment(String participantsComment)
    {
        this.participantsComment = participantsComment;
    }

    @Basic
    @Column(name = "seating", nullable = true, length = -1)
    public String getSeating()
    {
        return seating;
    }

    public void setSeating(String seating)
    {
        this.seating = seating;
    }

    @Basic
    @Column(name = "time_min", nullable = true)
    public Integer getTimeMin()
    {
        return timeMin;
    }

    public void setTimeMin(Integer timeMin)
    {
        this.timeMin = timeMin;
    }

    @Basic
    @Column(name = "time_max", nullable = true)
    public Integer getTimeMax()
    {
        return timeMax;
    }

    public void setTimeMax(Integer timeMax)
    {
        this.timeMax = timeMax;
    }

    @Basic
    @Column(name = "time_comment", nullable = true, length = -1)
    public String getTimeComment()
    {
        return timeComment;
    }

    public void setTimeComment(String timeComment)
    {
        this.timeComment = timeComment;
    }

    @Basic
    @Column(name = "rating", nullable = true, length = -1)
    public String getRating()
    {
        return rating;
    }

    public void setRating(String rating)
    {
        this.rating = rating;
    }

    @Basic
    @Column(name = "ourrating", nullable = true, length = -1)
    public String getOurrating()
    {
        return ourrating;
    }

    public void setOurrating(String ourrating)
    {
        this.ourrating = ourrating;
    }

    @Basic
    @Column(name = "proceeding", nullable = true, length = -1)
    public String getProceeding()
    {
        return proceeding;
    }

    public void setProceeding(String proceeding)
    {
        this.proceeding = proceeding;
    }

    @Basic
    @Column(name = "phaseproceeding", nullable = true, length = -1)
    public String getPhaseproceeding()
    {
        return phaseproceeding;
    }

    public void setPhaseproceeding(String phaseproceeding)
    {
        this.phaseproceeding = phaseproceeding;
    }

    @Basic
    @Column(name = "variation", nullable = true, length = -1)
    public String getVariation()
    {
        return variation;
    }

    public void setVariation(String variation)
    {
        this.variation = variation;
    }

    @Basic
    @Column(name = "examples", nullable = true, length = -1)
    public String getExamples()
    {
        return examples;
    }

    public void setExamples(String examples)
    {
        this.examples = examples;
    }

    @Basic
    @Column(name = "tips", nullable = true, length = -1)
    public String getTips()
    {
        return tips;
    }

    public void setTips(String tips)
    {
        this.tips = tips;
    }

    @Basic
    @Column(name = "visualization", nullable = true, length = -1)
    public String getVisualization()
    {
        return visualization;
    }

    public void setVisualization(String visualization)
    {
        this.visualization = visualization;
    }

    @Basic
    @Column(name = "folder", nullable = true, length = 255)
    public String getFolder()
    {
        return folder;
    }

    public void setFolder(String folder)
    {
        this.folder = folder;
    }

    @Basic
    @Column(name = "haspictures", nullable = true)
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
    public int getScope()
    {
        return scope;
    }

    public void setScope(int scope)
    {
        this.scope = scope;
    }

    @Basic
    @Column(name = "author", nullable = true, length = 100)
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
    @Column(name = "hyperlinks", nullable = true, length = -1)
    public String getHyperlinks()
    {
        return hyperlinks;
    }

    public void setHyperlinks(String hyperlinks)
    {
        this.hyperlinks = hyperlinks;
    }

    @Basic
    @Column(name = "citations", nullable = true, length = -1)
    public String getCitations()
    {
        return citations;
    }

    public void setCitations(String citations)
    {
        this.citations = citations;
    }

    @Basic
    @Column(name = "elx_methods_id", nullable = true, length = 36)
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
    public Timestamp getDateModified()
    {
        return dateModified;
    }

    public void setDateModified(Timestamp dateModified)
    {
        this.dateModified = dateModified;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        MethodsEsEntity that = (MethodsEsEntity) o;

        if (haspictures != that.haspictures)
        {
            return false;
        }
        if (scope != that.scope)
        {
            return false;
        }
        if (userrating != that.userrating)
        {
            return false;
        }
        if (id != null ? !id.equals(that.id) : that.id != null)
        {
            return false;
        }
        if (language != null ? !language.equals(that.language) : that.language != null)
        {
            return false;
        }
        if (dateCreated != null ? !dateCreated.equals(that.dateCreated) : that.dateCreated != null)
        {
            return false;
        }
        if (title != null ? !title.equals(that.title) : that.title != null)
        {
            return false;
        }
        if (alternativeTitles != null ? !alternativeTitles.equals(that.alternativeTitles) : that.alternativeTitles != null)
        {
            return false;
        }
        if (socialform != null ? !socialform.equals(that.socialform) : that.socialform != null)
        {
            return false;
        }
        if (phase != null ? !phase.equals(that.phase) : that.phase != null)
        {
            return false;
        }
        if (subphase != null ? !subphase.equals(that.subphase) : that.subphase != null)
        {
            return false;
        }
        if (result != null ? !result.equals(that.result) : that.result != null)
        {
            return false;
        }
        if (grouptype != null ? !grouptype.equals(that.grouptype) : that.grouptype != null)
        {
            return false;
        }
        if (coursetype != null ? !coursetype.equals(that.coursetype) : that.coursetype != null)
        {
            return false;
        }
        if (participantsMin != null ? !participantsMin.equals(that.participantsMin) : that.participantsMin != null)
        {
            return false;
        }
        if (participantsMax != null ? !participantsMax.equals(that.participantsMax) : that.participantsMax != null)
        {
            return false;
        }
        if (participantsComment != null ? !participantsComment.equals(that.participantsComment) : that.participantsComment != null)
        {
            return false;
        }
        if (seating != null ? !seating.equals(that.seating) : that.seating != null)
        {
            return false;
        }
        if (timeMin != null ? !timeMin.equals(that.timeMin) : that.timeMin != null)
        {
            return false;
        }
        if (timeMax != null ? !timeMax.equals(that.timeMax) : that.timeMax != null)
        {
            return false;
        }
        if (timeComment != null ? !timeComment.equals(that.timeComment) : that.timeComment != null)
        {
            return false;
        }
        if (rating != null ? !rating.equals(that.rating) : that.rating != null)
        {
            return false;
        }
        if (ourrating != null ? !ourrating.equals(that.ourrating) : that.ourrating != null)
        {
            return false;
        }
        if (proceeding != null ? !proceeding.equals(that.proceeding) : that.proceeding != null)
        {
            return false;
        }
        if (phaseproceeding != null ? !phaseproceeding.equals(that.phaseproceeding) : that.phaseproceeding != null)
        {
            return false;
        }
        if (variation != null ? !variation.equals(that.variation) : that.variation != null)
        {
            return false;
        }
        if (examples != null ? !examples.equals(that.examples) : that.examples != null)
        {
            return false;
        }
        if (tips != null ? !tips.equals(that.tips) : that.tips != null)
        {
            return false;
        }
        if (visualization != null ? !visualization.equals(that.visualization) : that.visualization != null)
        {
            return false;
        }
        if (folder != null ? !folder.equals(that.folder) : that.folder != null)
        {
            return false;
        }
        if (author != null ? !author.equals(that.author) : that.author != null)
        {
            return false;
        }
        if (hyperlinks != null ? !hyperlinks.equals(that.hyperlinks) : that.hyperlinks != null)
        {
            return false;
        }
        if (citations != null ? !citations.equals(that.citations) : that.citations != null)
        {
            return false;
        }
        if (elxMethodsId != null ? !elxMethodsId.equals(that.elxMethodsId) : that.elxMethodsId != null)
        {
            return false;
        }
        if (vendorId != null ? !vendorId.equals(that.vendorId) : that.vendorId != null)
        {
            return false;
        }
        if (dateModified != null ? !dateModified.equals(that.dateModified) : that.dateModified != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (language != null ? language.hashCode() : 0);
        result1 = 31 * result1 + (dateCreated != null ? dateCreated.hashCode() : 0);
        result1 = 31 * result1 + (title != null ? title.hashCode() : 0);
        result1 = 31 * result1 + (alternativeTitles != null ? alternativeTitles.hashCode() : 0);
        result1 = 31 * result1 + (socialform != null ? socialform.hashCode() : 0);
        result1 = 31 * result1 + (phase != null ? phase.hashCode() : 0);
        result1 = 31 * result1 + (subphase != null ? subphase.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (grouptype != null ? grouptype.hashCode() : 0);
        result1 = 31 * result1 + (coursetype != null ? coursetype.hashCode() : 0);
        result1 = 31 * result1 + (participantsMin != null ? participantsMin.hashCode() : 0);
        result1 = 31 * result1 + (participantsMax != null ? participantsMax.hashCode() : 0);
        result1 = 31 * result1 + (participantsComment != null ? participantsComment.hashCode() : 0);
        result1 = 31 * result1 + (seating != null ? seating.hashCode() : 0);
        result1 = 31 * result1 + (timeMin != null ? timeMin.hashCode() : 0);
        result1 = 31 * result1 + (timeMax != null ? timeMax.hashCode() : 0);
        result1 = 31 * result1 + (timeComment != null ? timeComment.hashCode() : 0);
        result1 = 31 * result1 + (rating != null ? rating.hashCode() : 0);
        result1 = 31 * result1 + (ourrating != null ? ourrating.hashCode() : 0);
        result1 = 31 * result1 + (proceeding != null ? proceeding.hashCode() : 0);
        result1 = 31 * result1 + (phaseproceeding != null ? phaseproceeding.hashCode() : 0);
        result1 = 31 * result1 + (variation != null ? variation.hashCode() : 0);
        result1 = 31 * result1 + (examples != null ? examples.hashCode() : 0);
        result1 = 31 * result1 + (tips != null ? tips.hashCode() : 0);
        result1 = 31 * result1 + (visualization != null ? visualization.hashCode() : 0);
        result1 = 31 * result1 + (folder != null ? folder.hashCode() : 0);
        result1 = 31 * result1 + (haspictures ? 1 : 0);
        result1 = 31 * result1 + scope;
        result1 = 31 * result1 + (author != null ? author.hashCode() : 0);
        result1 = 31 * result1 + userrating;
        result1 = 31 * result1 + (hyperlinks != null ? hyperlinks.hashCode() : 0);
        result1 = 31 * result1 + (citations != null ? citations.hashCode() : 0);
        result1 = 31 * result1 + (elxMethodsId != null ? elxMethodsId.hashCode() : 0);
        result1 = 31 * result1 + (vendorId != null ? vendorId.hashCode() : 0);
        result1 = 31 * result1 + (dateModified != null ? dateModified.hashCode() : 0);
        return result1;
    }
}
