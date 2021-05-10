package com.example.proyectofinalgrado.chat;

public class IncomingMessage extends Message{

    private Long time;

    //Default constructor.
    public IncomingMessage(){
    }

    //Param constructor
    public IncomingMessage(Long time){
        this.time=time;
    }

    //Full Param Constructor
    public IncomingMessage(String message,String urlPic,String name,String profilePic,String messageType,Long time){
        super(message,urlPic,name,profilePic,messageType);
        this.time=time;
    }

    //Getter and Setter
    public Long getTime(){
        return time;
    }

    public void setTime(Long time){
        this.time=time;
    }
}
