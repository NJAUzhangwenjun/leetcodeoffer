/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

// Java：无重复字符的最长子串 : 3

import java.util.ArrayList;
import java.util.Objects;

public class PLongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    Solution solution = new PLongestSubstringWithoutRepeatingCharacters().new Solution();
    // TO TEST
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int lengthOfLongestSubstring(String s) {
      if (Objects.isNull(s)) {
        return 0;
      }
      ArrayList<Character> arr = new ArrayList<>();
      int ret = 0;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (arr.contains(c)) {
          while (arr.contains(c)) {
            arr.remove(0);
          }
        }
        arr.add(c);
        ret = Math.max(ret, arr.size());
      }
      return ret;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
