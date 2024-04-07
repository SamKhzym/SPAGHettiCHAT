package com.example.spaghettichat.chatmanager.chatlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spaghettichat.R;
import com.example.spaghettichat.chatmanager.ChatManagerActivity;
import com.example.spaghettichat.chatmanager.ChatSearchActivity;
import com.example.spaghettichat.databinding.ActivityChatManagerBinding;
import com.example.spaghettichat.messagemanager.message.MessageActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    String[] name = { "khzyms", "khakiana", "issah3", "grewap17", "athukorg", "shmoej69"};

    String[] message = {"hi", "hey", "hi", "hiiiiiiiii", "h", "hello."};
    ListView listView;
    private ActivityChatManagerBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xxx);
        CustomListAdapter ad = new CustomListAdapter(this, name, message);
        listView = (ListView) findViewById(R.id.listViewX);
        listView.setAdapter(ad);

        FloatingActionButton myFab = findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ChatSearchActivity.class));
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);

                String User = name[position];
                intent.putExtra("userID", User);
                startActivity(intent);
            }
        });

    }



}
