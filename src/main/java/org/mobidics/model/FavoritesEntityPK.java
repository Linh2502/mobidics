package org.mobidics.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
public class FavoritesEntityPK implements Serializable
{
    private String username;
    private String methodId;

    @Column(name = "username", nullable = false, length = 100)
    @Id
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

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

        FavoritesEntityPK that = (FavoritesEntityPK) o;

        if (username != null ? !username.equals(that.username) : that.username != null)
        {
            return false;
        }
        if (methodId != null ? !methodId.equals(that.methodId) : that.methodId != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (methodId != null ? methodId.hashCode() : 0);
        return result;
    }
}
