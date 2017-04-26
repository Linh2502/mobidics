package org.mobidics.model;

/**
 * Created by Long Bui on 28.02.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
public class Message
{
    public static final String CONTENT = "content";

    private long id;
    private User sender;
    private User receiver;
    private String content;

    public Message()
    {
        sender = null;
        receiver = null;
        content = "";
    }

    public User getSender()
    {
        return sender;
    }

    public void setSender(User sender)
    {
        this.sender = sender;
    }

    public User getReceiver()
    {
        return receiver;
    }

    public void setReceiver(User receiver)
    {
        this.receiver = receiver;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
}
