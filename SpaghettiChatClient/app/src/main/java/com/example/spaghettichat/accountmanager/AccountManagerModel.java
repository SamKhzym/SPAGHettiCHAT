package com.example.spaghettichat.accountmanager;

import java.util.ArrayList;

public class AccountManagerModel {

    private ArrayList<Account> localAccountCache;

    public AccountManagerModel() {

        this.fetchAccountData();

    }

    private void fetchAccountData() {

        // TODO: replace with logic to pull account info from server

        this.localAccountCache.add(new Account("khzyms", "Samuel", "Khzym", true));
        this.localAccountCache.add(new Account("khzyms", "Samuel", "Khzym", true));
        this.localAccountCache.add(new Account("khzyms", "Samuel", "Khzym", true));
        this.localAccountCache.add(new Account("khzyms", "Samuel", "Khzym", true));
        this.localAccountCache.add(new Account("khzyms", "Samuel", "Khzym", true));

    }

}
