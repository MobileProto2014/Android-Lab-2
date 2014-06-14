package com.mobileproto.chatbox.models;

import java.io.Serializable;

/**
 * Created by clee2 on 5/31/2014.
 */
public class Channel implements Comparable, Serializable{
    private String id, name;
    private Chat lastChat;
    private long lastUpdated, timeCreated;

    public Channel(String id, String name){
        this.id = id;
        this.name = name;
    }

    /**
     * Getters
     */
    public Chat getLastChat() {
        return lastChat;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /**
     * Setters
     */
    public void setId(String id) {
        this.id = id;
    }

    public void setLastChat(Chat lastChat) {
        this.lastChat = lastChat;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }



    @Override
    public int compareTo(Object o) {
        return ((Channel)o).getLastUpdated() < getLastUpdated()?1:0;
    }
}
