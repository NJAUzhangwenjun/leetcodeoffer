// 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整
// 个棋盘的那两条对角线。
//
// 注意：本题相对原题做了扩展
//
// 示例:
//
//  输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
// [
//  [".Q..",  // 解法 1
//   "...Q",
//   "Q...",
//   "..Q."],
//
//  ["..Q.",  // 解法 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]
//
// Related Topics 回溯算法

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// Java：八皇后 : 面试题 08.12
public class PEightQueensLcci {
  public static void main(String[] args) {
    Solution solution = new PEightQueensLcci().new Solution();
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public List<List<String>> solveNQueens(int n) {
      List<List<String>> lists = new ArrayList<>();
      if (n <= 0) {
        return lists;
      }
      //        TODO
      return null;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
