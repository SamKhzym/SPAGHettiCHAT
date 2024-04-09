package com.example.spaghettichat.datastructures;

import com.example.spaghettichat.datastructures.Account;
import com.example.spaghettichat.datastructures.Message;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Chat {

    private int chatId;
    private ArrayList<Account> participants;
    private ArrayList<Message> messages;
    private boolean isVanishMode;
    private Account creator;
    private LocalDateTime creationTimestamp;

    // default constructor
    public Chat() {}

    public Chat(int chatId, ArrayList<Account> participants, Account creator,
                ArrayList<Message> messages, boolean isVanishMode, LocalDateTime creationTimestamp) {

        this.chatId = chatId;
        this.creator = creator;
        this.participants = participants;
        this.messages = messages;
        this.isVanishMode = isVanishMode;
        this.creationTimestamp = creationTimestamp;

    }

    public int getChatId() { return chatId; }

    public ArrayList<Message> getMessages() { return messages; }

    public ArrayList<Account> getParticipants() { return participants; }

    public Account getCreator() { return creator; }

    public boolean isVanishMode() { return isVanishMode; }

    public LocalDateTime getCreationTimestamp() { return creationTimestamp; }

    public void setChatId(int chatId) { this.chatId = chatId; }

    public void setParticipants(ArrayList<Account> participants) { this.participants = participants; }

    public void addParticipant(Account account) { this.participants.add(account); }

    public void setCreator(Account creator) { this.creator = creator; }

    public void setMessages(ArrayList<Message> messages) { this.messages = messages; }

    public void addMessage(Message message) { this.messages.add(message); }

    public void setVanishMode(boolean vanishMode) { isVanishMode = vanishMode; }

    public void setCreationTimestamp(LocalDateTime creationTimestamp) { this.creationTimestamp = creationTimestamp; }

}
