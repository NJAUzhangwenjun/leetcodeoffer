// 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
// 复的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例 1：
//
//
// 输入：nums = [-1,0,1,2,-1,-4]
// 输出：[[-1,-1,2],[-1,0,1]]
//
//
// 示例 2：
//
//
// 输入：nums = []
// 输出：[]
//
//
// 示例 3：
//
//
// 输入：nums = [0]
// 输出：[]
//
//
//
//
// 提示：
//
//
// 0 <= nums.length <= 3000
// -105 <= nums[i] <= 105
//
// Related Topics 数组 双指针

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

import java.util.*;

// Java：三数之和 : 15
public class PThreeSum {
  public static void main(String[] args) {
    Solution solution = new PThreeSum().new Solution();
    // TO TEST
    final List<List<Integer>> lists = solution.threeSum(new int[] {1, -1, -1, 0});
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
      if (nums == null || nums.length == 0) return lists;

      Arrays.sort(nums);

      for (int i = 0; i < nums.length; i++) {
        if (i == 0 || nums[i] != nums[i - 1]) {
          int start = i + 1, end = nums.length - 1;
          while (start < end) {
            final int sum = nums[i] + nums[start] + nums[end];
            if (sum == 0) {
              lists.add(Arrays.asList(nums[i], nums[start], nums[end]));
              start++;
              end--;
              while (start < end && nums[start] == nums[start - 1]) start++;
              while (start < end && nums[end] == nums[end + 1]) end--;
            } else if (sum > 0) {
              end--;
            } else {
              start++;
            }
          }
        }
      }

      return lists;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
