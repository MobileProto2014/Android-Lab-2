package com.mobileproto.chatbox.models;

import java.io.Serializable;

/**
 * Created by clee2 on 5/26/2014.
 */
public class Chat implements Comparable, Serializable {
    private String sender, body, userId;
    private long time;

    public Chat(String sender, String message, String userId){
        this.sender = sender;
        this.body = message;
        this.userId = userId;
        this.time = System.currentTimeMillis();
    }

    /**
     * Getters
     */
    public String getSender() {
        return sender;
    }

    public long getTime() {
        return time;
    }

    public String getBody() {
        return body;
    }

    public String getUserId() {
        return userId;
    }

    /**
     * Setters
     */
    public void setBody(String body) {
        this.body = body;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int compareTo(Object object) {
        return (time < ((Chat) object).time)?1:0;
    }
}
