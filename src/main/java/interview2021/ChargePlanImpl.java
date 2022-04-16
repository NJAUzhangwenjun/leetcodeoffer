package interview2021;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/3/2515:26
 */
public class ChargePlanImpl implements ChargePlan {
  private static final String PATH = System.getProperty("user.dir");
  public static final Map<String, String> map =
      new PropertiesUtils(PATH).getMap("/src/main/resources/parameters.properties");

  private static Double cost = 0.0;
  private static final Long SECOND = 1000 * 60L;
  /**
   * 分析： 1. 只考虑开始时间和通话时长（目前实现） 2. 考虑开始时间和结束时间，即：考虑跨时段问题： - 跨时段后计费标准是用原来的还是用当前时间段的 -
   * 通话时间跨天后是否会又从头开始考虑
   *
   * @param start
   * @param end
   * @return
   */
  @Override
  public Double plan(Date start, Date end) {
    Long CallTime = (end.getTime() - start.getTime()) / SECOND;
    // 开始和结束都在晚上
    if (isNight(start)) {
      // 通话时间超过11分钟
      return getDayCost(CallTime);
    } else {
      // 通话时间超过11分钟
      return getNightCost(CallTime);
    }
  }

  @Override
  public Double getNightCost(Long callTime) {
    if (callTime > Double.parseDouble(map.get("dayCase1"))) {
      cost =
          Double.parseDouble(map.get("dc1"))
              + (callTime - Double.parseDouble(map.get("dayCase1")))
                  * Double.parseDouble(map.get("nc2"));
    } else {
      cost = Double.parseDouble(map.get("dc1"));
    }
    return cost;
  }

  @Override
  public Double getDayCost(Long callTime) {
    if (callTime
        > (Double.parseDouble(map.get("nightCase2")) + Double.parseDouble(map.get("nightCase1")))) {
      cost =
          Double.parseDouble(map.get("nc1"))
              + Double.parseDouble(map.get("nc2"))
              + (callTime
                      - (Double.parseDouble(map.get("nightCase2"))
                          + Double.parseDouble(map.get("nightCase1"))))
                  * 0.1;
    } else if (callTime > Double.parseDouble(map.get("nightCase1"))) {
      // 通话时间超过1分钟但是没有超过11分钟
      cost = Double.parseDouble(map.get("nc1")) + Double.parseDouble(map.get("nc2"));
    } else {
      cost = Double.parseDouble(map.get("nc1"));
    }
    return cost;
  }

  /**
   * 是否晚上7点到早上7点之间
   *
   * @param time
   * @return
   */
  public static boolean isNight(Date time) {
    // 设置当前时间
    Calendar date = Calendar.getInstance();
    date.setTime(time);
    // 处于开始时间之后，和结束时间之前的判断
    if (date.get(Calendar.HOUR_OF_DAY) >= 19 || date.get(Calendar.HOUR_OF_DAY) < 7) {
      return true;
    } else {
      return false;
    }
  }
}

class PropertiesUtils {
  private String PATH;

  public PropertiesUtils(String path) {
    this.PATH = path;
  }

  public Map<String, String> getMap(String path) {
    Properties properties = new Properties();
    properties = readFile(PATH + path);
    Map<String, String> map = new HashMap<String, String>((Map) properties);
    return map;
  }

  public Properties readFile(String path) {
    File file = new File(path);
    Properties properties = new Properties();
    InputStream in = null;
    try {
      in = new FileInputStream(file);
      properties.load(in);
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return properties;
  }

  public static void main(String[] args) {
    ChargePlan chargePlan = new ChargePlanImpl();
    Double plan = chargePlan.plan(new Date(100000000L), new Date(200000000L));
    System.out.println("plan = " + plan);
  }
}
