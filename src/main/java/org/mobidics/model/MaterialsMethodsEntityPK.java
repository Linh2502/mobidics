package org.mobidics.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: longbui1992@gmail.com
 */
public class MaterialsMethodsEntityPK implements Serializable
{
    private String methodId;
    private String materialId;

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

    @Column(name = "material_id", nullable = false, length = 36)
    @Id
    public String getMaterialId()
    {
        return materialId;
    }

    public void setMaterialId(String materialId)
    {
        this.materialId = materialId;
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

        MaterialsMethodsEntityPK that = (MaterialsMethodsEntityPK) o;

        if (methodId != null ? !methodId.equals(that.methodId) : that.methodId != null)
        {
            return false;
        }
        if (materialId != null ? !materialId.equals(that.materialId) : that.materialId != null)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = methodId != null ? methodId.hashCode() : 0;
        result = 31 * result + (materialId != null ? materialId.hashCode() : 0);
        return result;
    }
}
