/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Java：括号生成 : 22
 *
 * <p>数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * <p>示例 1：
 *
 * <p>输入：n = 3 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * <p>示例 2：
 *
 * <p>输入：n = 1 输出：["()"]
 *
 * <p>提示：
 *
 * <p>1 <= n <= 8
 *
 * <p>Related Topics 字符串 回溯算法
 */
public class PGenerateParentheses {
  public static void main(String[] args) {
    Solution solution = new PGenerateParentheses().new Solution();
    List<String> list = solution.generateParenthesis(3);
    java.lang.String s = Arrays.toString(list.toArray(new String[0]));
    System.out.println("s = " + s);
    // TO TEST
  }
  // 括号生成 : 22

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
      if (n <= 0) return list;
      dfs("", 0, 0, n);
      return list;
    }

    private void dfs(String s, int l, int r, int n) {
      if (r == n && l == n) {
        if (!list.contains(s)) list.add(s);
        return;
      }
      if (l < n) dfs(s + "(", l + 1, r, n);
      if (r < l) dfs(s + ")", l, r + 1, n);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
