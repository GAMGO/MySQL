
// import mybatis.dao.MybatisCustomerDao;
import java.util.List;

import mybatis.dao.MybatisProductDao;
// import mybatis.vo.CustomerVo;
import mybatis.vo.ProductVo;

public class App {
    public static void main(String[] args) throws Exception {
        // MybatisCustomerDao dao = new MybatisCustomerDao();
        System.out.println("========= 상품 관리 App ==========");
        boolean run = true;
        MybatisProductDao dao = new MybatisProductDao();
        while (run) {
            System.out.println("==== 선택 메뉴 ==== \n1. 검색 \n2. 상품등록 \n3. 삭제 \n4. 수정 \n5. 전체조회 \n6. 끝내기");
            String menu = System.console().readLine("메뉴 선택 >>>> ");
            switch (menu) {
                case "1":
                    List<ProductVo> productList = dao.search();
                    if (productList != null && !productList.isEmpty()) {
                        System.out.println("--- 상품 목록 ---");
                        for (ProductVo product : productList) {
                            delay(250);
                            System.out.println(product);
                        }
                    } else {
                        System.out.println("해당 키워드로 조회할 상품이 없습니다.");
                    }
                    break;
                case "2":
                    System.out.println(dao.insert());
                    break;
                case "3":
                    System.out.println(dao.delete());
                    break;
                case "4":
                    System.out.println(dao.update());
                    break;
                case "5":
                    productList = dao.selectAll();
                    if (productList != null && !productList.isEmpty()) {
                        System.out.println("--- 상품 목록 ---");
                        for (ProductVo product : productList) {
                            delay(250);
                            System.out.println(product);
                        }
                    } else {
                        System.out.println("등록된 상품이 없습니다.");
                    }
                    break;
                case "6":
                    System.out.println("종료합니다.");
                    delay(1200);
                    run = false;
                    break;
                default:
                    System.out.println("없는 메뉴 입니다.");
                    break;
            }
        }

    }

    private static void delay(int d) {
        try {
            Thread.sleep(d);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
