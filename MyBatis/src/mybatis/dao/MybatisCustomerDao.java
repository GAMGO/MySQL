package mybatis.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mybatis.config.SqlSessionBean;
import mybatis.vo.CustomerVo;

public class MybatisCustomerDao {
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

	public CustomerVo selectByPk(String customer_id) {
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			return sqlSession.selectOne("tblcustomer.selectByPk", customer_id);
		}
	}

	public List<CustomerVo> selectAll() {
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			return sqlSession.selectList("tblcustomer.selectAll");
		}
	}

	// 마이바티스는 auto commit 이 아닙니다.
	public int insert(CustomerVo vo) {
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			int result = sqlSession.insert("tblcustomer.insert", vo);
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

	public int update(CustomerVo vo) {
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			int result = sqlSession.update("tblcustomer.update", vo);
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

	public int delete(String customer_id) {
		try (SqlSession sqlSession = sessionFactory.openSession()) {
			int result = sqlSession.delete("tblcustomer.delete", customer_id);
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
