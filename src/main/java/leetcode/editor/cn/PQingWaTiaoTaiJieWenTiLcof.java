// 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
// 示例 1：
//
// 输入：n = 2
// 输出：2
//
//
// 示例 2：
//
// 输入：n = 7
// 输出：21
//
//
// 示例 3：
//
// 输入：n = 0
// 输出：1
//
// 提示：
//
//
// 0 <= n <= 100
//
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
//
//
// Related Topics 递归

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

// Java：青蛙跳台阶问题 : 剑指 Offer 10- II
public class PQingWaTiaoTaiJieWenTiLcof {
  public static void main(String[] args) {
    /** f(n) = f(n-1)+f(n-2) */
    Solution solution = new PQingWaTiaoTaiJieWenTiLcof().new Solution();
    final int i = solution.numWays(44);
    System.out.println("i = " + i);
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numWays(int n) {
      if (n <= 1) return 1;
      int n0 = 1;
      int n1 = 1;
      for (int i = 2; i <= n; i++) {
        int i1 = (n0 + n1) % 1000000007;
        n0 = n1;
        n1 = i1;
      }
      return n1;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
