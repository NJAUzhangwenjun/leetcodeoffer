package designPattern.command.command;

import designPattern.command.reason.ReasonB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/** 类描述： @ClassName Reason @Author 张文军 @Date 2022/4/16 23:19 @Version 1.0 */
@Component
public class CommandReasonB implements Reason {

  @Autowired
  private ReasonB reasonB;

  @Override
  public Map<String, String> execute(String arg) {
    return reasonB.getReasonB(arg);
  }
}
