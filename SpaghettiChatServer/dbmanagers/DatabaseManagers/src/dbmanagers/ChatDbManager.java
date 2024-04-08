package dbmanagers;

import datastructures.Account;
import datastructures.Chat;
import datastructures.Message;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ChatDbManager {

    private DbConnector conn;
    private String dbName;
    private AccountDbManager accountDb;
    private ChatDbManagerHelper dbHelper;

    public ChatDbManager() {
        this.conn = new DbConnector();
        this.dbName = "Chat";
        this.accountDb = new AccountDbManager();
        this.dbHelper = new ChatDbManagerHelper();
    }

    private Chat getChatFromResult(ResultSet result) throws SQLException {

        int chatId = result.getInt("chatId");
        Account creator = accountDb.getAccountByEmployeeId(result.getString("creatorId"));
        LocalDateTime ts = result.getTimestamp("creationTs").toLocalDateTime();

        ArrayList<Account> participants = dbHelper.getParticipantsInChat(chatId);
        ArrayList<Message> messages = dbHelper.getMessagesInChat(chatId);

        // construct Chat object from query data
        Chat chat = new Chat();
        chat.setChatId(chatId);
        chat.setCreator(creator);
        chat.setVanishMode(false);
        chat.setParticipants(participants);
        chat.setMessages(messages);
        chat.setCreationTimestamp(ts);

        return chat;

    }

    public ArrayList<Chat> getAllChats() {

        String query = "SELECT * FROM " + this.dbName;

        ArrayList<Chat> chats = new ArrayList<Chat>();

        try {

            ResultSet result = conn.executeQuery(query);
            while (result.next()) {
                chats.add(getChatFromResult(result));
            }

            return chats;

        } catch (Exception e) { System.out.println(e); return null; }

    }

    public boolean insertChatIntoDb(Chat c) {

        String query = "INSERT INTO " + this.dbName + " (creatorId, creationTs) " +
                "VALUES (?,?)";

        try {

            PreparedStatement ps = conn.getPreparedStatement(query);
            ps.setString(1, c.getCreator().getEmployeeId());
            ps.setTimestamp(2, Timestamp.valueOf(c.getCreationTimestamp()));

            ps.execute();

            return true;

        } catch (Exception e) { System.out.println(e); return false; }

    }

    public ArrayList<Chat> getAllChatsByAccount(String employeeId) {

        // TODO: FIGURE OUT HOW TO DO THIS QUERY... HARDER THAN I THOUGHT.
        // MAYBE MOVE THIS TO HELPER CLASS...
        return null;

    }

    public ArrayList<Chat> getAllChatsByAccount(Account account) {
        return getAllChatsByAccount(account.getEmployeeId());
    }

}