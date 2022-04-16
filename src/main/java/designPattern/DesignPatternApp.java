package designPattern;

import designPattern.command.GetReason;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class DesignPatternApp {
  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    GetReason reason = context.getBean(GetReason.class);
    Map<String, String> reasonReason = reason.getReason("item100");
    for (String k : reasonReason.keySet()) {
      System.out.println(k + ":" + reasonReason.get(k));
    }
  }
}
