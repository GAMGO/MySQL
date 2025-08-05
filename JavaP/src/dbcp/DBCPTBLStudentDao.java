package dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DBCPTBLStudentDao {

  private final DataSource dataSource = DBConnectionPool.getDataSource();

  public void updateAddress(String stuno, String addr) {
    String sql = "update tbl_student set addr = ? where stuno = ?";
    try ( // try with resources : 자동 close
        Connection conn = dataSource.getConnection();
        PreparedStatement pstat = conn.prepareStatement(sql);) {
      pstat.setString(1, addr);
      pstat.setString(2, stuno);
      pstat.executeUpdate();
    } catch (SQLException e) {
      System.out.println("SQL 예외 : " + e.getMessage());
    } // finally 없음. 자동 close 구문

  }

  public void insert(String stuno, String name, String age, String addr) {
    String sql = "insert into tbl_student(stuno,name,age,addr) values (?,?,?,?)";
    try (
        Connection conn = dataSource.getConnection();
        // System.out.println("conn :" + conn.getAutoCommit());
        PreparedStatement pstat = conn.prepareStatement(sql);) {
      System.out.println(conn.getAutoCommit());
      pstat.setString(1, stuno);
      pstat.setString(2, name);
      pstat.setString(3, age); // setInt(3,null) 불가. 오라클에서는 문자열을 number 타입으로 자동캐스팅
      pstat.setString(4, addr);

      pstat.executeUpdate();
      System.out.println("1개 행이 저장되었습니다.");
    } catch (SQLException e) {
      System.out.println("insert 예외 : " + e.getMessage());
    }
  }
}
