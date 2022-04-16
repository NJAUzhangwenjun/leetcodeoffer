package designPattern.command.reason;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述：
 *
 * @ClassName ReasonA
 * @Author 张文军
 * @Date 2022/4/16 23:12
 * @Version 1.0
 */
@Component
public class ReasonB {
    public Map<String,String> getReasonB(String arg){
        Map<String, String> map = new HashMap<>();
        map.put("问题B1", "原因是B1");
        map.put("问题B2", "原因是B2");
        return map;
    }
}
