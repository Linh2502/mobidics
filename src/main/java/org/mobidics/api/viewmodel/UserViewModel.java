package org.mobidics.api.viewmodel;

import com.owlike.genson.annotation.JsonIgnore;
import org.mobidics.model.Faculty;
import org.mobidics.model.University;
import org.mobidics.model.User;

import java.util.Date;

public class UserViewModel
{
    private String username;
    private String password;
    private String email;
    private boolean approved;
    private boolean isFirstRun;
    private Integer userLevel;
    private String language;
    private String profileImage;
    private String firstname;
    private String lastname;
    private Date birthday;
    private int gender;
    private Integer userStatus;
    private String userStatusOther;
    private Integer userType;
    private String userTypeOther;
    private University university;
    private Faculty faculty;
    private String department;
    private String experience;
    private String[] privateFields;
    private long lastActionDate;

    public UserViewModel()
    {
    }

    public UserViewModel(User user)
    {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.approved = user.isApproved();
        this.isFirstRun = user.isIsFirstRun();
        this.userLevel = user.getUserLevel();
        this.language = user.getLanguage();
        this.profileImage = user.getProfileImage();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.birthday = user.getBirthday();
        this.gender = user.getGender();
        this.userStatus = user.getUserStatus();
        this.userStatusOther = user.getUserstatusOther();
        this.userType = user.getUserType();
        this.userTypeOther = user.getUsertypeOther();
        this.university = user.getUniversity();
        this.faculty = user.getFaculty();
        this.department = user.getDepartment();
        this.experience = user.getExperience();
        this.setPrivateFields(user.getPrivateFields());
        this.lastActionDate = user.getLastActionDate();
    }

    @JsonIgnore
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public boolean isApproved()
    {
        return approved;
    }

    public void setApproved(boolean approved)
    {
        this.approved = approved;
    }

    public boolean isFirstRun()
    {
        return isFirstRun;
    }

    public void setFirstRun(boolean firstRun)
    {
        isFirstRun = firstRun;
    }

    public Integer getUserLevel()
    {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel)
    {
        this.userLevel = userLevel;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getProfileImage()
    {
        return profileImage;
    }

    public void setProfileImage(String profileImage)
    {
        this.profileImage = profileImage;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public int getGender()
    {
        return gender;
    }

    public void setGender(int gender)
    {
        this.gender = gender;
    }

    public Integer getUserStatus()
    {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus)
    {
        this.userStatus = userStatus;
    }

    public String getUserStatusOther()
    {
        return userStatusOther;
    }

    public void setUserStatusOther(String userStatusOther)
    {
        this.userStatusOther = userStatusOther;
    }

    public Integer getUserType()
    {
        return userType;
    }

    public void setUserType(Integer userType)
    {
        this.userType = userType;
    }

    public String getUserTypeOther()
    {
        return userTypeOther;
    }

    public void setUserTypeOther(String userTypeOther)
    {
        this.userTypeOther = userTypeOther;
    }

    public University getUniversity()
    {
        return university;
    }

    public void setUniversity(University university)
    {
        this.university = university;
    }

    public Faculty getFaculty()
    {
        return faculty;
    }

    public void setFaculty(Faculty faculty)
    {
        this.faculty = faculty;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getExperience()
    {
        return experience;
    }

    public void setExperience(String experience)
    {
        this.experience = experience;
    }

    public String[] getPrivateFields()
    {
        return privateFields;
    }

    public void setPrivateFields(String privateFields)
    {
        this.privateFields = privateFields.split(",");
    }

    public long getLastActionDate()
    {
        return lastActionDate;
    }

    public void setLastActionDate(long lastActionDate)
    {
        this.lastActionDate = lastActionDate;
    }
}
