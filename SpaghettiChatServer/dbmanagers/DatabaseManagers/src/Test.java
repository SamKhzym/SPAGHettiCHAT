import datastructures.Chat;
import dbmanagers.ChatDbManager;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        ChatDbManager chatDb = new ChatDbManager();
        ArrayList<Chat> chats = chatDb.getAllChats();

        System.out.println(chats);

    }

}
