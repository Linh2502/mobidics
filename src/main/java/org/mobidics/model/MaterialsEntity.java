package org.mobidics.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@Entity @Table(name = "materials", schema = "mobidics", catalog = "") public class MaterialsEntity
{
    private String id;
    private String defaultLanguage;
    private String nameDe;
    private String nameEn;
    private String nameFr;
    private String nameEs;
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
    @Column(name = "default_language", nullable = false, length = 10)
    public String getDefaultLanguage()
    {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage)
    {
        this.defaultLanguage = defaultLanguage;
    }

    @Basic
    @Column(name = "name_de", nullable = true, length = 255)
    public String getNameDe()
    {
        return nameDe;
    }

    public void setNameDe(String nameDe)
    {
        this.nameDe = nameDe;
    }

    @Basic
    @Column(name = "name_en", nullable = true, length = 255)
    public String getNameEn()
    {
        return nameEn;
    }

    public void setNameEn(String nameEn)
    {
        this.nameEn = nameEn;
    }

    @Basic
    @Column(name = "name_fr", nullable = true, length = 255)
    public String getNameFr()
    {
        return nameFr;
    }

    public void setNameFr(String nameFr)
    {
        this.nameFr = nameFr;
    }

    @Basic
    @Column(name = "name_es", nullable = true, length = 255)
    public String getNameEs()
    {
        return nameEs;
    }

    public void setNameEs(String nameEs)
    {
        this.nameEs = nameEs;
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

        MaterialsEntity that = (MaterialsEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
        {
            return false;
        }
        if (defaultLanguage != null ? !defaultLanguage.equals(that.defaultLanguage) : that.defaultLanguage != null)
        {
            return false;
        }
        if (nameDe != null ? !nameDe.equals(that.nameDe) : that.nameDe != null)
        {
            return false;
        }
        if (nameEn != null ? !nameEn.equals(that.nameEn) : that.nameEn != null)
        {
            return false;
        }
        if (nameFr != null ? !nameFr.equals(that.nameFr) : that.nameFr != null)
        {
            return false;
        }
        if (nameEs != null ? !nameEs.equals(that.nameEs) : that.nameEs != null)
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
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (defaultLanguage != null ? defaultLanguage.hashCode() : 0);
        result = 31 * result + (nameDe != null ? nameDe.hashCode() : 0);
        result = 31 * result + (nameEn != null ? nameEn.hashCode() : 0);
        result = 31 * result + (nameFr != null ? nameFr.hashCode() : 0);
        result = 31 * result + (nameEs != null ? nameEs.hashCode() : 0);
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        return result;
    }
}
