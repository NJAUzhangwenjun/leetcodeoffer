// 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
// 外其余各元素的乘积。
//
//
//
// 示例:
//
// 输入: [1,2,3,4]
// 输出: [24,12,8,6]
//
//
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
//
// 进阶：
// 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
// Related Topics 数组

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

import java.util.Arrays;

// Java：除自身以外数组的乘积 : 238
public class PProductOfArrayExceptSelf {
  public static void main(String[] args) {
    Solution solution = new PProductOfArrayExceptSelf().new Solution();
    final int[] ints = solution.productExceptSelf(new int[]{1, 2, 3, 4});
    System.out.println("(ints) = " + Arrays.toString(ints));
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] productExceptSelf(int[] nums) {
      /*前缀*/
      final int[] l = new int[nums.length];
      /*后缀*/
      final int[] r = new int[nums.length];
      for (int i = 0; i < l.length; i++) {
        if (i == 0) l[i] = 1;
        else l[i] =l[i-1]*nums[i-1];
      }for (int i = r.length-1; i>=0 ; i--) {
        if (i == r.length-1) r[i] = 1;
        else r[i]  =r[i+1]*nums[i+1];
      }
      for (int i = 0; i < nums.length; i++) {
        l[i] = l[i]*r[i];
      }
      return l;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
