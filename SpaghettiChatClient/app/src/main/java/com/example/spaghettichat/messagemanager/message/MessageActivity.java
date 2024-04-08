package com.example.spaghettichat.messagemanager.message;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spaghettichat.R;
import com.example.spaghettichat.datastructures.Account;
import com.example.spaghettichat.datastructures.Message;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {

    private EditText messageInput;
    private Button sendButton;
    private Switch vanishModeSwitch;
    private List<Message> messageList;
//    private MessageAdapter adapter;
    private MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_ui);

        // Initialize views
        messageInput = findViewById(R.id.message_input);
        sendButton = findViewById(R.id.send_button);
        vanishModeSwitch = findViewById(R.id.switch_vanish_mode);

        String savedExtra = getIntent().getStringExtra("userID");
        TextView myText = (TextView) findViewById(R.id.chat_with_username);
        myText.setText(savedExtra);
        messageInput = findViewById(R.id.message_input);
        Button sendButton = findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.messages_recyclerview);
        messageList = new ArrayList<>();
        adapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void sendMessage() {
        String messageContent = messageInput.getText().toString().trim();
        if (!messageContent.isEmpty()) {
            // Assuming "Me" is the sender's name
            Message message = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                message = new Message(1, new Account("Me","p","g",true), messageContent,
                        LocalTime.now(), null, false);
            }
            messageList.add(message);
            adapter.notifyItemInserted(messageList.size() - 1);
            // Scroll RecyclerView to the bottom
            // Clear message input
            messageInput.getText().clear();
            // Simulate receiving a message after sending (for testing)
            simulateReceivedMessage();
        }
    }

    private void simulateReceivedMessage() {
        // Simulate receiving a message from another user after a delay (for testing)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Message receivedMessage = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    receivedMessage = new Message(2, new Account("Other User","gg","wer",true), "Hello!",
                            LocalTime.now(), null, false);
                }
                messageList.add(receivedMessage);
                adapter.notifyItemInserted(messageList.size() - 1);
                // Scroll RecyclerView to the bottom
            }
        }, 2000); // Simulate after 2 seconds
    }
}
