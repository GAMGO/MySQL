package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.CustomerVo;

public class TblCustomerDao {

  // db연결 정보를 상수로 정의합니다.
  private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
  private static final String USERNAME = "c##idev";
  private static final String PASSWORD = "1234";

  // db연결 객체 만드는 메소드를 dao 에서만 사용할 수 있도록 정의
  private Connection getConnection() throws SQLException {
    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
  }

  // sql 실행 메소드 정의 -> 각 sql connection 만들어서 사용하고 sql 실행 후 close()
  public int insert(CustomerVo vo) {
    int result = 0;
    String sql = "INSERT INTO tbl_customer(customer_id, name, email, age, reg_date) " +
        "VALUES (?, ?, ?, ? , sysdate) ";
    try (Connection connection = getConnection();
        PreparedStatement pstat = connection.prepareStatement(sql);) {
      pstat.setString(1, vo.getCustomerId());
      pstat.setString(2, vo.getName());
      pstat.setString(3, vo.getEmail());
      pstat.setObject(4, vo.getAge() == 0 ? null : vo.getAge());

      result = pstat.executeUpdate();
    } catch (Exception e) {
      System.out.println("예외 : " + e.getMessage());
    }
    return result;
  }

  public int update(CustomerVo vo) {
    int result = 0;
    // 이메일, 우편번호 업데이트
    String sql = "UPDATE tbl_customer SET email = ? WHERE customer_id = ?";
    try (Connection connection = getConnection();
        PreparedStatement pstat = connection.prepareStatement(sql);) {
      pstat.setString(1, vo.getEmail());
      pstat.setString(2, vo.getCustomerId());
      result = pstat.executeUpdate();

    } catch (Exception e) {
      System.out.println("예외 : " + e.getMessage());
    }
    return result;
  }

  // 기본키 값으로 삭제
  public int delete(String customerId) {
    int result = 0;
    String sql = "DELETE FROM tbl_customer WHERE customer_id = ?";
    try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);) {
      pstmt.setString(1, customerId);
      result = pstmt.executeUpdate();
    } catch (Exception e) {
      System.out.println("예외 : " + e.getMessage());
    }
    return result;
  }

  // 기본키 custom_id 컬럼 값으로 조회
  public CustomerVo selectByPk(String customer_id) {
    String sql = "SELECT * FROM tbl_customer WHERE customer_id = ?";
    CustomerVo customer = null;
    try (Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);) {
      pstmt.setString(1, customer_id);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        customer = new CustomerVo(
            rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getInt(4), // age 컬럼
            rs.getDate(5)); // reg_date 컬럼
      }

    } catch (Exception e) {
      System.out.println("예외 : " + e.getMessage());
    }
    return customer;
  }
}
