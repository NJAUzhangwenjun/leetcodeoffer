// 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
//
//
// 提示：
//
//
// num1 和num2 的长度都小于 5100
// num1 和num2 都只包含数字 0-9
// num1 和num2 都不包含任何前导零
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
//
// Related Topics 字符串

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

// Java：字符串相加 : 415
public class PAddStrings {
  public static void main(String[] args) {
    Solution solution = new PAddStrings().new Solution();
    final String s = solution.addStrings("123", "123");
    System.out.println("s = " + s);
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String addStrings(String num1, String num2) {
      int i = num1.length() - 1, j = num2.length() - 1, add = 0;
      StringBuffer ans = new StringBuffer();
      while (i >= 0 || j >= 0 || add != 0) {
        int x = i >= 0 ? num1.charAt(i) - '0' : 0;
        int y = j >= 0 ? num2.charAt(j) - '0' : 0;
        int result = x + y + add;
        ans.append(result % 10);
        add = result / 10;
        i--;
        j--;
      }
      // 计算完以后的答案需要翻转过来
      ans.reverse();
      return ans.toString();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
