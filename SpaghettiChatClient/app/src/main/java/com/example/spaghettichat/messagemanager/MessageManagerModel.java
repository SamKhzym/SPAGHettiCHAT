package com.example.spaghettichat.messagemanager;

import android.content.Intent;
import android.os.Bundle;

import com.example.spaghettichat.chatmanager.chatlist.ChatListActivity;
import com.example.spaghettichat.chatmanager.chatsearch.ChatSearchActivity;
import com.example.spaghettichat.datastructures.Chat;
import com.example.spaghettichat.messagemanager.message.MessageActivity;

public class MessageManagerModel {

    private Chat chat;

    public MessageManagerModel() {}

    public void startMessageSession(ChatSearchActivity activity, Chat chat) {
        this.chat = chat;
        Intent intent = new Intent(activity, MessageActivity.class);
        intent.putExtra("userID", chat.getParticipants().get(0).getFullName());
        activity.startActivity(intent);
    }

    public void startMessageSession(ChatListActivity activity, Chat chat) {
        this.chat = chat;
        Intent intent = new Intent(activity, MessageActivity.class);
        intent.putExtra("userID", chat.getParticipants().get(0).getFullName());
        activity.startActivity(intent);
    }

}
