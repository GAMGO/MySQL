package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import vo.ProductVo;

public class TblProductDao {
    private static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public int insert(ProductVo vo) {
        int result = 0;
        String sql = "INSERT INTO tbl_product(pcode,pcategory,pname,price) " +
                "VALUES (?, ?, ?, ?) ";
        try (Connection connection = getConnection(); PreparedStatement pstat = connection.prepareStatement(sql);) {
            pstat.setString(1, vo.getPcode());
            pstat.setString(2, vo.getPcategory());
            pstat.setString(3, vo.getPname());
            pstat.setObject(4, vo.getPrice());
            result = pstat.executeUpdate();
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
        return result;
    }

    public int update(ProductVo vo) {
        int result = 0;
        String sql = "UPDATE tbl_product SET pcategory = ?, pname =?, price =? WHERE pcode = ?";
        try (Connection connection = getConnection();
                PreparedStatement pstat = connection.prepareStatement(sql);) {
                    pstat.setString(1, vo.getPcategory());
                    pstat.setString(2, vo.getPname());
                    pstat.setInt(3, vo.getPrice());
                    pstat.setString(4, vo.getPcode());
                    result = pstat.executeUpdate();

        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
        return result;
    }

    // 기본키 값으로 삭제
    public int delete(String pId) {
        int result = 0;
        String sql = "DELETE FROM tbl_product WHERE pcode = ?";
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, pId);
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
        return result;
    }

    public List<ProductVo> selectByKywrd(String kw) {
        String sql = "select * from tbl_product where pname like '%'||?||'%'";
        List<ProductVo> l = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement pstat = connection.prepareStatement(sql);) {
            pstat.setString(1, kw);
            ResultSet rs = pstat.executeQuery();
            ProductVo vo = null;
            while (rs.next()) {
                vo = new ProductVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                l.add(vo);
            }
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
            e.printStackTrace();
        }
        return l;
    }

    public void update(String pcategory, String pname, int price, String pcode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
