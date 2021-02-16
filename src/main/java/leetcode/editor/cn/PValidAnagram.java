// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
// 输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
// 输出: false
//
// 说明:
// 你可以假设字符串只包含小写字母。
//
// 进阶:
// 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

import java.util.Arrays;

// Java：有效的字母异位词 : 242
public class PValidAnagram {
  public static void main(String[] args) {
    Solution solution = new PValidAnagram().new Solution();
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean isAnagram(String s, String t) {
      final char[] ss = s.toCharArray();
      final char[] tt = t.toCharArray();
      Arrays.sort(ss);
      Arrays.sort(tt);
      final String s1 = new String(ss);
      final String t1 = new String(tt);
      return s1.equals(t1);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
