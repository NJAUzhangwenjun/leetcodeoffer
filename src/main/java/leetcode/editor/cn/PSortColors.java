//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
// 并按照红色、白色、蓝色顺序排列。
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
// 注意:
//不能使用代码库中的排序函数来解决这道题。
//
// 示例:
//
// 输入: [2,0,2,1,1,0]
//输出: [0,0,1,1,2,2]
//
// 进阶：
//
//
// 一个直观的解决方案是使用计数排序的两趟扫描算法。
// 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
// 你能想出一个仅使用常数空间的一趟扫描算法吗？
//
// Related Topics 排序 数组 双指针


/**
 * @author 张文军
 * @Company:南京农业大学
 * @version:1.0
 */

package leetcode.editor.cn;

import java.util.Arrays;


/**
 * 颜色分类
 */
public class PSortColors {
	public static void main(String[] args) {
		Solution solution = new PSortColors().new Solution();
		// TO TEST
		int[] ints = {2, 0, 2, 1, 1, 0};
		int[] s = Arrays.copyOf(ints, ints.length);
		System.out.println(Arrays.toString(ints));
		solution.sortColors(ints);
		System.out.println(Arrays.toString(ints));
		System.out.println(Arrays.toString(new int[]{0, 0, 1, 1, 2, 2}));
	}


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public void sortColors(int[] nums) {
			/**
			 * [0,left)存放0
			 */
			int left = 0;
			/**
			 * (right,nums.length]存放2
			 */
			int right = nums.length - 1;
			for (int i = 0; i <= right; ) {
				//首先判断当前元素是否为2，如果是
				//就将当前元素交换到末尾
				if (nums[i] == 2) {
					swap(nums, i, right--);
				}

				/**
				 * 接下来的操作就类似于 “移动零”操作;只不过是将0移动到前面
				 * 	将0移动到前面，将1移动到后面
				 * 	 即：当前元素是 1 的时候向前移动
				 * 	 	当前元素是 0 的时候，将当前元素
				 */
				if (nums[i] == 1) {
					i++;
				} else if (nums[i] == 0) {
					swap(nums, left++, i++);
				}
			}
		}

		private void swap(int[] nums, int i, int j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}
