package org.mobidics.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: longbui1992@gmail.com
 */
public class FavoritesPK implements Serializable
{
    @Id
    @Column(name = "username", nullable = false, length = 100)
    private String username;
    @Id
    @Column(name = "method_id", nullable = false, length = 36)
    private String methodId;

    public FavoritesPK()
    {
    }

    public FavoritesPK(String username, String methodId)
    {
        this.username = username;
        this.methodId = methodId;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

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

        FavoritesPK that = (FavoritesPK) o;

        return username.equals(that.username) && methodId.equals(that.methodId);
    }

    @Override
    public int hashCode()
    {
        int result = username.hashCode();
        result = 31 * result + methodId.hashCode();
        return result;
    }
}
