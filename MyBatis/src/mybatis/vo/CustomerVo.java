package mybatis.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor   // 모든 프로퍼티값 초기화하는 생성자 코드
@RequiredArgsConstructor
public class CustomerVo {
	private final String customId;
    private final String name;
    private final String email;
    private final int age;
    private final Date regDate;
    private String postcode;
}
