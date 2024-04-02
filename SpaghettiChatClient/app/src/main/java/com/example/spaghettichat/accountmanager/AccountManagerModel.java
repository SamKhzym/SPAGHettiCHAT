package com.example.spaghettichat.accountmanager;

import com.example.spaghettichat.datastructures.Account;

import java.util.ArrayList;

public class AccountManagerModel {

    private ArrayList<Account> localAccountCache;

    public AccountManagerModel() {

        this.fetchAccountData();

    }

    private void fetchAccountData() {

        // TODO: replace with logic to pull account info from server

        this.localAccountCache.add(new Account("khzyms", "Samuel", "Khzym", true));
        this.localAccountCache.add(new Account("khakiana", "Amaan", "Khakiani", true));
        this.localAccountCache.add(new Account("issah3", "Hamza", "Issa", true));
        this.localAccountCache.add(new Account("grewap17", "Preston", "Grewal", true));
        this.localAccountCache.add(new Account("athukorg", "Gayan", "Athukorala", true));
        this.localAccountCache.add(new Account("shmoej69", "Joe", "Shmoe", false));

    }

}
