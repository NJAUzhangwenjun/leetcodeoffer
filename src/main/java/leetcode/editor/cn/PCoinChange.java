// 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
// 你可以认为每种硬币的数量是无限的。
//
//
//
// 示例 1：
//
//
// 输入：coins = [1, 2, 5], amount = 11
// 输出：3
// 解释：11 = 5 + 5 + 1
//
// 示例 2：
//
//
// 输入：coins = [2], amount = 3
// 输出：-1
//
// 示例 3：
//
//
// 输入：coins = [1], amount = 0
// 输出：0
//
//
// 示例 4：
//
//
// 输入：coins = [1], amount = 1
// 输出：1
//
//
// 示例 5：
//
//
// 输入：coins = [1], amount = 2
// 输出：2
//
//
//
//
// 提示：
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
//
// Related Topics 动态规划

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

// Java：零钱兑换 : 322
public class PCoinChange {
  public static void main(String[] args) {
    Solution solution = new PCoinChange().new Solution();
    final int i = solution.coinChange(new int[] {1, 2, 5}, 11);
    System.out.println("i = " + i);
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int coinChange(int[] coins, int amount) {
      if (amount == 0) return 0;
      //      f(n): 数量；n:金额
      // f(n) = [f(n-X0),...,f(n-Xn)]min
      final int[] f = new int[amount + 1];
      f[0] = 0;
      for (int i = 1; i < f.length; i++) {
        f[i] = Integer.MAX_VALUE;
        for (int j = 0; j < coins.length; j++)
          /** 处理 金额比面值小得情况 和 f[i - coins[j]] == Integer.MAX_VALUE 时，+1 会溢出的问题 */
          if (i >= coins[j] && f[i - coins[j]] != Integer.MAX_VALUE)
            f[i] = Math.min(f[i], f[i - coins[j]] + 1);
      }
      return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
