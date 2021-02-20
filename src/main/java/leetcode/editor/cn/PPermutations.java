//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法


/**
 * @author 张文军
 * @Company:南京农业大学
 * @version:1.0
 */

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Java：全排列 : 46
public class PPermutations{
    public static void main(String[] args) {
        Solution solution = new PPermutations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
      if (nums == null) {
        return Collections.emptyList();
      }
      dfs(nums,new ArrayList<Integer>());
      return lists;
    }

      private void dfs(int[] nums, List<Integer> list) {
      if (list.size() >= nums.length) {
        lists.add(new ArrayList<>(list));
        return;
      }

      for (int j = 0; j < nums.length; j++) {
        if (nums[j]!=Integer.MAX_VALUE) {
          int num = nums[j];
          nums[j] = Integer.MAX_VALUE;
          list.add(num);
          dfs(nums, list);
          list.remove(list.size() - 1);
          nums[j] = num;
        }
      }
      }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
