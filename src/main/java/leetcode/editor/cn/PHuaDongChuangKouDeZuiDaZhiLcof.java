// 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
//
// 示例:
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
// 输出: [3,3,5,5,6,7]
// 解释:
//
//  滑动窗口的位置                最大值
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// 提示：
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
// Related Topics 队列 Sliding Window

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

import java.util.*;

// Java：滑动窗口的最大值 : 剑指 Offer 59 - I
public class PHuaDongChuangKouDeZuiDaZhiLcof {
  public static void main(String[] args) {
    Solution solution = new PHuaDongChuangKouDeZuiDaZhiLcof().new Solution();
    // TO TEST
    System.out.println(solution.maxSlidingWindow(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 3));
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    private List<Integer> list = new ArrayList<>();
    private LinkedList<Integer> linkedList = new LinkedList<>();
    private Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1-o2;
      }
    });

    public int[] maxSlidingWindow(int[] nums, int k) {
      if (nums.length<1|| k>nums.length) return new int[]{};
      for (int i = 0; i < nums.length; i++) {
        if (i < k) {
          linkedList.push(nums[i]);
          queue.add(nums[i]);
        } else {

          list.add(queue.poll());
          linkedList.add(nums[i]);
          queue.remove(linkedList.remove(0));
          queue.add(nums[i]);
          list.add(queue.poll());
        }
      }
      final int[] ret = new int[list.size()];
      for (int i = 0; i < ret.length; i++) {
        ret[i] = list.get(i);
      }

      return ret;
    }

  }
  // leetcode submit region end(Prohibit modification and deletion)

}
