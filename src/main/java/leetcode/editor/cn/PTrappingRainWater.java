// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//
//
//
// 示例 1：
//
//
//
//
// 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
// 输出：6
// 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//
//
// 示例 2：
//
//
// 输入：height = [4,2,0,3,2,5]
// 输出：9
//
//
//
//
// 提示：
//
//
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
//
// Related Topics 栈 数组 双指针 动态规划

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

// Java：接雨水 : 42
public class PTrappingRainWater {
  public static void main(String[] args) {
    Solution solution = new PTrappingRainWater().new Solution();
    final int trap = solution.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    System.out.println("trap = " + trap);
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int trap(int[] height) {
      int ans = 0, current = 0;
      Deque<Integer> stack = new LinkedList<Integer>();
      while (current < height.length) {
        while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
          int top = stack.pop();
          if (stack.isEmpty())
            break;
          int distance = current - stack.peek() - 1;
          int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
          ans += distance * bounded_height;
//          ans += Math.min(stack.getFirst(),height[current])-top;
        }
        stack.push(current++);
      }
      return ans;
    }
//    public int trap(int[] height) {
//      int rainwater = 0;
//      if (height == null || height.length <= 2) {
//        return 0;
//      }
//
//      Stack<Integer> stack = new Stack<>();
//      int min = height[0];
//      for (int i = 0; i < height.length; i++) {
//        if (min < height[i]) {
//          min = height[i];
//          continue;
//        }
//        stack.push(min);
//        break;
//      }
//      for (int i = 1; i < height.length; i++) {
//        if (stack.peek() > height[i]) {
//          stack.push(height[i]);
//          continue;
//        }
//        while (stack.peek() < height[i]) {
//          Integer top = stack.pop();
//          if (stack.size()<=0) break;
//          rainwater += Math.min(stack.get(0), height[i]) - top;
//        }
//      }
////      int leftMax = height[0];
////      final int[] left = new int[height.length];
////      for (int i = 0; i < height.length; i++) {
////        if (leftMax < height[i]) {
////          leftMax = height[i];
////        }
////        left[i] = leftMax;
////      }
////      int rightMax = height[height.length-1];
////      final int[] right = new int[height.length];
////      for (int i = height.length-1; i >=0; i--) {
////        if (rightMax < height[i]) {
////          rightMax = height[i];
////        }
////        right[i] = rightMax;
////      }
////
////      for (int i = 0; i < height.length; i++) {
////        rainwater+=Math.min(left[i],right[i])-height[i];
////      }
//
////      /*计算中轴（最大）*/
////      int maximumAxisIndex = 0;
////      for (int i = 1; i < height.length; i++) {
////        if (height[maximumAxisIndex] < height[i]) {
////          maximumAxisIndex = i;
////        }
////      }
////      int left = 0, right = height.length - 1;
////      /*判断最大值左边 大于右边高度*/
////      int curLeftMax = height[left];
////      while (left + 1 < maximumAxisIndex) {
////        if (curLeftMax > height[left + 1]) {
////          rainwater += (curLeftMax - height[left + 1]);
////        } else {
////          curLeftMax = height[++left];
////          continue;
////        }
////        left++;
////      }
////      /*判断最大值右边 小于右边高度*/
////      int curRightMax = height[right];
////      while (right - 1 > maximumAxisIndex) {
////        if (curRightMax > height[right - 1]) {
////          rainwater += (curRightMax - height[right - 1]);
////        } else {
////          curRightMax = height[--right];
////          continue;
////        }
////        right--;
////      }
//      return rainwater;
//    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
