package org.mobidics.model;

import com.owlike.genson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: longbui1992@gmail.com
 */
@Entity @Table(name = "users", schema = "mobidics")
public class User
{
    @Id
    @Column(name = "username", nullable = false, length = 30)
    private String username;
    @Column(name = "password", length = 32)
    private String password;
    @Column(name = "email", length = 50)
    private String email;
    @Column(name = "timestamp", nullable = false)
    private int creationDate;
    @Column(name = "approved", nullable = false)
    private boolean approved;
    @Column(name = "isfirstrun", nullable = false)
    private boolean isFirstRun;
    @Column(name = "userlevel", nullable = false)
    private int userLevel;
    @Column(name = "language", nullable = false)
    private String language;
    @Column(name = "profilepicture")
    private String profileImage;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "gender")
    private int gender;
    @Column(name = "userstatus")
    private int userStatus;
    @Column(name = "usertype")
    private int userType;
    @Column(name = "usertype_other")
    private String usertypeOther;
    @ManyToOne(targetEntity = University.class)
    private University university;
    @ManyToOne(targetEntity = Faculty.class)
    @JoinColumn(name = "faculty_id", referencedColumnName = "nr")
    private Faculty faculty;
    @Column(name = "department")
    private String department;
    @Column(name = "experience", length = 3)
    private String experience;
    @Column(name = "private")
    private String privateFields;
    @Column(name = "date_modified", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateModified;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "favorites", joinColumns = @JoinColumn(name = "username"))
    @Column(name = "method_id")
    private Set<String> favorites;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(int timestamp)
    {
        this.creationDate = timestamp;
    }

    public boolean isApproved()
    {
        return approved;
    }

    public void setApproved(boolean approved)
    {
        this.approved = approved;
    }

    public boolean isIsFirstRun()
    {
        return isFirstRun;
    }

    public void setIsFirstRun(boolean isfirstrun)
    {
        this.isFirstRun = isfirstrun;
    }

    public int getUserLevel()
    {
        return userLevel;
    }

    public void setUserLevel(int userlevel)
    {
        this.userLevel = userlevel;
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

    public int getUserStatus()
    {
        return userStatus;
    }

    public void setUserStatus(int userStatus)
    {
        this.userStatus = userStatus;
    }

    public int getUserType()
    {
        return userType;
    }

    public void setUserType(int userType)
    {
        this.userType = userType;
    }

    public String getUsertypeOther()
    {
        return usertypeOther;
    }

    public void setUsertypeOther(String usertypeOther)
    {
        this.usertypeOther = usertypeOther;
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

    public String getPrivateFields()
    {
        return privateFields;
    }

    public void setPrivateFields(String privateFields)
    {
        this.privateFields = privateFields;
    }

    public Date getDateModified()
    {
        return dateModified;
    }

    public void setDateModified(Date dateModified)
    {
        this.dateModified = dateModified;
    }

    public Set<String> getFavorites()
    {
        return favorites;
    }

    public void setFavorites(Set<String> favorites)
    {
        this.favorites = favorites;
    }
}
