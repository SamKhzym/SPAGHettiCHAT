package com.example.spaghettichat.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Trie {

    private static final int ALPHABET_SIZE = 26;
    private static HashMap<Character, Integer> alphabetMap = new HashMap<>();
    private static HashMap<Integer, String> indexToAlpha = new HashMap<>();
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

        for (int i = 0; i < alphabet.length(); i++) {
            indexToAlpha.put(i, String.valueOf(alphabet.charAt(i)));
        }


        root = new TrieNode();

    }

    public void insert(String account)
    {
        int level;
//        String firstName = account.getFirstName();
        String firstName = account;
        int length = firstName.length();

        int index;

        TrieNode currNode = root;

        for (level = 0; level < length; level++)
        {
            index = alphabetMap.get(firstName.charAt(level));
            if (currNode.children[index] == null) {
                currNode.children[index] = new TrieNode();
            }
            currNode = currNode.children[index];
        }

        // mark last node as leaf
        currNode.isEndOfWord = true;
//        currNode.account = account;
    }

    private TrieNode search(String query){
        int level;
        int length = query.length();
        TrieNode currNode = root;
        int index;
        for (level = 0; level<length;level++){
            index = alphabetMap.get(query.charAt(level));
            if (currNode.children[index] == null){
                return null;
            }
            currNode = currNode.children[index];
        }
        return currNode;
    }

    public List<String> searchSuggestions(String prefix){
        List<String> suggestions = new ArrayList<>();
        TrieNode currNode = search(prefix);
        if (currNode == null){
            return suggestions;
        }
        else{
            return findSuggestions(prefix, currNode, suggestions);
        }

    }

    private List<String> findSuggestions(String prefix, TrieNode currNode, List<String> suggestions){

        if (currNode.isEndOfWord){
            suggestions.add(prefix);
        }

        TrieNode[] children = currNode.children;

        for (TrieNode child:children){
            if (child != null){
                String suggestion = prefix;
                TrieNode nextNode = currNode;
                int index = Arrays.asList(children).indexOf(child);
                suggestion += indexToAlpha.get(index);
                nextNode = nextNode.children[index];
                suggestions = findSuggestions(suggestion, nextNode, suggestions );
            }
        }

        return suggestions;
    }






}
