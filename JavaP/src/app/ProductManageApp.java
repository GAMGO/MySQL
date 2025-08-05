package app;

import java.util.List;

import dao.TblProductDao;
import vo.ProductVo;

public class ProductManageApp {
    public static void main(String[] args) {
        System.out.println("========= 상품 관리 App ==========");
        boolean run = true;
        while (run) {
            System.out.println("선택 메뉴 : 1. 검색   2. 상품등록  3. 삭제  4. 수정");
            String menu = System.console().readLine("메뉴 선택 >>>> ");
            switch (menu) {
                case "1":
                    search();
                    break;
                case "2":
                    insert();
                    break;
                case "3":
                    delete();
                    break;
                case "4":
                    update();
                    break;
                default:
                    System.out.println("없는 메뉴 입니다.");
                    break;
            }
        }
    }

    private static void update() {
        System.out.println("\t :: 상품 정보 수정 ::");
        TblProductDao dao = new TblProductDao();
        String pcode = System.console().readLine(" 상품 코드 >>> ");
        String pcategory = System.console().readLine("상품 품목코드 >>> ");
        String pname = System.console().readLine("상품명 >>> ");
        int price = Integer.parseInt(System.console().readLine("가격 >>> "));
        ProductVo v = new ProductVo(pcode, pcategory, pname, price);
        dao.update(v);
    }

    private static void delete() {
        System.out.println("\t :: 상품 목록 삭제 ::");
        TblProductDao dao = new TblProductDao();
        String pcode = System.console().readLine("상품 코드 >>> ");
        dao.delete(pcode);
    }

    private static void insert() {
        System.out.println("\t :: 상품 등록 ::");
        TblProductDao dao = new TblProductDao();
        String pcode = System.console().readLine("상품 코드 >>> ");
        String pcategory = System.console().readLine("상품 품목코드 >>> ");
        String pname = System.console().readLine("상품명 >>> ");
        int price = Integer.parseInt(System.console().readLine("가격 >>> "));
        ProductVo vo = new ProductVo(pcode, pcategory, pname, price);
        if (dao.insert(vo) == 0)
            System.out.println("등록 실패!!!");
        else
            System.out.println("등록 완료!!");
    }

    private static void search() {
        String kw = System.console().readLine("......> ");
        TblProductDao dao = new TblProductDao();
        List<ProductVo> l = dao.selectByKywrd(kw);
        for (ProductVo vo : l) {
            System.out.println(
                    String.format("%s \t%s \t%s \t%d", vo.getPcode(), vo.getPcategory(), vo.getPname(), vo.getPrice()));
        }
    }
}
