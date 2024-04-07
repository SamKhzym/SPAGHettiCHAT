package com.example.spaghettichat.chatmanager;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.spaghettichat.databinding.ActivityChatManagerBinding;
import com.example.spaghettichat.chatmanager.chatlist.MainActivity;

public class ChatManagerActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityChatManagerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatManagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChatManagerActivity.this, MainActivity.class));
            }
        });


    }}






















//        binding = ActivityChatManagerBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        setSupportActionBar(binding.toolbar);
//
//
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////
////
////                LinearLayout chatList = (LinearLayout)findViewById(R.id.chatList);
////                int count = chatList.getChildCount();
////
////                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
////                View newView = inflater.inflate(R.layout.sample_chat_view, null);
////                TextView employeeTextView = (TextView) newView.findViewById(R.id.employee_name);
////                employeeTextView.setText("Samuel Khzym");
////
////                TextView messageTextView = (TextView) newView.findViewById(R.id.message_sample);
////                messageTextView.setText("Have you ever heard the tragedy of darth plagueis the wise? it's not a story the jedi would tell you.");
////
////                TextView datetime = (TextView) newView.findViewById(R.id.timestamp);
////                datetime.setText("January 31, 9:30 PM");
////
////                chatList.addView(newView);
////
////                Snackbar.make(view, "I have " + count + " chats!", Snackbar.LENGTH_LONG)
////                        .setAnchorView(R.id.fab)
////                        .setAction("Action", null).show();
////
////                for (int i = 0; i < count; i++) {
////                    View child = chatList.getChildAt(i);
////                    TextView nameView = (TextView)child.findViewById(R.id.employee_name);
////                    System.out.println(nameView);
////                }
////
////            }
////        });
//
//
//    }}