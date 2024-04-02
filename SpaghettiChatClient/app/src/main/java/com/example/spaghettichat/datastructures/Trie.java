package com.example.spaghettichat.datastructures;

import java.util.Arrays;
import java.util.HashMap;

public class Trie {

    private static final int ALPHABET_SIZE = 26;
    private static HashMap<Character, Integer> alphabetMap;
    private TrieNode root;

    private static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;
        Account account;

        private void initChildren() {
            Arrays.fill(children, null);
        }

        public TrieNode(boolean isEndOfWord, Account account) {
            this.isEndOfWord = isEndOfWord;
            this.account = account;
            this.initChildren();
        }

        public TrieNode() {
            this.isEndOfWord = false;
            this.account = null;
            this.initChildren();
        }

    }

    public Trie() {

        // initialize char to int hashmap
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alphabet.length(); i++) {
            alphabetMap.put(alphabet.charAt(i), i);
        }

        root = new TrieNode();

    }

    public void insert(Account account)
    {
        int level;
        String firstName = account.getFirstName();
        int length = firstName.length();
        int index;

        TrieNode currNode = root;

        for (level = 0; level < length; level++)
        {
            index = alphabetMap.get(firstName.charAt(level));
            if (currNode.children[index] == null) { currNode.children[index] = new TrieNode(); }
            currNode = currNode.children[index];
        }

        // mark last node as leaf
        currNode.isEndOfWord = true;
        currNode.account = account;
    }

}
