package com.mobileproto.chatbox.models;

/**
 * Created by clee2 on 5/31/2014.
 */
public class Channel {
    private String id, name;
    public Channel(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

//    public void setId(String newId){
//        this.id = newId;
//    }

    public void setName(String newName){
        this.name = newName;
    }
}
