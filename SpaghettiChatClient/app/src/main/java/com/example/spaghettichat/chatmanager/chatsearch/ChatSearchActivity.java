package com.example.spaghettichat.chatmanager.chatsearch;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;

import com.example.spaghettichat.R;
import com.example.spaghettichat.messagemanager.message.MessageActivity;

import androidx.appcompat.widget.SearchView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChatSearchActivity extends  AppCompatActivity{
    private SearchView search;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_search);
        search = findViewById(R.id.search_view);
        list = findViewById(R.id.list_view);

        String[] name = {
                "khzyms", "khakiana", "issah3", "grewap17", "athukorg", "shmoej69"
        };


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, name);
        list.setAdapter(adapter);
        SearchView();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                String clickedName = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(ChatSearchActivity.this, MessageActivity.class);
                intent.putExtra("userID", clickedName);
                startActivity(intent);
            }
        });

    }
        private void search(String query) {
            ArrayAdapter<String> adapter = (ArrayAdapter<String>) list.getAdapter();
            adapter.getFilter().filter(query);
        }

        private void SearchView() {
            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    search(query);
                    return false;
                }
                @Override
                public boolean onQueryTextChange(String newText) {
                    search(newText);
                    return false;
                }
            });
        }

}
