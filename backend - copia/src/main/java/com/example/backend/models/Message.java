package com.example.backend.models;

public class Message {
    private String infoMessage;

    public Message(String infoMessage) {
        this.infoMessage = infoMessage;
    }

    public String getInfoMessage() {
        return this.infoMessage;
    }

    public Message() {
    }

    public void setInfoMessage(String infoMessage) {
        this.infoMessage = infoMessage;
    }
}

