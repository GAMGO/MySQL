package ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.oracleConnection;

public class TBLBuySelectTest {
    public static void main(String[] args) {
        // selectByPk();
        selectByCustomerId();
    }

    public static void selectByPk() {
        String temp = System.console().readLine("구매 번호 입력 >>> ");
        String sql = "select * from tbl_buy where buy_seq=?"; // buy_seq 컬럼 조회하기
        Connection connection = oracleConnection.getConnection();
        try (
                PreparedStatement pstat = connection.prepareStatement(sql); // 자동 close
        ) {
            // 매개변수값 전달하기
            int buy_seq = Integer.parseInt(temp);
            pstat.setInt(1, buy_seq);
            // 실행한 결과 행집합 ResultSet 타입으로 참조하기
            ResultSet rs = pstat.executeQuery();
            // 결과 행 있으면 가져오기(1회) - 컬럼값들 출력
            if (rs.next()) {
                System.out.println("고객 ID : " + rs.getString(2));
                System.out.println("상품 코드 : " + rs.getString(3));
                System.out.println("구매 수량 : " + rs.getInt(4));
                System.out.println("구매 날짜 : " + rs.getDate(5)); // 또는 rs.getTimestamp(5)
            } else {
                System.out.println("구매 번호 " + temp + "의 구매 내역이 없습니다.");
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("selectByPk 예외 : " + e.getMessage());
        } finally {
            oracleConnection.close(connection);
        }
    }

    public static void selectByCustomerId() {
        String customerid = System.console().readLine("구매 내역 조회 고객ID 입력 >>> ");
        String sql = "select * from tbl_buy where customer_id =?"; // customer_id 컬럼 조회하기
        Connection connection = oracleConnection.getConnection();
        try (
                PreparedStatement pstat = connection.prepareStatement(sql); // 자동 close
        ) {
            // 매개변수값 전달하기
            pstat.setString(1, customerid);
            // 실행한 결과 행집합 ResultSet 타입으로 참조하기
            ResultSet rs = pstat.executeQuery();
            // 순차적으로 결과 행 가져오기(n 회) - 컬럼값들 출력
            int count = 0;
            while (rs.next()) { // 결과 집합의 다음 행으로 커서 이동. 행 있으면 참 없으면 거짓
                count++;
                System.out.println(String.format("%4d \t%10s \t%10s \t%2d \t%s" // 출력 포맷 설정
                        , rs.getInt(1) // 구매번호
                        , rs.getString(2) // 고객 ID
                        , rs.getString(3) // 상품코드
                        , rs.getInt(4) // 구매 수량
                        , rs.getTimestamp(5))); // 구매 날짜 rs.getDate(5) 로 하면 날짜만 출력
            }
            if (count == 0)
                System.out.println(customerid + " 회원 구매 내역이 없습니다.");
            else
                System.out.println(customerid + " 회원 " + count + "건 구매 내역이 없습니다.");
        } catch (SQLException | NumberFormatException e) {
            System.out.println("selectByPk 예외 : " + e.getMessage());
        } finally {
            oracleConnection.close(connection);
        }
    }
}
