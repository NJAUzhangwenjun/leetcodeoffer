// 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
// 回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//
//
// 示例 1：
//
//
// 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
// 输出：[[1,6],[8,10],[15,18]]
// 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//
//
// 输入：intervals = [[1,4],[4,5]]
// 输出：[[1,5]]
// 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
//
// Related Topics 排序 数组

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// Java：合并区间 : 56
public class PMergeIntervals {
  public static void main(String[] args) {
    Solution solution = new PMergeIntervals().new Solution();
    // TO TEST
  }
  // 合并区间 : 56

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[][] merge(int[][] intervals) {
      if (intervals == null || intervals.length == 0) {
        return new int[][] {};
      }
      Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
      ArrayList<int[]> list = new ArrayList<>();
      for (int i = 0; i < intervals.length; i++) {
        int[] interval = intervals[i];
        if (list.size() == 0 || list.get(list.size()-1)[1] < interval[0]) {
          list.add(interval);
        } else {
          list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], interval[1]);
        }
      }
      return list.toArray(new int[list.size()][]);
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
