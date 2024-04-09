package com.example.spaghettichat.messagemanager.message;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.spaghettichat.R;
import com.example.spaghettichat.datastructures.Chat;

public class MessageActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText messageInput;
    private Button sendButton;
    private Switch vanishModeSwitch;
    private Chat chat;

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

        sendButton.setOnClickListener(this);

//}
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(this, "This is my Toast message!", Toast.LENGTH_LONG).show();

    }
}