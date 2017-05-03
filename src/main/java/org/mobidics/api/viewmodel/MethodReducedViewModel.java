package org.mobidics.api.viewmodel;

import org.mobidics.model.MethodsDeEntity;

import java.util.Date;

/**
 * Created by Long Bui on 03.05.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
public class MethodReducedViewModel
{
    private MethodsDeEntity method;

    public MethodReducedViewModel(MethodsDeEntity method)
    {
        this.method = method;
    }

    public String getId()
    {
        return method.getId();
    }

    public String getTitle()
    {
        return method.getTitle();
    }

    public int getUserRating()
    {
        return method.getUserrating();
    }
}