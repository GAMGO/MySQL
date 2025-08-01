package util;

import lombok.*;
import java.sql.*;

public class oracleConnection {
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String USERNAME = "C##LMS";
    private static final String PASSWORD = "1253";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Oracale Connection Failed." + e.getMessage());
            // TODO: handle exception
        }
        return connection;
    }

    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println("Closing Failed." + e.getMessage());
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        System.out.println(conn);
        System.out.println(conn.getClass().getName());
    }
}
/*
 * oracle.jdbc.driver.T4CConnection@371a67ec
 * oracle.jdbc.driver.T4CConnection
 * 
 * INSERT INTO TBL_JAVAWORD VALUES (
 * 33,
 * 'connection',
 * '연결,접속',
 * '2'
 * );
 */