package datastructures;

import java.time.LocalDateTime;

public class Message {

    private int messageId;
    private Account sender;
    private String message;
    private LocalDateTime timestamp;
    private boolean isVanished;

    // default constructor
    public Message() {}

    public Message(int messageId, Account sender, String message, LocalDateTime timestamp, boolean isVanished) {

        this.isVanished = isVanished;
        this.message = message;
        this.sender = sender;
        this.timestamp = timestamp;
        this.messageId = messageId;

    }

    public int getMessageId() { return messageId; }

    public Account getSender() { return sender; }

    public String getMessage() { return message; }

    public LocalDateTime getTimestamp() { return timestamp; }

    public boolean isVanished() { return isVanished; }

    public void setVanished(boolean vanished) { isVanished = vanished; }

    public void setMessage(String message) { this.message = message; }

    public void setSender(Account sender) { this.sender = sender; }

    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public void setMessageId(int messageId) { this.messageId = messageId; }

}
