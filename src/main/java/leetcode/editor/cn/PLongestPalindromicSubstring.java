// 给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
// 输入：s = "babad"
// 输出："bab"
// 解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
// 输入：s = "cbbd"
// 输出："bb"
//
//
// 示例 3：
//
//
// 输入：s = "a"
// 输出："a"
//
//
// 示例 4：
//
//
// 输入：s = "ac"
// 输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

// Java：最长回文子串 : 5
public class PLongestPalindromicSubstring {
  public static void main(String[] args) {
    Solution solution = new PLongestPalindromicSubstring().new Solution();
    final String aba = solution.longestPalindrome("cbbd");
    System.out.println("abba = " + aba);
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public String longestPalindrome(String s) {
      if (s.length() < 2) return s;
      int maxLength = 1;
      int startIndex = 0;
      final char[] chars = s.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        int x = getMaxLength(chars, i, i); /*奇数*/
        int y = getMaxLength(chars, i, i + 1); /*偶数*/
        int max = Math.max(x, y);
        if (maxLength < max) {
          maxLength = max;
          if (x < y) startIndex = i - maxLength / 2 + 1;
          else startIndex = i - (max - 1) / 2;
        }
      }
      return s.substring(startIndex, startIndex + maxLength);
    }

    private int getMaxLength(char[] chars, int left, int right) {
      int ret = 0;
      while (left >= 0 && right < chars.length) {
        if (chars[left] == chars[right]) {
          if (left-- == right++) ret++;
          else ret += 2;
        } else break;
      }
      return ret;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
