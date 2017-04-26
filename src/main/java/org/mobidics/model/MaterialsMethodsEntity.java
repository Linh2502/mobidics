package org.mobidics.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@Entity @Table(name = "materials_methods", schema = "mobidics", catalog = "") @IdClass(MaterialsMethodsEntityPK.class) public class MaterialsMethodsEntity
{
    private String methodId;
    private String materialId;
    private Integer amount;
    private boolean perParticipant;
    private boolean methodSpecific;
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
    @Column(name = "material_id", nullable = false, length = 36)
    public String getMaterialId()
    {
        return materialId;
    }

    public void setMaterialId(String materialId)
    {
        this.materialId = materialId;
    }

    @Basic
    @Column(name = "amount", nullable = true)
    public Integer getAmount()
    {
        return amount;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    @Basic
    @Column(name = "per_participant", nullable = true)
    public boolean isPerParticipant()
    {
        return perParticipant;
    }

    public void setPerParticipant(boolean perParticipant)
    {
        this.perParticipant = perParticipant;
    }

    @Basic
    @Column(name = "method_specific", nullable = true)
    public boolean isMethodSpecific()
    {
        return methodSpecific;
    }

    public void setMethodSpecific(boolean methodSpecific)
    {
        this.methodSpecific = methodSpecific;
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

        MaterialsMethodsEntity that = (MaterialsMethodsEntity) o;

        if (perParticipant != that.perParticipant)
        {
            return false;
        }
        if (methodSpecific != that.methodSpecific)
        {
            return false;
        }
        if (methodId != null ? !methodId.equals(that.methodId) : that.methodId != null)
        {
            return false;
        }
        if (materialId != null ? !materialId.equals(that.materialId) : that.materialId != null)
        {
            return false;
        }
        if (amount != null ? !amount.equals(that.amount) : that.amount != null)
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
        result = 31 * result + (materialId != null ? materialId.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (perParticipant ? 1 : 0);
        result = 31 * result + (methodSpecific ? 1 : 0);
        result = 31 * result + (dateModified != null ? dateModified.hashCode() : 0);
        return result;
    }
}
