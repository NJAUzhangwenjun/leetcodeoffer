// 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
// 问总共有多少条不同的路径？
//
//
//
// 示例 1：
//
//
// 输入：m = 3, n = 7
// 输出：28
//
// 示例 2：
//
//
// 输入：m = 3, n = 2
// 输出：3
// 解释：
// 从左上角开始，总共有 3 条路径可以到达右下角。
// 1. 向右 -> 向下 -> 向下
// 2. 向下 -> 向下 -> 向右
// 3. 向下 -> 向右 -> 向下
//
//
// 示例 3：
//
//
// 输入：m = 7, n = 3
// 输出：28
//
//
// 示例 4：
//
//
// 输入：m = 3, n = 3
// 输出：6
//
//
//
// 提示：
//
//
// 1 <= m, n <= 100
// 题目数据保证答案小于等于 2 * 109
//
// Related Topics 数组 动态规划

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

// Java：不同路径 : 62
public class PUniquePaths {
  public static void main(String[] args) {
    Solution solution = new PUniquePaths().new Solution();
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int uniquePaths(int m, int n) {
      //      f(x, y) = f(x - 1, y) + f(x, y - 1);
      if (m <= 0 || n <= 0) return 0;
      return dp(new int[m][n], 0, m, n);
    }

    private int dp(int[][] ints, int pathNum, int x, int y) {
      if (x < 0 || y < 0) return pathNum;
      ints[x][y] = -1;
      /*上->*/
      int right = 0;
      if (x - 1 >= 0 && y >= ints[0].length) {
        right = dp(ints, pathNum+1, x - 1, y);
      }
      int down = 0;
      if (x >= 0 && y - 1 >= ints[0].length) {
        down = dp(ints, pathNum+1, x, y - 1);
      }
      return right + down;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
