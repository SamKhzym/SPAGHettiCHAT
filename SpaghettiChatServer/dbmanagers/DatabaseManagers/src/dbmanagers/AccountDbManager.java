package dbmanagers;

import datastructures.Account;

import java.sql.*;
import java.util.ArrayList;

public class AccountDbManager {

    private DbConnector conn;
    private String dbName;
    private ArrayList<String> fieldNames;

    public AccountDbManager() {
        this.conn = new DbConnector();
        this.dbName = "Account";
    }

    private Account getAccountFromResult(ResultSet result) throws SQLException {

        String empId = result.getString("employeeId");
        String firstName = result.getString("firstName");
        String lastName = result.getString("lastName");
        boolean isAdmin = result.getBoolean("isAdmin");

        return new Account(empId, firstName, lastName, isAdmin);

    }

    public ArrayList<Account> getAllAccounts() {

        // SQL QUERY FOR GETTING ALL ACCOUNTS FROM DATABASE
        String query = "SELECT * FROM " + this.dbName;

        ArrayList<Account> accounts = new ArrayList<Account>();

        try {

            ResultSet result = conn.executeQuery(query);
            while (result.next()) {
                accounts.add(getAccountFromResult(result));
            }

            return accounts;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public Account getAccountByEmployeeId(String empId) {

        // SQL QUERY FOR GETTING ALL ACCOUNTS FROM DATABASE
        String sql = "SELECT * FROM " + this.dbName + " WHERE employeeId = ?";

        try {

            PreparedStatement query = conn.getPreparedStatement(sql);
            query.setString(1, empId);

            // since we're searching by primary key, this should only return one response.
            // need to call next() to get to beginning of result set.
            ResultSet result = query.executeQuery();
            result.next();

            return getAccountFromResult(result);

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public boolean insertAccountIntoDb(Account a) {

        String query = "INSERT INTO " + this.dbName + " (employeeId, firstName, lastName, isAdmin) " +
                "VALUES (?,?,?,?)";

        try {

            PreparedStatement ps = conn.getPreparedStatement(query);
            ps.setString(1, a.getEmployeeId());
            ps.setString(2, a.getFirstName());
            ps.setString(3, a.getLastName());
            ps.setBoolean(4, a.getIsAdmin());

            ps.execute();

            return true;

        } catch (Exception e) { System.out.println(e); return false; }

    }

    public static void main(String args[]){

        AccountDbManager man = new AccountDbManager();

        ArrayList<Account> accounts = man.getAllAccounts();

        System.out.println(accounts);

        Account a = new Account("farona", "Arthur", "Faron", false);
        man.insertAccountIntoDb(a);

        accounts = man.getAllAccounts();

        System.out.println(accounts);

    }

}