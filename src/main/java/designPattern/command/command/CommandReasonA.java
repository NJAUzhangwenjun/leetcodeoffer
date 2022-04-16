package designPattern.command.command;

import designPattern.command.reason.ReasonA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 类描述：
 *
 * @ClassName Reason
 * @Author 张文军
 * @Date 2022/4/16 23:19
 * @Version 1.0
 */
@Component
public class CommandReasonA implements Reason {

    @Autowired
    private ReasonA reasonA;


    @Override
    public Map<String, String> execute(String arg) {
    return reasonA.getReasonA(arg);
    }
}
