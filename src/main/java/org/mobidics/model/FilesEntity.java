package org.mobidics.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@Entity @Table(name = "files", schema = "mobidics", catalog = "") @IdClass(FilesEntityPK.class) public class FilesEntity
{
    private String methodId;
    private String filename;
    private byte displayOrder;
    private Timestamp dateModified;

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
    public byte getDisplayOrder()
    {
        return displayOrder;
    }

    public void setDisplayOrder(byte displayOrder)
    {
        this.displayOrder = displayOrder;
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

        FilesEntity that = (FilesEntity) o;

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
