package org.mobidics.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: longbui1992@gmail.com
 */
public class MobiDicsFilePK implements Serializable
{
    private String methodId;
    private String filename;

    @Column(name = "method_id", nullable = false, length = 36)
    @Id
    public String getMethodId()
    {
        return methodId;
    }

    public void setMethodId(String methodId)
    {
        this.methodId = methodId;
    }

    @Column(name = "filename", nullable = false, length = 255)
    @Id
    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
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

        MobiDicsFilePK that = (MobiDicsFilePK) o;

        if (methodId != null ? !methodId.equals(that.methodId) : that.methodId != null)
        {
            return false;
        }
        if (filename != null ? !filename.equals(that.filename) : that.filename != null)
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
        return result;
    }
}
