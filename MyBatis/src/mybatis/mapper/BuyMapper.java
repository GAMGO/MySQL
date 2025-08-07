package mybatis.mapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import mybatis.vo.BuyVo;
import mybatis.vo.CustomerBuyVo;

public interface BuyMapper {

    List<BuyVo> selectAll();

    List<BuyVo> selectByUser(String customer_id);

    List<BuyVo> selectByStuff(String pcode);

    List<BuyVo> selectByYears(String buy_date);

    int selectSum(String pcode);

    List<CustomerBuyVo> selectSaleByCustomer(String customer_id);

    // count 집계 함수
    Map<String, Integer> selectCountByYear(String year);

    List<Map<String, Object>> selectAllCountByYear();

}
