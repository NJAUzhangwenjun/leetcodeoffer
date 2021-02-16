// 给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
// 输出：[2,2]
//
//
// 示例 2:
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// 输出：[4,9]
//
//
//
// 说明：
//
//
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
// 我们可以不考虑输出结果的顺序。
//
//
// 进阶：
//
//
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//
// Related Topics 排序 哈希表 双指针 二分查找

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;

// Java：两个数组的交集 II : 350
public class PIntersectionOfTwoArraysIi {
  public static void main(String[] args) {
    Solution solution = new PIntersectionOfTwoArraysIi().new Solution();
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      final HashMap<Integer, Integer> map = new HashMap<>();
      final ArrayList<Integer> list = new ArrayList<>();
      for (int i = 0; i < nums1.length; i++) {
        if (map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
        else map.put(nums1[i], 1);
      }
      for (int i = 0; i < nums2.length; i++) {
        if (map.containsKey(nums2[i])) {
          if (map.get(nums2[i]) > 1) {
            map.put(nums2[i], map.get(nums2[i]) - 1);
          } else map.remove(nums2[i]);
          list.add(nums2[i]);
        }
      }
      final int[] ints = new int[list.size()];
      for (int i = 0; i < ints.length; i++) {
        ints[i] = list.get(i);
      }
      return ints;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
