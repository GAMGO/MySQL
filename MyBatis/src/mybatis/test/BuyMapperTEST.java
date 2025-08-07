package mybatis.test;

import java.util.List;
import java.util.Map;

import mybatis.mapper.BuyMapperDao;
import mybatis.vo.BuyVo;

public class BuyMapperTEST {
    public static void main(String[] args) {
        BuyMapperDao dao = new BuyMapperDao();
        String cutomerId = "hongGD"; // mina012, twice, hongGD , wonder
        System.out.println(cutomerId + "고객 구매 내역 집계 : " + dao.saleByCustomer(cutomerId));
        // 리턴타입이 Map
        String year = "2024";
        Map<String, Integer> result = dao.countByYear(year);
        System.out.println(year + " 년도 구매 건수 : " + result);
        // 2024 년도 구매 건수 : {YEAR=2024, COUNT=3} :
        // year는 key, 2024는 값(value) ,count는 key, 3은 값(value)
        System.out.println(result.get("YEAR"));
        System.out.println(result.get("COUNT"));

        System.out.println("-- 년도별 구매 건수 --");
        // Map 에서는 오라클 타입 number 의 자리수가 없으면 값을 BigDecimal 로 가져옵니다.
        // Map 의 제너릭타입을 Integer 사용 ❌ Object 로 대체. %d , %s 포맷 문자는 사용 못함.
        List<Map<String, Object>> list = dao.allCountByYear();
        System.out.println("년도\t구매건수\t수량합계");
        for (Map<String, Object> one : list) {
            System.out.println(one.get("YEAR") + "\t" + one.get("COUNT") + "\t\t" + one.get("SUM"));
        }
        // System.out.println(dao.selectByUser("mina012"));
        // System.out.println(dao.selectByStuff("JINRMn5"));
        // System.out.println(dao.selectByYears("2024"));
        // System.out.println(dao.selectSum("JINRMn5"));
    }
}
