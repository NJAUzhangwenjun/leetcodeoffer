//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
//
//
//
// 说明：
//
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
//
//
//
//
// 示例：
//
//
//输入：
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出：[1,2,2,3,5,6]
//
//
//
// 提示：
//
//
// -10^9 <= nums1[i], nums2[i] <= 10^9
// nums1.length == m + n
// nums2.length == n
//
// Related Topics 数组 双指针


/**
 * @author 张文军
 * @Company:南京农业大学
 * @version:1.0
 */

package leetcode.editor.cn;

//Java：合并两个有序数组
public class PMergeSortedArray {
	public static void main(String[] args) {
		Solution solution = new PMergeSortedArray().new Solution();
		// TO TEST
	}


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public void merge(int[] nums1, int m, int[] nums2, int n) {
			//题目说nums1 有足够的空间（nums1.length == m + n）来保存 nums2 中的元素，相当于自带了一个空数组
			int l = m - 1;//第一个元素元素指针
			int r = n - 1;//第二个数组元素指针
			int i = m + n - 1;
			while (r >= 0 && l >= 0) {
				if (nums1[l] >= nums2[r]) {
					nums1[i] = nums1[l--];
				} else {
					nums1[i] = nums2[r--];
				}
				i--;
			}
			while (r >= 0) {
				nums1[i--] = nums2[r--];
			}
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}
