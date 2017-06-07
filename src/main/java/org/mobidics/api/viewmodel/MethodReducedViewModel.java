package org.mobidics.api.viewmodel;

import org.mobidics.model.MobiDicsMethod;

/**
 * Created by Long Bui on 03.05.17.
 * E-Mail: longbui1992@gmail.com
 */
public class MethodReducedViewModel
{
    private MobiDicsMethod method;

    public MethodReducedViewModel(MobiDicsMethod method)
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

    public String getThumbnail()
    {
        return MethodViewModel.IMAGE_PREFIX + method.getFolder() + "/default.png";
    }
}