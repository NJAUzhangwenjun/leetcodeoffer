//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针


/**
 * @author 张文军
 * @Company:南京农业大学
 * @version:1.0
 */

package leetcode.editor.cn;

import java.util.Arrays;

//Java：移动零
public class PMoveZeroes {
	public static void main(String[] args) {
		Solution solution = new PMoveZeroes().new Solution();
		// TO TEST
		int[] ints = {0, 1, 0, 3, 12};
		System.out.println("ints = " + Arrays.toString(ints));
		solution.moveZeroes(ints);
		System.out.println("ints = " + Arrays.toString(ints));
	}


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public void moveZeroes(int[] nums) {
			/**
			 * 存放非零元素的前驱指针，
			 * 	即：
			 * 		在[0,pre)前闭后开区间存放的都是非零元素
			 * 		在[pre,...]前闭后开区间存放的都是零元素
			 */
			int pre = 0;
			/**
			 * 移动指针
			 */
			int cur = 0;
			while (cur < nums.length) {
				if (nums[cur] != 0) {
					if (pre != cur)//只有指针不相等的时候才进行交换，要不然每次相同位置也都进行交换
						//元素交换
						LeetCodeUtils.swap(nums, pre, cur);
					pre++;
				}
				cur++;
			}
		}

	}
	//leetcode submit region end(Prohibit modification and deletion)

}
