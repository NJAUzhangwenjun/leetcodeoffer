package interview2021;

/**
 * @author 张文军 @Description: alibaba 面试2（） @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/3/1616:53
 */
public class AL {
  /**
   * 1. 整理项目 项目整理----web系统出现超时 https://blog.csdn.net/lv_victor/article/details/53148421 2. SQL注入
   * Mysql 3. 计算机网络 4. SpringMVC Servlet 4. redis 5.测试
   *
   * <p>1. mvc 2. sql注入 3. 算法
   */
  // 评测题目一：
  // A公司的收费方案：
  // 1、所有电话分为白天电话和晚上电话。
  // 2、白天是从早晨7点到晚上7点，剩下的时间算晚上。
  // 3、白天费用：第1分钟5毛，接下来每分钟1毛。
  // 4、晚上费用：第1分钟3毛，接下来10分钟总共收1元，其余每分钟1毛。
  // 要求：
  // 1、完成该需求的设计和实现；
  // 2、考虑一定的扩展性；
  // 提示：非算法题目。

  // 评测题目二：
  // 小强从一副扑克牌里拿出来一叠，其中包括 A、2、3，...，10，其中A代表1，他从这一叠中抽出一些给小明，
  // 并告诉小明每次可以按下面方式出牌：
  // 1、单牌，如一张2；
  // 2、对子，如两张7；
  // 3、顺子，如A12或34567，限制必须是3连或5连；
  // 4、连子，数字连续的3个对子，如223344；
  // 现在小强想知道最少出多少次牌，可以出完手中的牌；
  // 输入描述：空格分隔的整数，A1、A2、A3，...，A10（0<取值<4），代表牌为 A，2，3，...，10 的个数；
  // 输出描述：输出一个整数表示，最少出多少次牌；
  // 提示：可在自己电脑执行后，给出验证通过的输入和输出；

  /**
   * 如果可以出对子的牌，那么出对子肯定不会比出单牌要花更多步数。
   * 同样，可以出顺子的牌，出顺子也不会比出单排花费更多步数。
   * 可以出连对的牌，出连队一定不会比出单个对子或者单排花费更少的步数。
   * 然而连队和顺子之间没有包含关系，所以我们得到两个出牌优先级：
   *
   * <p>1.顺子>单排
   *
   * <p>2.连对>单对>单牌
   *
   * <p>虽然我们无法确定顺子和连对优先出谁，但是在代码实现上，我们可以将顺子放在连对上，
   * 但是即便顺子可以走，我们也不剪掉出连对的可能性，然而如果连对能走，我们就直接不考虑单排和单对的情况了。
   */
  public static int minCount = Integer.MAX_VALUE;

  public static void dfs(int[] nums, int count) {
    // 剪枝
    if (count > minCount) {
      return;
    }
    if (check(nums)) {
      int i = 0;
      while (nums[i] == 0) {
        i++;
      }
      // 单张
      if (nums[i] > 0) {
        nums[i]--;
        dfs(nums, count + 1);
        nums[i]++;
      }
      // 对子
      if (nums[i] > 1) {
        nums[i] -= 2;
        dfs(nums, count + 1);
        nums[i] += 2;
      }
      // 五连
      if (i + 5 <= nums.length
          && nums[i] > 0
          && nums[i + 1] > 0
          && nums[i + 2] > 0
          && nums[i + 3] > 0
          && nums[i + 4] > 0) {
        for (int j = 0; j < 5; j++) {
          nums[i + j]--;
        }
        dfs(nums, count + 1);
        for (int j = 0; j < 5; j++) {
          nums[i + j]++;
        }
      }
      // 三双
      if (i + 3 <= nums.length && nums[i] > 1 && nums[i + 1] > 1 && nums[i + 2] > 1) {
        nums[i] -= 2;
        nums[i + 1] -= 2;
        nums[i + 2] -= 2;
        dfs(nums, count + 1);
        nums[i] += 2;
        nums[i + 1] += 2;
        nums[i + 2] += 2;
      }
    } else {
      if (count < minCount) {
        minCount = count;
      }
    }
  }
  /** 判断是否已经出过 */
  private static boolean check(int[] nums) {
    boolean flag = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        flag = true;
        break;
      }
    }
    return flag;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {1, 1, 1, 2, 2, 2, 2, 2, 1, 1};
    dfs(nums, 0);
    System.out.println(minCount);
  }
}
