package org.mobidics.api.viewmodel;

import org.mobidics.api.viewmodel.enums.UserEnums;
import org.mobidics.data.UniversityDAO;
import org.mobidics.model.User;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
public class UserViewModel
{
    private User user;

    public UserViewModel(User user)
    {
        this.user = user;
    }

    public String getUsername()
    {
        return user.getUsername();
    }

    public String getFirstname()
    {
        return user.getFirstname();
    }

    public String getLastname()
    {
        return user.getLastname();
    }

    public String getEmail()
    {
        return user.getEmail();
    }

    public boolean getIsApproved()
    {
        return user.isApproved();
    }

    public String getLanguage()
    {
        return user.getLanguage();
    }

    public int getUserStatus()
    {
        return user.getUserstatus();
    }

    public int getUserType()
    {
        return user.getUsertype();
    }

    public int getUserLevel()
    {
        return user.getUserLevel();
    }

    public String getUniversity()
    {
        return new UniversityDAO().getUniversityNameById(user.getUniversityId());
    }

    public int getFaculty()
    {
        return user.getFacultyId();
    }

    public String getDepartment()
    {
        return user.getDepartment();
    }

    public String experience()
    {
        return user.getExperience();
    }

    public String getProfileImage()
    {
        return user.getProfilepicture();
    }
}
