package mybatis.mapper;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mybatis.config.SqlSessionBean;
import mybatis.vo.StudentVo;

public class StudentMapperDao {
  private SqlSessionFactory sqlSessionFactory = SqlSessionBean.getSessionFactory();

  public StudentVo selectByPk(String stuno) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
      return mapper.selectByPk(stuno);
    }
  }

  public List<StudentVo> selectAll() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
      return mapper.selectAll();
    }
  }

  public int insert(StudentVo vo) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
      StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
      return mapper.insert(vo);
    }
  }

  public int update(StudentVo vo) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
    sqlSession.close();
    return mapper.update(vo);
  }

  public int delete(String stuno) {
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
    sqlSession.close();
    return mapper.delete(stuno);
  }

}
