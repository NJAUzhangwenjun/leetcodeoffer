package interview2021;

import java.util.Date;

/**
 * @author 张文军
 * @Description:
 *  A公司的收费方案：
 *  1、所有电话分为白天电话和晚上电话。
 *  2、白天是从早晨7点到晚上7点，剩下的时间算晚上。
 *  3、白天费用：第1分钟5毛，接下来每分钟1毛。
 *  4、晚上费用：第1分钟3毛，接下来10分钟总共收1元，其余每分钟1毛。
 *  要求：
 *  1、完成该需求的设计和实现；
 *  2、考虑一定的扩展性；
 *  提示：非算法题目。
 * @version:1.0
 * @date 2021/3/2517:09
 */
public interface ChargePlan {
  /** 获取计费
   * @param start 开始时间
   * @param end 结束时间
   * @return 费用
   */
  Double plan(Date start, Date end);

  /**
   * 白天费用
   * @param callTime
   * @return
   */
  Double getNightCost(Long callTime);

  /**
   * 夜晚费用
   * @param callTime
   * @return
   */
  Double getDayCost(Long callTime);

}
