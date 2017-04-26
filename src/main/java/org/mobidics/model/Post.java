package org.mobidics.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Long Bui on 28.02.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
public class Post
{
    public static final String POST_CONTENT = "content";
    public static final String POSTER = "poster";
    public static final String LIKE_COUNT = "numOfLikes";
    public static final String LIKES = "likes";

    private long id;
    private String content;
    private User poster;
    private Set<User> likes;

    public Post()
    {
        content = "";
        poster = null;
        likes = new HashSet<>();
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public User getPoster()
    {
        return poster;
    }

    public void setPoster(User poster)
    {
        this.poster = poster;
    }

    public Set<User> getLikes()
    {
        return likes;
    }

    public void setLikes(Set<User> likes)
    {
        this.likes = likes;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public void addLike(User user)
    {
        likes.add(user);
    }
}
