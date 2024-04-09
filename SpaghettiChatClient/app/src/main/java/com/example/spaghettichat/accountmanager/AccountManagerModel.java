package com.example.spaghettichat.accountmanager;

import com.example.spaghettichat.datastructures.Account;
import java.util.ArrayList;
import java.util.HashMap;

public class AccountManagerModel {

    private ArrayList<Account> localAccountCache;
    private HashMap<String, Account> localAccountMap;
    private static Account currentUser;

    public AccountManagerModel() {
        this.localAccountCache = new ArrayList<Account>();
        this.localAccountMap = new HashMap<String, Account>();
        this.fetchAccountData();
    }

    public ArrayList<Account> getAllAccounts() {
        return this.localAccountCache;
    }

    public void fetchAccountData() {

        this.localAccountCache = new ArrayList<>();
        this.localAccountCache.add(new Account("khzyms", "Samuel", "Khzym", true));
        this.localAccountCache.add(new Account("khakiana", "Amaan", "Khakiani", true));
        this.localAccountCache.add(new Account("issah3", "Hamza", "Issa", true));
        this.localAccountCache.add(new Account("grewap17", "Preston", "Grewal", true));
        this.localAccountCache.add(new Account("athukorg", "Gayan", "Athukorala", true));
        this.localAccountCache.add(new Account("shmoej69", "Joe", "Shmoe", false));

        this.localAccountMap = new HashMap<>();
        for (Account a : this.localAccountCache) {
            this.localAccountMap.put(a.getEmployeeId(), a);
        }

    }

    public Account getAccountByUserId(String empId) {
        return this.localAccountMap.get(empId);
    }

    public static Account getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Account user) {
        currentUser = user;
    }

}
