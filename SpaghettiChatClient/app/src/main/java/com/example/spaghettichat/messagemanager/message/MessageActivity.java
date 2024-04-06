package com.example.spaghettichat.messagemanager.message;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import androidx.recyclerview.widget.RecyclerView;

import com.example.spaghettichat.R;

public class MessageActivity extends AppCompatActivity {

    private EditText messageInput;
    private Button sendButton;
    private Switch vanishModeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_ui);

        // Initialize views
        messageInput = findViewById(R.id.message_input);
        sendButton = findViewById(R.id.send_button);
        vanishModeSwitch = findViewById(R.id.switch_vanish_mode);

//}
    }}