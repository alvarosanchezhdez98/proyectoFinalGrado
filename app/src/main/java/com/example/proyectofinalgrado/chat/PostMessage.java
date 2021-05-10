package com.example.proyectofinalgrado.chat;

import java.util.Map;

public class PostMessage extends Message{

    private Map time;

    //Default Constructor
    public PostMessage(){

    }

    //Simple Param Constructor
    public PostMessage(Map time){
        this.time=time;
    }

    //Full Param Constructor without image
    public PostMessage(String message,String name,String profilePic,String messageType,Map time){
        super(message,name,profilePic,messageType);
        this.time=time;
    }

    //Full Param Constructor with image
    public PostMessage(String message,String urlPic,String name,String profilePic,String messageType,Map time){
        super(message,urlPic,name,profilePic,messageType);
        this.time=time;
    }

    //Getter and Setter
    public Map getTime(){
        return time;
    }

    public void setTime(Map time){
        this.time=time;
    }
}
