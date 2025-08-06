package mybatis.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.config.SqlSessionBean;
import mybatis.vo.ProductVo;

public class MybatisProductDao {
    // SqlSessionBean 클래스는 config 패키지에 있는 개발작 작성 클래스입니다.
    private SqlSessionFactory sessionFactory = SqlSessionBean.getSessionFactory();

    /*
     * 마이바티스의 SqlSession 객체가 SQL 을 실행합니다.
     * SQL 실행 메소드(CRUD) : insert() , update() , delete() 메소드 데이터 조작(추가/삭제/변경)
     * selectOne() 메소드는 select 조회 결과가 1개 행 일때
     * selectList() 메소드는 select 조회 결과가 여러개 행 일때 구분해서 사용
     * 위 5개 메소드의 인자 : 문자열 -> 매퍼 XML의 네임스페이스.id 값
     * 선택적인 두번째 인자 -> SQL 실행에 필요한 파라미터값
     */

    public ProductVo selectByPk() {
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            String pcode = System.console().readLine("상품 코드 >>> ");
            return sqlSession.selectOne("tblproduct.selectByPk", pcode);
        }
    }

    public List<ProductVo> selectAll() {
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            return sqlSession.selectList("tblproduct.selectAll");
        }
    }

    public List<ProductVo> search() {
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            String kw = System.console().readLine("Stuff name >>> ");
            return sqlSession.selectList("tblproduct.search", kw);
        }
    }

    // 마이바티스는 auto commit 이 아닙니다.
    public int insert() {
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            System.out.println("\t :: 상품 등록 ::");
            String pcode = System.console().readLine("상품 코드 >>> ");
            String pcategory = System.console().readLine("상품 품목코드 >>> ");
            String pname = System.console().readLine("상품명 >>> ");
            int price = Integer.parseInt(System.console().readLine("가격 >>> "));
            ProductVo vo = new ProductVo(pcode, pcategory, pname, price);
            int result = sqlSession.insert("tblproduct.insert", vo);
            String confirm = System.console().readLine("Commit these? (y)");
            switch (confirm) {
                case "y":
                    sqlSession.commit();
                    break;
                default:
                    System.out.println("Canceled commit.");
                    break;
            }
            return result;
        }
    }

    public int update() {
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            String pcode = System.console().readLine("상품 코드 >>> ");
            String pcategory = System.console().readLine("상품 품목코드 >>> ");
            String pname = System.console().readLine("상품명 >>> ");
            int price = Integer.parseInt(System.console().readLine("가격 >>> "));
            ProductVo vo = new ProductVo(pcode, pcategory, pname, price);
            int result = sqlSession.update("tblproduct.update", vo);
            String confirm = System.console().readLine("Update these?");
            switch (confirm) {
                case "y":
                    sqlSession.commit();
                    break;
                default:
                    System.out.println("Canceled Update.");
                    break;
            }
            return result;
        }
    }

    public int delete() {
        try (SqlSession sqlSession = sessionFactory.openSession()) {
            String pcode = System.console().readLine(" 삭제할 상품 코드 >>> ");
            int result = sqlSession.delete("tblproduct.delete", pcode);
            String confirm = System.console().readLine("DELETE? (can not rollback anymore) (y)");
            switch (confirm) {
                case "y":
                    sqlSession.commit();
                    break;
                default:
                    System.out.println("Canceled Update.");
                    break;
            }
            return result;
        }
    }

}
