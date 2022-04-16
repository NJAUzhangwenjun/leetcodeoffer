package designPattern.command;

import designPattern.command.command.Reason;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/** 类描述： @ClassName GetReason @Author 张文军 @Date 2022/4/16 23:28 @Version 1.0 */
@Component
public class GetReason implements ApplicationContextAware {

  private ApplicationContext context;

  public Map<String, String> getReason(String arg) {
    Map<String, Reason> reasons = context.getBeansOfType(Reason.class);
    Map<String, String> map = new HashMap<>();
    for (Reason reason : reasons.values()) {
      Map<String, String> reasonMap = reason.execute(arg);
      map.putAll(reasonMap);
    }
    return map;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.context = applicationContext;
  }
}
