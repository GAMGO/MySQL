package mybatis.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class StudentVo {
  private final String stuno;
  private final String name;
  private final Integer age;
  private final String addr;
}
