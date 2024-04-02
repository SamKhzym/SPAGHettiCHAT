package com.example.spaghettichat.datastructures;

import java.time.LocalTime;
import java.util.ArrayList;

public class Chat {

    private int chatId;
    private Account sender;
    private ArrayList<Account> receivers;
    private ArrayList<Message> messages;
    private boolean isVanishMode;
    private LocalTime creationTimestamp;

    public Chat(int chatId, Account sender, ArrayList<Account> receivers,
                ArrayList<Message> messages, boolean isVanishMode, LocalTime creationTimestamp) {

        this.chatId = chatId;
        this.sender = sender;
        this.receivers = receivers;
        this.messages = messages;
        this.isVanishMode = isVanishMode;
        this.creationTimestamp = creationTimestamp;

    }

}
