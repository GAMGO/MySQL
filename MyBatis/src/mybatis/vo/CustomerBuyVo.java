package mybatis.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CustomerBuyVo {
  private final String pcode;
  private final String pname;
  private final Integer price;
  private final Long money;

  @Override
  public String toString() {
    return "\n" + pcode + "\t" + pname + "\t" + price + "\t" + money + "\n";
  }

}
