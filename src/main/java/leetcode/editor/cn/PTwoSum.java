/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

// Java：两数之和 : 1

import java.util.HashMap;

public class PTwoSum {
  public static void main(String[] args) {
    Solution solution = new PTwoSum().new Solution();
    // TO TEST
  }

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> map = new HashMap<>(nums.length);
      for (int i = 0; i < nums.length; i++) {
          int num = nums[i];
          int s = target - num;
          if (map.containsKey(s)) {
              return new int[] { map.get(s),i};
          } else {
              map.put(num, i);
          }
      }

      return new int[] {};
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
