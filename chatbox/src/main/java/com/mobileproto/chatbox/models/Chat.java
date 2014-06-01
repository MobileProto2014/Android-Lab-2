package com.mobileproto.chatbox.models;

/**
 * Created by clee2 on 5/26/2014.
 */
public class Chat implements Comparable {
    public String sender, body, userId;
    public long time;

    public Chat(String sender, String message, String userId){
        this.sender = sender;
        this.body = message;
        this.userId = userId;
        this.time = System.currentTimeMillis();
    }

    @Override
    public int compareTo(Object object) {
        return (time < ((Chat) object).time)?1:0;
    }
}
