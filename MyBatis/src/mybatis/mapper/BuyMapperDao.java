package mybatis.mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import mybatis.config.SqlSessionBean;
import mybatis.vo.BuyVo;
import mybatis.vo.CustomerBuyVo;

public class BuyMapperDao {
    private SqlSessionFactory sqlSessionFactory = SqlSessionBean.getSessionFactory();

    public List<BuyVo> selectAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BuyMapper mapper = sqlSession.getMapper(BuyMapper.class);
            return mapper.selectAll();
        }
    }

    public List<BuyVo> selectByUser(String customer_id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
            BuyMapper mapper = sqlSession.getMapper(BuyMapper.class);
            return mapper.selectByUser(customer_id);
        }
    }

    public List<BuyVo> selectByStuff(String pcode) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
            BuyMapper mapper = sqlSession.getMapper(BuyMapper.class);
            return mapper.selectByStuff(pcode);
        }
    }

    public List<BuyVo> selectByYears(String buy_date) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
            BuyMapper mapper = sqlSession.getMapper(BuyMapper.class);
            return mapper.selectByYears(buy_date);
        }
    }

    public int selectSum(String pcode) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
            BuyMapper mapper = sqlSession.getMapper(BuyMapper.class);
            return mapper.selectSum(pcode);
        }
    }

    public List<CustomerBuyVo> saleByCustomer(String customer_id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BuyMapper mapper = sqlSession.getMapper(BuyMapper.class);
            return mapper.selectSaleByCustomer(customer_id);
        }
    }

    public Map<String, Integer> countByYear(String year) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BuyMapper mapper = sqlSession.getMapper(BuyMapper.class);
            return mapper.selectCountByYear(year);
        }
    }

    //
    public List<Map<String, Object>> allCountByYear() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BuyMapper mapper = sqlSession.getMapper(BuyMapper.class);
            return mapper.selectAllCountByYear();
        }
    }

}
