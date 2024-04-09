package dbmanagers;

import datastructures.Account;
import datastructures.Chat;
import datastructures.Message;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ChatDbManagerHelper {

    private DbConnector conn;
    private String accountChatDbName, messageChatDbName;
    private ArrayList<String> fieldNames;
    private AccountDbManager accountDb;
    private MessageDbManager messageDb;

    public ChatDbManagerHelper() {
        this.conn = new DbConnector();
        this.accountChatDbName = "AccountInChat";
        this.messageChatDbName = "MessageInChat";
        this.accountDb = new AccountDbManager();
        this.messageDb = new MessageDbManager();
    }

    public ArrayList<Message> getMessagesInChat(int chatId) {

        // SQL QUERY FOR GETTING ALL ACCOUNTS FROM DATABASE
        String query = "SELECT msgId FROM " + this.messageChatDbName + " WHERE chatId = " + chatId;

        try {

            ArrayList<Message> messages = new ArrayList<Message>();

            ResultSet result = conn.executeQuery(query);
            while (result.next()) {
                int msgId = result.getInt("msgId");
                Message m = messageDb.getMessageFromId(msgId);
                messages.add(m);
            }

            return messages;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public ArrayList<Message> getMessagesInChat(Chat chat) {
        return getMessagesInChat(chat.getChatId());
    }

    public ArrayList<Account> getParticipantsInChat(int chatId) {

        String query = "SELECT employeeId FROM " + this.accountChatDbName + " WHERE chatId = " + chatId;

        try {

            ArrayList<Account> accounts = new ArrayList<Account>();

            ResultSet result = conn.executeQuery(query);
            while (result.next()) {
                String empId = result.getString("employeeId");
                Account a = accountDb.getAccountByEmployeeId(empId);
                accounts.add(a);
            }

            return accounts;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public ArrayList<Account> getParticipantsInChat(Chat chat) {
        return getParticipantsInChat(chat.getChatId());
    }

}
