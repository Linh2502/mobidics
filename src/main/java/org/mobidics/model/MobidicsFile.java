package org.mobidics.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: longbui1992@gmail.com
 */
@Entity @Table(name = "files", schema = "mobidics", catalog = "")
@IdClass(FilesEntityPK.class)
public class MobidicsFile
{
    private String methodId;
    private String filename;
    private short displayOrder;
    private Date dateModified;

    @Id
    @Column(name = "method_id", nullable = false, length = 36)
    public String getMethodId()
    {
        return methodId;
    }

    public void setMethodId(String methodId)
    {
        this.methodId = methodId;
    }

    @Id
    @Column(name = "filename", nullable = false, length = 255)
    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    @Basic
    @Column(name = "display_order", nullable = false)
    public short getDisplayOrder()
    {
        return displayOrder;
    }

    public void setDisplayOrder(short displayOrder)
    {
        this.displayOrder = displayOrder;
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

        MobidicsFile that = (MobidicsFile) o;

        if (displayOrder != that.displayOrder)
        {
            return false;
        }
        if (methodId != null ? !methodId.equals(that.methodId) : that.methodId != null)
        {
            return false;
        }
        if (filename != null ? !filename.equals(that.filename) : that.filename != null)
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
        int result = methodId != null ? methodId.hashCode() : 0;
        result = 31 * result + (filename != null ? filename.hashCode() : 0);
        result = 31 * result + (int) displayOrder;
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        return result;
    }
}
