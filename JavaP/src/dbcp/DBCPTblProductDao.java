package dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import vo.ProductVo;

public class DBCPTblProductDao {

  private final DataSource dataSource = DBConnectionPool.getDataSource();

  // 상품 등록하기
  public int insert(ProductVo vo) {
    int result = 0;
    String sql = "INSERT INTO TBL_PRODUCT(pcode, category, pname, price)" +
        "VALUES(?, ?, ?, ?)";
    try (Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);) {
      pstmt.setString(1, vo.getPcode());
      pstmt.setString(2, vo.getPcategory());
      pstmt.setString(3, vo.getPname());
      pstmt.setInt(4, vo.getPrice());

      result = pstmt.executeUpdate();

    } catch (Exception e) {
      System.out.println("예외 : " + e.getMessage());
    }
    return result;
  }

  // 상품명, 가격 업데이트
  public int update(ProductVo vo) {
    int result = 0;
    String sql = "UPDATE TBL_PRODUCT SET pname = ?, price = ? WHERE pcode = ?";
    try (Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);) {
      pstmt.setString(1, vo.getPname());
      pstmt.setInt(2, vo.getPrice());
      pstmt.setString(3, vo.getPcode());

      result = pstmt.executeUpdate();

    } catch (Exception e) {
      System.out.println("예외 : " + e.getMessage());
    }
    return result;
  }

  // 기본키 값으로 삭제
  public int delete(String pcode) {
    int result = 0;
    String sql = "DELETE FROM tbl_product WHERE pcode = ?";
    try (Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);) {
      pstmt.setString(1, pcode);
      result = pstmt.executeUpdate();

    } catch (Exception e) {
      System.out.println("예외 : " + e.getMessage());
    }
    return result;
  }

  // 기본키 값으로 조회 - 0 또는 1개 행이 결과값
  public ProductVo selectByPk(String pcode) {
    String sql = "SELECT * FROM TBL_PRODUCT WHERE pcode = ?";
    ProductVo vo = null;
    try (Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);) {
      pstmt.setString(1, pcode);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        vo = new ProductVo(rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getInt(4));
      }
    } catch (Exception e) {
      System.out.println("예외 : " + e.getMessage());
    }
    return vo; // 조회 결과(행)가 없으면 product는 null
  }

  // 상품 조회 : 키워드로 조회 (0~n개 행 조회)
  // 예시 : select * from tbl_product where pname like '%kg%'
  public List<ProductVo> searchByKeyword(String keyword) {
    String sql = "select * from tbl_product where pname like '%' || ? ||'%'";
    List<ProductVo> list = new ArrayList<>();
    try ( // 자동 close
        Connection connection = dataSource.getConnection(); // 커넥션
        PreparedStatement pstat = connection.prepareStatement(sql); // sql 실행 준비
    ) {
      // sql 매개변수
      pstat.setString(1, keyword);
      // select 실행
      ResultSet rs = pstat.executeQuery();
      // rs 결과를 활용
      ProductVo vo = null;
      while (rs.next()) { // rs의 행집합은 n개 -> 반복으로 접근
        vo = new ProductVo(rs.getString(1),
            rs.getString(2),
            rs.getString(3),
            rs.getInt(4));
        // vo는 list에 추가
        list.add(vo);
      }

    } catch (Exception e) {
      System.out.println("예외 : " + e.getMessage());
      e.printStackTrace(); // 임시 (상세한 예외 원인 파악)
    }
    return list;
  }

}
