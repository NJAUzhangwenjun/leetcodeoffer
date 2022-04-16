package designPattern.command.command;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/** 类描述： @ClassName Reason @Author 张文军 @Date 2022/4/16 23:19 @Version 1.0 */
@Component
public class CommandReasonNO implements Reason {


  @Override
  public Map<String, String> execute(String arg) {
    return new HashMap<>();
  }
}
