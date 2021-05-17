package com.example.proyectofinalgrado.chat;

import java.util.Date;

public class Message {

    private String messageText;//Displays message data.
    private String messageUser;//Displays User Name
    private long messageTime;//Displays message time.

    //Default Constructor
    public Message(){

    }

    //Constructor
    public Message(String messageText,String messageUser){
        this.messageText=messageText;
        this.messageUser=messageUser;
        //Initializa message time with system time.
        messageTime = new Date().getTime();
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
