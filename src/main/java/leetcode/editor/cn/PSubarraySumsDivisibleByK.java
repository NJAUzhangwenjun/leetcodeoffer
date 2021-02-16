// 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
//
//
//
// 示例：
//
// 输入：A = [4,5,0,-2,-3,1], K = 5
// 输出：7
// 解释：
// 有 7 个子数组满足其元素之和可被 K = 5 整除：
// [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 30000
// -10000 <= A[i] <= 10000
// 2 <= K <= 10000
//
// Related Topics 数组 哈希表

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

import java.util.HashMap;

// Java：和可被 K 整除的子数组 : 974
public class PSubarraySumsDivisibleByK {
  public static void main(String[] args) {
    Solution solution = new PSubarraySumsDivisibleByK().new Solution();
    final int i = solution.subarraysDivByK(new int[] {4, 5, 0, -2, -3, 1}, 5);
    System.out.println("i = " + i);
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int subarraysDivByK(int[] A, int K) {
      final HashMap<Integer, Integer> map = new HashMap<>();
      int count = 0;
      int sum = 0;
      map.put(0, 1);
      for (int i = 0; i < A.length; i++) {
        sum += A[i];
        int modulus = (sum % K + K) % K;
        /*同余定理 （a+b）% x = a%x + b%x ;*/
        final Integer c = map.getOrDefault(modulus, 0);
        count += c;
        map.put(modulus, c + 1);
      }
      return count;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
