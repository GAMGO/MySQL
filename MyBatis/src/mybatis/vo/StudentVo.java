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
  private String stuno;
  private String name;
  private int age;
  private String address;

}
