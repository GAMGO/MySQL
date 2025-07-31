package ex;

import java.sql.*;
import util.oracleConnection;

public class TBLStudentTest {

    private static void update(String stuno, String addr) {
        String sql = "update tbl_student set addr = ? where stuno = ?";
        try {
            Connection conn = oracleConnection.getConnection();
            PreparedStatement pstat = conn.prepareStatement(sql);
            conn.setAutoCommit(false);
            pstat.setString(0, addr);
            pstat.setString(1, stuno);
            pstat.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private static void delete(String stuno) {
        Connection conn = oracleConnection.getConnection();
        PreparedStatement pstat = null;
        String sql = "delete from tbl_student WHERE stuno = ? ";
        try {
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, stuno);
            pstat.executeUpdate();
            conn.commit();
            System.out.println("Delete Successful.");
        } catch (Exception e) {
            System.out.println("Delete Exception!");
        }
    }

    private static void insert(String stuno, String name, String addr, String age) {
        Connection conn = oracleConnection.getConnection();
        PreparedStatement pstat = null;
        String sql = "insert into tbl_student(stuno,name,age,addr) values (?,?,?,?)";
        try {
            conn.setAutoCommit(false);
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, stuno);
            pstat.setString(2, name);
            pstat.setString(3, age);
            pstat.setString(4, addr);
            pstat.executeUpdate();
            conn.commit();
            System.out.println("Insert Successful.");
        } catch (SQLException e) {
            System.out.println("Insert Exception!");
        } finally {
            oracleConnection.close(conn);
            try {
                if (pstat != null) {
                    pstat.close();
                }
            } catch (SQLException e) {
            }

        }
    }

    public static void main(String[] args) {
        boolean isOn = true;
        System.out.println("'insert' or 'delete' ?");
        String mode = System.console().readLine("\n\t Insert Command : ");
        while (isOn) {
            switch (mode.toUpperCase()) {
                case "INSERT":
                    String stuno = System.console().readLine("Student Number ex) 2025001 : ");
                    String name = System.console().readLine("What is stduent's name? ");
                    String addr = System.console().readLine("Where is student lives? ");
                    String age = System.console().readLine("How old are you? ");
                    if (stuno.length() != 0 || name.length() != 0) {
                        if (addr.length() == 0) {
                            addr = null;
                        }
                        if (age.length() == 0) {
                            age = null;
                        }
                        insert(stuno, name, addr, age);
                    } else {
                        System.out.println("YOU MUST INSERT STUDENT's NAME,AGE,STUDENT NUMBER!");
                    }
                    break;
                case "DELETE":
                    stuno = System.console().readLine("Student Number ex) 2025001 : ");
                    delete(stuno);
                    break;
            }
        }

    }
}
