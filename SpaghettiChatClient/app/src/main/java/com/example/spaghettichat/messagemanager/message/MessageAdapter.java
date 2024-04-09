package com.example.spaghettichat.messagemanager.message;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.spaghettichat.R;
import com.example.spaghettichat.datastructures.Message;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Message> MessageList;

    public MessageAdapter(List<Message> messageList) {
        MessageList = messageList;
    }

    @Override
    public int getItemCount() {
        return MessageList.size();
    }

    @Override
    public final int getItemViewType(int position) {
        Message message = (Message)MessageList.get(position);
        if (message.getSender().equals("Me")) {
            return 1;
        } else {
            return 2;
        }
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == 1) {
             view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sample_message_sent, parent, false);
            return new SentMessageHolder(view);
        } else if (viewType == 2) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.sample_message_received, parent, false);
            return new ReceivedMessageHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Message message = MessageList.get(position);
        if(holder.getItemViewType()==1){
            ((SentMessageHolder) holder).messageText.setText(message.getMessage());

        }
        if(holder.getItemViewType()==2){
            ((ReceivedMessageHolder) holder).messageText.setText(message.getMessage());

        }

    }

    private class SentMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText, timeText;

        SentMessageHolder(View itemView) {
            super(itemView);
            messageText = itemView.findViewById(R.id.message_text_sent);
        }
    }

    private class ReceivedMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText;

        ReceivedMessageHolder(View itemView) {
            super(itemView);
            messageText = itemView.findViewById(R.id.message_text_received);
        }

                   }}
