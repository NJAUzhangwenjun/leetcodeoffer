package designPattern.command.command;

import java.util.Map;

/**
 * 类描述：
 *
 * @ClassName Reason
 * @Author 张文军
 * @Date 2022/4/16 23:19
 * @Version 1.0
 */

public interface Reason {
    public Map<String,String> execute(String arg);
}
