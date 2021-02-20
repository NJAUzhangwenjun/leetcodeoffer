// 有一个二维矩阵 grid ，每个位置要么是陆地（记号为 0 ）要么是水域（记号为 1 ）。
//
// 我们从一块陆地出发，每次可以往上下左右 4 个方向相邻区域走，能走到的所有陆地区域，我们将其称为一座「岛屿」。
//
// 如果一座岛屿 完全 由水域包围，即陆地边缘上下左右所有相邻区域都是水域，那么我们将其称为 「封闭岛屿」。
//
// 请返回封闭岛屿的数目。
//
//
//
// 示例 1：
//
//
//
// 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1
// ,0,1],[1,1,1,1,1,1,1,0]]
// 输出：2
// 解释：
// 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
//
// 示例 2：
//
//
//
// 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
// 输出：1
//
//
// 示例 3：
//
// 输入：grid = [[1,1,1,1,1,1,1],
//              [1,0,0,0,0,0,1],
//              [1,0,1,1,1,0,1],
//              [1,0,1,0,1,0,1],
//              [1,0,1,1,1,0,1],
//              [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
// 输出：2
//
//
//
//
// 提示：
//
//
// 1 <= grid.length, grid[0].length <= 100
// 0 <= grid[i][j] <=1
//
// Related Topics 深度优先搜索

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

// Java：统计封闭岛屿的数目 : 1254
public class PNumberOfClosedIslands {
  public static void main(String[] args) {
    Solution solution = new PNumberOfClosedIslands().new Solution();
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int closedIsland(int[][] grid) {
      if (grid == null || grid.length == 0) {
        return 0;
      }
      int count = 0;
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
          if (grid[i][j] == 0) {
            //            dfs(grid, i, j);
            boolean flag = true;
            for (int k = 0; k < 4; k++) {
              final int x = i + dx[k];
              final int y = j + dy[k];
              if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] != 1)
                flag = false;
            }
            if (flag) {
              count++;
              grid[i][j] = 1;
            }
          }
        }
      }
      return count;
    }

    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {1, -1, 0, 0};

    private void dfs(int[][] grid, int i, int j) {
      if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 0) return;
      grid[i][j] = -1;
      for (int k = 0; k < 4; k++) {
        dfs(grid, i + dx[k], j + dy[k]);
      }
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
