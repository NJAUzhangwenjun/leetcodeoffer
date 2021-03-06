// 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 示例:
//
// board =
// [
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
// ]
//
// 给定 word = "ABCCED", 返回 true
// 给定 word = "SEE", 返回 true
// 给定 word = "ABCB", 返回 false
//
//
//
// 提示：
//
//
// board 和 word 中只包含大写和小写英文字母。
// 1 <= board.length <= 200
// 1 <= board[i].length <= 200
// 1 <= word.length <= 10^3
//
// Related Topics 数组 回溯算法

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

// Java：单词搜索 : 79
public class PWordSearch {
  public static void main(String[] args) {
    Solution solution = new PWordSearch().new Solution();
    boolean see =
        solution.exist(
            new char[][] {
              {'A', 'B', 'C', 'E'},
              {'S', 'F', 'C', 'S'},
              {'A', 'D', 'E', 'E'}
            },
            "SEE");
    // TO TEST
    System.out.println("see = " + see);
  }
  // 单词搜索 : 79

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public boolean exist(char[][] board, String word) {
      for (int i = 0; i < board.length; i++) {
        char[] chars = board[i];
        for (int j = 0; j < chars.length; j++) {
          char aChar = chars[j];
          if (word.charAt(0) == aChar) {
            if (dfs(board, i, j, word, 0)) return true;
          }
        }
      }
      return false;
    }

    private final int[] dx = {1,-1,0,0};
    private final int[] dy = {0,0,1,-1};

    private boolean dfs(char[][] board, int i, int j, String word, int l) {
      if (word.length() - 1 == l) return true;
      if (board[i][j] != word.charAt(l)) return false;

      /*上 下 左 右*/
      char c = board[i][j];
      board[i][j] = '-';
      for (int k = 0; k < 4; k++) {
        int x = dx[k] + i;
        int y = dy[k] + j;
        if (x >= 0
            && x < board.length
            && y >= 0
            && y < board[0].length
            && board[x][y] == word.charAt(l + 1))
          if (dfs(board, x, y, word, l + 1)) return true;
      }
      board[i][j] = c;
      return false;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
