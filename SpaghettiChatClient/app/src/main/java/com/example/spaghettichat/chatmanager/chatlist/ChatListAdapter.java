package com.example.spaghettichat.chatmanager.chatlist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.spaghettichat.R;

public class ChatListAdapter extends ArrayAdapter {

    private final Activity context;
    private final String[] name;
    private final String[] message;

    public ChatListAdapter(Activity context, String[] nameList, String[] messageList){

        super(context,R.layout.adapter_chatlist, nameList);
        this.context=context;
        this.name = nameList;
        this.message = messageList;

    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.adapter_chatlist, null,true);
        TextView messageinput = (TextView) rowView.findViewById(R.id.infoTextViewID);
        TextView nameinput = (TextView) rowView.findViewById(R.id.nameTextViewID);
        nameinput.setText(name[position]);
        messageinput.setText(message[position]);
        return rowView;

    };}


