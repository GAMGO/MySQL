package sql;

import lombok.*;
import oracle.jdbc.driver.*;
import util.*;

import java.sql.*;

public class StatementTest {
    public static void main(String[] args) {
        Statement stat = null;
        Connection conn = oracleConnection.getConnection();
        try {
            stat = conn.createStatement();
            String sql = "INSERT INTO TBL_JAVAWORD VALUES (33,'connection','연결,접속','2')";
            stat.execute(sql);
        } catch (SQLException e) {
            System.out.println("SQL EXCEPTION alert! - " + e.getMessage());
            // TODO: handle exception
        } finally {
            oracleConnection.close(conn);
        }

    }
}
