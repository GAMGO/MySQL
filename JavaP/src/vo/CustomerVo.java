package vo;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor // 모든 프로퍼티값 초기화하는 생성자 코드
public class CustomerVo {
    private String customerId;
    private String name;
    private String email;
    private int age;
    private Date regDate;

}

// ORM 프레임웍을 사용하면 기본생성자, setter 가 필요합니다.