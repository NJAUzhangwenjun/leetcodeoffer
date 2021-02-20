// 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!
// =b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
//
// 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
//
//
//
//
//
//
// 示例 1：
//
// 输入：["a==b","b!=a"]
// 输出：false
// 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
//
//
// 示例 2：
//
// 输入：["b==a","a==b"]
// 输出：true
// 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
//
//
// 示例 3：
//
// 输入：["a==b","b==c","a==c"]
// 输出：true
//
//
// 示例 4：
//
// 输入：["a==b","b!=c","c==a"]
// 输出：false
//
//
// 示例 5：
//
// 输入：["c==c","b==d","x!=z"]
// 输出：true
//
//
//
//
// 提示：
//
//
// 1 <= equations.length <= 500
// equations[i].length == 4
// equations[i][0] 和 equations[i][3] 是小写字母
// equations[i][1] 要么是 '='，要么是 '!'
// equations[i][2] 是 '='
//
// Related Topics 并查集 图

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

// Java：等式方程的可满足性 : 990
public class PSatisfiabilityOfEqualityEquations {
  public static void main(String[] args) {
    Solution solution = new PSatisfiabilityOfEqualityEquations().new Solution();
    final boolean b =
        solution.equationsPossible(new String[] {"f==a", "a==b", "f!=e", "a==c", "b==e", "c==f"});
    System.out.println("b = " + b);
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean equationsPossible(String[] equations) {
      final UnionFind uf = new UnionFind(26);
      for (int i = 0; i < equations.length; i++) {
        /*["a==b","b!=a"]*/
        String equation = equations[i];
        if (equation.charAt(1) == '=') {
          uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
        }
      }
      for (int i = 0; i < equations.length; i++) {
        String equation = equations[i];
        if (equation.charAt(1) != '=') {
          if (uf.isUnion(equation.charAt(0) - 'a', equation.charAt(3) - 'a')) return false;
        }
      }
      return true;
    }

    /** 并查集 */
    /** 并查集 */
    private class UnionFind {
      private int[] parent;

      public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
      }

      /**
       * 连接两个元素
       *
       * @param p index
       * @param q index
       */
      void union(int p, int q) {
        if (parent[p] == parent[q]) return;
        for (int i = 0; i < parent.length; i++)
          // 可先不改变p，在遍历完后再改变
          if (i != p && parent[i] == parent[p]) parent[i] = parent[q];
        parent[p] = parent[q];
      }

      /**
       * 判断 是否相连
       *
       * @param p index
       * @param q index
       * @return
       */
      Boolean isUnion(int p, int q) {
        return parent[p] == parent[q];
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
