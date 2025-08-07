package mybatis.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BuyVo {
    private final Integer buy_seq;
    private final String pcode;
    private final String customer_id;
    private final Integer quantity;
    private final String buy_date;

    @Override
    public String toString() {
        return "\n BUY SEQUENCE NUMBER : " + buy_seq + "\t PCODE : " + pcode + "\t 고객아이디 : " + customer_id
                + "\t 주문 수량 : "
                + quantity + "\t 구매날짜 : " + buy_date + "\n";
    }
}
