package leetcode.editor.mode.backtracking;

/**
 * @author 张文军 @Description: 回溯算法 @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/2/178:45
 */
public class BacktrackingAlgorithm {

  public static void main(String[] args) {
    final BacktrackingAlgorithm backtrackingAlgorithm = new BacktrackingAlgorithm();
    final int i = backtrackingAlgorithm.backPack(10, new int[]{3, 4, 8, 5});
    System.out.println("i = " + i);
  }
  /*模板 DFS (深度优先遍历)的变形*/
  /**
   * function backtrace(已选解集合,每个阶段可选解) { if (已选解集合满足条件) { 结果集.add(已选解集合); return; }
   *
   * <p>// 遍历每个阶段的可选解集合 for (可选解 in 每个阶段的可选解) {
   *
   * <p>// 选择此阶段其中一个解,将其加入到已选解集合中 已选解集合.add(可选解)
   *
   * <p>// 进入下一个阶段 backtrace(已选解集合,下个阶段可选的空间解)
   *
   * <p>// 「回溯」换个解再遍历 已选解集合.remove(可选解)

   *
   * <p>} }
   */

  /** 排列问题 */
  /** 背包问题 */
  /**
   * 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
   *
   * <p>样例 样例 1: 输入: [3,4,8,5], backpack size=10 输出: 9
   *
   * <p>样例 2: 输入: [2,3,5,7], backpack size=12 输出: 12
   *
   * <p>挑战 O(n x m) 的时间复杂度 and O(m) 空间复杂度 如果不知道如何优化空间O(n x m) 的空间复杂度也可以通过.
   *
   * <p>注意事项 你不可以将物品进行切割。
   *
   * @param m: An integer m denotes the size of a backpack
   * @param A: Given n items with size A[i]
   * @return: The maximum size
   */


  private int ret = 0;

  public int backPack(int m, int[] A) {
    // write your code here
    if (m <= 0 || A == null || A.length == 0) return 0;
    dfs(m, A, 0);
    return ret;
  }

  private void dfs(int m, int[] a, int count) {
    if (m >= count) {
      ret = Math.max(count, ret);
      return;
    }
    for (int i = 0; i < a.length; i++) {
      if (a[i] != Integer.MAX_VALUE) {
        final int x = a[i];
        a[i] = Integer.MAX_VALUE;
        dfs(m, a, count + x);
        a[i] = x;
      }
    }
  }
}
