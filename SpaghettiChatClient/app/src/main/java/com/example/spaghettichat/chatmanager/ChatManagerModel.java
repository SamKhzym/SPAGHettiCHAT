package com.example.spaghettichat.chatmanager;

import com.example.spaghettichat.accountmanager.AccountManagerModel;
import com.example.spaghettichat.datastructures.Account;
import com.example.spaghettichat.datastructures.Chat;

import java.util.ArrayList;

public class ChatManagerModel {

    // TODO: replace with a sorted arraylist implementation to sort the chats by timestamp of last message
    private AccountManagerModel accountManager;
    private ArrayList<Chat> localChatCache;
    private ArrayList<Chat> userChatList;

    public ChatManagerModel() {
        this.accountManager = new AccountManagerModel();
        this.localChatCache = new ArrayList<Chat>();
        this.userChatList = new ArrayList<Chat>();
        fetchChatData();
    }

    public void fetchChatData() {

        // TODO: replace with server call to query all chats

        Chat chat1 = new Chat();

        Account a1 = accountManager.getAccountByUserId("khzyms");
        Account a2 = accountManager.getAccountByUserId("khakiana");

        ArrayList<Account> participants = new ArrayList<>();
        participants.add(a1);
        participants.add(a2);

        chat1.setChatId(10);
        chat1.setCreator(a1);
        chat1.setParticipants(participants);

        localChatCache.add(chat1);

        // parse through all chats and populate only the ones the currently logged in user is involved with
        for (Chat chat : localChatCache) {
            ArrayList<Account> p = chat.getParticipants();

            // if the currently logged in user is one of the participants, add this chat to the chat list
            for (Account a : p) {
                if (AccountManagerModel.getCurrentUser().getEmployeeId().equals(a.getEmployeeId())) {
                    userChatList.add(chat);
                }
            }

        }

    }

    public ArrayList<Chat> getUserChatList() {
        return this.userChatList;
    }

}
