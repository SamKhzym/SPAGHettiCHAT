package dbmanagers;

import datastructures.Account;
import datastructures.Message;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MessageDbManager {

    private DbConnector conn;
    private String dbName;
    private AccountDbManager accountDb;

    public MessageDbManager() {
        this.conn = new DbConnector();
        this.dbName = "Message";
        this.accountDb = new AccountDbManager();
    }

    private Message getMessageFromResult(ResultSet result) throws SQLException {

        int msgId = result.getInt("msgId");
        String msgString = result.getString("msgString");
        Account sender = accountDb.getAccountByEmployeeId(result.getString("sender"));
        LocalDateTime ts = result.getTimestamp("ts").toLocalDateTime();
        boolean isVanish = result.getBoolean("isVanish");

        return new Message(msgId, sender, msgString, ts, isVanish);

    }

    public Message getMessageFromId(int msgId) {

        // SQL QUERY FOR GETTING ALL ACCOUNTS FROM DATABASE
        String query = "SELECT * FROM " + this.dbName + " WHERE msgId = " + msgId;

        try {

            ResultSet result = conn.executeQuery(query);

            // since we're searching by primary key, this should only return one response.
            // need to call next() to get to beginning of result set.
            result.next();
            return getMessageFromResult(result);

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public boolean insertMessageIntoDb(Message m) {

        String query = "INSERT INTO " + this.dbName + " (msgString, sender, ts, isVanish) " +
                "VALUES (?,?,?,?)";

        try {

            PreparedStatement ps = conn.getPreparedStatement(query);
            ps.setString(1, m.getMessage());
            ps.setString(2, m.getSender().getEmployeeId());
            ps.setTimestamp(3, Timestamp.valueOf(m.getTimestamp()));
            ps.setBoolean(4, m.isVanished());

            ps.execute();

            return true;

        } catch (Exception e) { System.out.println(e); return false; }

    }

}
