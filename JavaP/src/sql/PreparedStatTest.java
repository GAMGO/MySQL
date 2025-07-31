package sql;

import lombok.*;
import oracle.jdbc.driver.*;
import util.*;

import java.sql.*;

public class PreparedStatTest {
    public static void main(String[] args) {
        PreparedStatement pstat = null; // 마지막에 close 필요
        Connection conn = oracleConnection.getConnection();
        try {
            String sql = "INSERT INTO tbl_javadict(idx,english,korean,step) " +
                    "VALUES (?, ?, ?, ?)";
            pstat = conn.prepareStatement(sql); // 아직 실행 값이 정해지지 않은 상태에서 객체가 생성
            // ㄴ 오라클에게 sql 이거 실행할거야....
            int idx = 35;
            String english = "exception";
            String korean = "예외";
            String step = "3";
            // sql 실행에 필요한 값 ? 은 파라미터. 값을 바인딩(binding)
            pstat.setInt(1, idx);
            pstat.setString(2, english);
            pstat.setString(3, korean);
            pstat.setString(4, step);
            pstat.executeUpdate(); // 오라클은 구문 파싱 -> 컴파일 완료된 상황에서 값을 대입하여 실행

            System.out.println("SQL 실행 완료 : " + sql);
        } catch (SQLException e) {
            System.out.println("SQL 예외 : " + e.getMessage());
        } finally {
            oracleConnection.close(conn);
        }

    }
}
