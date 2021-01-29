//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics 位运算 数组 回溯算法


/**
 * @author 张文军
 * @Company:南京农业大学
 * @version:1.0
 */

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：子集
public class PSubsets{
    public static void main(String[] args) {
        Solution solution = new PSubsets().new Solution();
        // TO TEST
		List<List<Integer>> subsets = solution.subsets(new int[]{1, 3, 5, 6, 10, 15, 20});
		for (List<Integer> subset : subsets) {
			System.out.println(Arrays.toString(subset.toArray()));
		}
	}


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	private List<List<Integer>> lists = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		if (nums == null || nums.length == 0) {
			return lists;
		}
		dfs(nums, new ArrayList<Integer>(), 0);
		return lists;
	}

	/**
	 * 每一个数字 都有两种可能：加入子集合，不加如子集合
	 * @param nums 父集合
	 * @param list 子集合
	 * @param k 第k 个数子数组坐标
	 */
	private void dfs(int[] nums, ArrayList<Integer> list, int k) {
		if (k >= nums.length) {
			lists.add(new ArrayList<>(list));
			return;
		}
		//每个数字有两种可能: 被加入 和 不被加入
		list.add(nums[k]);
		dfs(nums, list, k + 1);
		list.remove(list.size() - 1);
		dfs(nums, list, k + 1);

	}
}

//leetcode submit region end(Prohibit modification and deletion)

}
