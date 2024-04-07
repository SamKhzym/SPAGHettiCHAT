package com.example.spaghettichat.chatmanager;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.spaghettichat.databinding.ActivityChatManagerBinding;

import com.example.spaghettichat.R;
import com.example.spaghettichat.datastructures.Trie;

import java.lang.reflect.Array;
import java.util.List;

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
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                EditText searchBar = findViewById(R.id.searchBar);
                LinearLayout search_result_list = (LinearLayout)findViewById(R.id.search_result_list);
                if (searchBar.getVisibility() == View.GONE){
                    searchBar.setVisibility(View.VISIBLE);
                    search_result_list.setVisibility(View.VISIBLE);

                }
                else{
                    searchBar.setVisibility(View.GONE);
                    search_result_list.setVisibility(View.GONE);
                    search_result_list.removeAllViews();
                }




                Trie accounts = new Trie();
                accounts.insert("gayan");
                accounts.insert("sam");
                accounts.insert("hamza");
                accounts.insert("garb");


                String[] names = {"gayan", "sam", "hamza"};
                String[] emails = {"email1", "email2", "email3"};

                searchBar.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        search_result_list.removeAllViews();
                        List<String> suggestions = accounts.searchSuggestions(s.toString());
                        for (int i =0; i< suggestions.size();i++){
                            View result = inflater.inflate(R.layout.search_result, null );
                            TextView employee_name = (TextView) result.findViewById(R.id.employee_name);
                            TextView employee_email = (TextView) result.findViewById(R.id.employee_email);
                            employee_name.setText(suggestions.get(i));
                            employee_email.setText(emails[1]);
                            search_result_list.addView(result);

                        }


                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });








//                LinearLayout chatList = (LinearLayout)findViewById(R.id.chatList);
//                int count = chatList.getChildCount();
//
//
//                View newView = inflater.inflate(R.layout.sample_chat_view, null);
//                TextView employeeTextView = (TextView) newView.findViewById(R.id.employee_name);
//                employeeTextView.setText("Samuel Khzym");
//
//                TextView messageTextView = (TextView) newView.findViewById(R.id.message_sample);
//                messageTextView.setText("Have you ever heard the tragedy of darth plagueis the wise? it's not a story the jedi would tell you.");
//
//                TextView datetime = (TextView) newView.findViewById(R.id.timestamp);
//                datetime.setText("January 31, 9:30 PM");
//
//                chatList.addView(newView);
//
//                Snackbar.make(view, "I have " + count + " chats!", Snackbar.LENGTH_LONG)
//                        .setAnchorView(R.id.fab)
//                        .setAction("Action", null).show();
//
//                for (int i = 0; i < count; i++) {
//                    View child = chatList.getChildAt(i);
//                    TextView nameView = (TextView)child.findViewById(R.id.employee_name);
//                    System.out.println(nameView);
//                }

            }
        });
    }

}