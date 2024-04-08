package com.example.spaghettichat.datastructures;


import java.time.LocalTime;

public class Message implements Serializable {

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

    public int getMessageId() {
        return messageId;
    }

    public Account getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public LocalTime getTimestamp() {
        return timestamp;
    }

    public Message getLastMessage() {
        return lastMessage;
    }

    public boolean isVanished() {
        return isVanished;
    }
}
