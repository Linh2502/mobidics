package org.mobidics.model;

import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;

/**
 * Created by Long Bui on 26.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
@NamedQueries({
        @NamedQuery(
                name = "updateUserByUsername",
                query = "update User set" +
                        " firstname = :firstname," +
                        " lastname = :lastname," +
                        " password = :password, " +
                        " email =:email," +
                        " language = :language," +
                        " birthday = :birthday," +
                        " gender = :gender," +
                        " userstatus = :userstatus," +
                        " usertype = :usertype," +
                        " universityId = :universityId," +
                        " department = :department," +
                        " facultyId = :facultyId," +
                        " experience = :experience" +
                        " where username = :username"
        ),
        @NamedQuery(
                name = "deleteUserByUsername",
                query = "delete User where username = :username"
        )
})
@Entity @Table(name = "users", schema = "mobidics")
public class User
{
    private String username;
    private String password;
    private String email;
    private int creationDate;
    private boolean approved;
    private boolean isFirstRun;
    private int userLevel;
    private String language;
    private String profilepicture;
    private String firstname;
    private String lastname;
    private Date birthday;
    private int gender;
    private int userstatus;
    private int usertype;
    private String usertypeOther;
    private String universityId;
    private int facultyId;
    private String department;
    private String experience;
    private String privateFields;
    private Timestamp dateModified;

    @Id
    @Column(name = "username", nullable = false, length = 30)
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 32)
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Basic
    @Column(name = "timestamp", nullable = false)
    public int getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(int timestamp)
    {
        this.creationDate = timestamp;
    }

    @Basic
    @Column(name = "approved", nullable = false)
    public boolean isApproved()
    {
        return approved;
    }

    public void setApproved(boolean approved)
    {
        this.approved = approved;
    }

    @Basic
    @Column(name = "isfirstrun", nullable = false)
    public boolean isIsFirstRun()
    {
        return isFirstRun;
    }

    public void setIsFirstRun(boolean isfirstrun)
    {
        this.isFirstRun = isfirstrun;
    }

    @Basic
    @Column(name = "userlevel", nullable = false)
    public int getUserLevel()
    {
        return userLevel;
    }

    public void setUserLevel(int userlevel)
    {
        this.userLevel = userlevel;
    }

    @Basic
    @Column(name = "language", nullable = false, length = 255)
    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    @Basic
    @Column(name = "profilepicture", nullable = true, length = 255)
    public String getProfilepicture()
    {
        return profilepicture;
    }

    public void setProfilepicture(String profilepicture)
    {
        this.profilepicture = profilepicture;
    }

    @Basic
    @Column(name = "firstname", nullable = true, length = 255)
    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = true, length = 255)
    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "birthday", nullable = true)
    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public int getGender()
    {
        return gender;
    }

    public void setGender(int gender)
    {
        this.gender = gender;
    }

    @Basic
    @Column(name = "userstatus", nullable = true)
    public int getUserstatus()
    {
        return userstatus;
    }

    public void setUserstatus(int userstatus)
    {
        this.userstatus = userstatus;
    }

    @Basic
    @Column(name = "usertype", nullable = true)
    public int getUsertype()
    {
        return usertype;
    }

    public void setUsertype(int usertype)
    {
        this.usertype = usertype;
    }

    @Basic
    @Column(name = "usertype_other", nullable = true, length = 255)
    public String getUsertypeOther()
    {
        return usertypeOther;
    }

    public void setUsertypeOther(String usertypeOther)
    {
        this.usertypeOther = usertypeOther;
    }

    @Basic
    @Column(name = "university_id", nullable = true, length = 255)
    public String getUniversityId()
    {
        return universityId;
    }

    public void setUniversityId(String universityId)
    {
        this.universityId = universityId;
    }

    @Basic
    @Column(name = "faculty_id", nullable = true)
    public int getFacultyId()
    {
        return facultyId;
    }

    public void setFacultyId(int facultyId)
    {
        this.facultyId = facultyId;
    }

    @Basic
    @Column(name = "department", nullable = true, length = 255)
    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    @Basic
    @Column(name = "experience", nullable = true, length = 3)
    public String getExperience()
    {
        return experience;
    }

    public void setExperience(String experience)
    {
        this.experience = experience;
    }

    @Basic
    @Column(name = "private", nullable = true, length = 255)
    public String getPrivateFields()
    {
        return privateFields;
    }

    public void setPrivateFields(String privateFields)
    {
        this.privateFields = privateFields;
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
}
