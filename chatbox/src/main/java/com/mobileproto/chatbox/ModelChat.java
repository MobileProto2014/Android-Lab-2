package com.mobileproto.chatbox;

/**
 * Created by clee2 on 5/26/2014.
 */
public class ModelChat {
    public String sender, body, userId;
    public long time;

    public ModelChat(String sender, String message, String userId){
        this.sender = sender;
        this.body = message;
        this.userId = userId;
        this.time = System.currentTimeMillis();
    }
}
