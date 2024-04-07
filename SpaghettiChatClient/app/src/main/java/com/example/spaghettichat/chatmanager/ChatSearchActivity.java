package com.example.spaghettichat.chatmanager;
import static java.util.Locale.filter;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import androidx.recyclerview.widget.RecyclerView;

import com.example.spaghettichat.R;
import com.example.spaghettichat.databinding.ActivityChatManagerBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChatSearchActivity extends  AppCompatActivity{
    private SearchView search;
    private ListView list;
    private ActivityChatManagerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_search);

        search = findViewById(R.id.search_view);
        list = findViewById(R.id.list_view);

        String[] items = {
                "khzyms", "khakiana", "issah3", "grewap17", "athukorg", "shmoej69"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        list.setAdapter(adapter);
        setupSearchView();

    }
        private void filter(String query) {
            ArrayAdapter<String> adapter = (ArrayAdapter<String>) list.getAdapter();
            adapter.getFilter().filter(query);
        }

        private void setupSearchView() {
            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    filter(query);
                    return false;
                }
                @Override
                public boolean onQueryTextChange(String newText) {
                    filter(newText);
                    return false;
                }
            });
        }

}
