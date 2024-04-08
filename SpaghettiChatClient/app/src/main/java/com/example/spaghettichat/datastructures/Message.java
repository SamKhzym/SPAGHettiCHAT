package com.example.spaghettichat.datastructures;

import java.time.LocalTime;

public class Message {

    private int messageId;
    private Account sender;
    private String message;
    private LocalTime timestamp;
    private Message lastMessage;
    private boolean isVanished;

    public Message(int messageId, Account sender, String message,
                   LocalTime timestamp, Message lastMessage, boolean isVanished) {

        this.isVanished = isVanished;
        this.lastMessage = lastMessage;
        this.message = message;
        this.sender = sender;
        this.timestamp = timestamp;
        this.messageId = messageId;

    }

    public String getSender() {
        return sender.getEmployeeId();
    }
    public String getMessage() {
        return message;
    }

}
