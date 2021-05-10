package com.example.proyectofinalgrado.chat;

public class Message {

    private String message;
    private String urlPic;
    private String name;
    private String profilePic;
    private String messageType;

    //Default Constructor.
    public Message(){

    }

    //Constructor if message doesnt contains an image.
    public Message(String message,String name,String profilePic,String messageType){
        this.message=message;
        this.name=name;
        this.profilePic=profilePic;
        this.messageType = messageType;
    }

    //Constructor if message containts an image.
    public Message(String message,String urlPic,String name,String profilePic,String messageType){
        this.message=message;
        this.urlPic=urlPic;
        this.name=name;
        this.profilePic=profilePic;
        this.messageType=messageType;
    }

    //Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrlPic() {
        return urlPic;
    }

    public void setUrlPic(String urlPic) {
        this.urlPic = urlPic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
}
