//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 示例 1:
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
// 说明:
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
// Related Topics 堆 分治算法


/**
 * @author 张文军
 * @Company:南京农业大学
 * @version:1.0
 */

package leetcode.editor.cn;

import java.util.PriorityQueue;

//Java：数组中的第K个最大元素
public class PKthLargestElementInAnArray {
	public static void main(String[] args) {
		Solution solution = new PKthLargestElementInAnArray().new Solution();
		// TO TEST
		int[] ints = {3, 2, 3, 1, 2, 4, 5, 5, 6};
		int i = solution.findKthLargest(ints, 4);
		System.out.println("i = " + i);
	}


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int findKthLargest(int[] nums, int k) {
			PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
			for (int num : nums) {
				if (heap.size() < k)
					heap.add(num);
				else if (heap.peek() < num) {
					heap.poll();
					heap.add(num);
				}
			}
			return heap.peek();
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}
