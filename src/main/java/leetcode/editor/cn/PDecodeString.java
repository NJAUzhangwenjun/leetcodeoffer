/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Java：字符串解码 : 394
 *
 * <p>给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * <p>编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * <p>你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * <p>此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * <p>示例 1：
 *
 * <p>输入：s = "3[a]2[bc]" 输出："aaabcbc"
 *
 * <p>示例 2：
 *
 * <p>输入：s = "3[a2[c]]" 输出："accaccacc"
 *
 * <p>示例 3：
 *
 * <p>输入：s = "2[abc]3[cd]ef" 输出："abcabccdcdcdef"
 *
 * <p>示例 4：
 *
 * <p>输入：s = "abc3[cd]xyz" 输出："abccdcdcdxyz"
 *
 * <p>Related Topics 栈 深度优先搜索
 */
public class PDecodeString {
  public static void main(String[] args) {
    Solution solution = new PDecodeString().new Solution();
    // TO TEST
    String s = solution.decodeString("2[abc]3[cd]ef");
    System.out.println("s = " + s);
  }
  // 字符串解码 : 394

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String decodeString(String s) {
      Deque<Integer> num = new ArrayDeque<>();
      Deque<String> str = new ArrayDeque<>();
      int n = 0;
      StringBuilder st = new StringBuilder();
      for (int i = 0; i < s.length(); i++) {
        if (Character.isDigit(s.charAt(i))) n = n * 10 + (s.charAt(i) - '0');
        else if (s.charAt(i) == '[') {
          num.push(n);
          str.push(st.toString());
          n = 0;
          st = new StringBuilder();
        } else if (Character.isLetter(s.charAt(i))) st.append(s.charAt(i));
        else { // }
          Integer count = num.pop();
          String cur = st.toString();
          while (count-- > 1) st.append(cur);
          st = new StringBuilder(str.pop() + st.toString());
        }
      }
      return st.toString();
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
