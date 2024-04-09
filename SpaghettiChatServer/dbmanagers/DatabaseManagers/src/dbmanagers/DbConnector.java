package dbmanagers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class DbConnector {

    private Connection conn;
    private Statement stmt;
    private final String connectionLoc = "jdbc:mysql://localhost:3306/spaghettichat";
    private final String user = "root";
    private final String password = "root";

    public DbConnector() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionLoc, user, password);
            this.conn = conn;
            this.stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public ResultSet executeQuery(String sqlQuery) {

        try {
            return this.stmt.executeQuery(sqlQuery);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return this.conn.prepareStatement(sql);
    }

}
