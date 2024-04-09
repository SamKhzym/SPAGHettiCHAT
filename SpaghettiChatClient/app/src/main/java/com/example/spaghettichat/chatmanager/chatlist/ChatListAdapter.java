package com.example.spaghettichat.chatmanager.chatlist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.spaghettichat.R;
import com.example.spaghettichat.accountmanager.AccountManagerModel;
import com.example.spaghettichat.datastructures.Chat;

import java.util.ArrayList;

public class ChatListAdapter extends ArrayAdapter {

    private final Activity context;
    private final String[] nameArray;
    private final String[] infoArray;

    public ChatListAdapter(Activity context, String[] name, String[] message){

        super(context,R.layout.adapter_chatlist, name);

        //String[] chatNames = new String[userChats.size()];
        //String[] previews = new String[userChats.size()];

        // iterate through all chats to get chat name array
        //for (int i = 0; i < userChats.size(); i++) {
        //    chatNames[i] = userChats.get(i).getRecipientString(AccountManagerModel.getCurrentUser());
        //    previews[i] = "Sample Chat";
        //}

        this.context=context;
        this.nameArray = name;
        this.infoArray = message;

    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View rowView=inflater.inflate(R.layout.adapter_chatlist, null,true);

        TextView nameTextField = (TextView) rowView.findViewById(R.id.nameTextViewID);
        TextView infoTextField = (TextView) rowView.findViewById(R.id.infoTextViewID);

        nameTextField.setText(nameArray[position]);
        infoTextField.setText(infoArray[position]);

        return rowView;

    };}


