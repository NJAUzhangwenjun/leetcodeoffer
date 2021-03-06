// 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
//
// 此外，你可以假设该网格的四条边均被水包围。
//
//
//
// 示例 1：
//
//
// 输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
// ]
// 输出：1
//
//
// 示例 2：
//
//
// 输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
// ]
// 输出：3
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] 的值为 '0' 或 '1'
//
// Related Topics 深度优先搜索 广度优先搜索 并查集

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

// Java：岛屿数量 : 200
public class PNumberOfIslands {
  public static void main(String[] args) {
    Solution solution = new PNumberOfIslands().new Solution();
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int numIslands(char[][] grid) {
      if (grid == null || grid.length == 0) {
        return 0;
      }
      int count = 0;
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          if (grid[i][j] == '1') {
            dfs(grid, i, j);
            count++;
          }
        }
      }
      return count;
    }

    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    private void dfs(char[][] grid, int i, int j) {
      if (
              i < 0 || i >= grid.length ||
              j < 0 || j >= grid[0].length ||
              grid[i][j] != '1'
      ) return;
      grid[i][j] = 'x';
      for (int k = 0; k < 4; k++) {
        dfs(grid,i+dx[k],j+dy[k]);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
