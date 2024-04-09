package com.example.spaghettichat.chatmanager.chatsearch;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;

import com.example.spaghettichat.R;
import com.example.spaghettichat.accountmanager.AccountManagerModel;
import com.example.spaghettichat.chatmanager.ChatManagerModel;
import com.example.spaghettichat.datastructures.Account;
import com.example.spaghettichat.messagemanager.message.MessageActivity;

import androidx.appcompat.widget.SearchView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ChatSearchActivity extends  AppCompatActivity{
    private SearchView search;
    private ListView list;

    private AccountManagerModel accountManager = new AccountManagerModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_search);
        search = findViewById(R.id.search_view);
        list = findViewById(R.id.list_view);

        // construct account list that user can select from
        ArrayList<Account> accounts = accountManager.getAllAccounts();
        ArrayList<String> names = new ArrayList<String>();

        // iterate through all accounts and populate arraylist of names
        for (Account a : accounts) {
            String nameString = a.getFullName() + " (" + a.getEmployeeId() + ")";
            names.add(nameString);
        }

        // change to datatype search bar needs
        String[] namesArray = new String[names.size()];
        namesArray = names.toArray(namesArray);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, namesArray);
        list.setAdapter(adapter);
        setupSearchView();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedName = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(ChatSearchActivity.this, MessageActivity.class);
                intent.putExtra("userID", clickedName);
                startActivity(intent);
            }
        });

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
