// 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
// 二叉树：[3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层序遍历结果：
//
//
// [
//  [3],
//  [9,20],
//  [15,7]
// ]
//
// Related Topics 树 广度优先搜索

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

import leetcode.editor.utils.TreeNode;

import java.util.*;

// Java：二叉树的层序遍历 : 102
public class PBinaryTreeLevelOrderTraversal {
  public static void main(String[] args) {
    Solution solution = new PBinaryTreeLevelOrderTraversal().new Solution();
    // TO TEST
  }
  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
      return bfs(root);
    }

    private List<List<Integer>> bfs(TreeNode root) {
      List<List<Integer>> lists = new ArrayList<>();
      if (root == null) return lists;

      final Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        List<Integer> list = new ArrayList<>();
        while (size-- > 0) {
          final TreeNode cur = queue.poll();
          list.add(cur.val);
          if (cur.left != null) queue.add(cur.left);
          if (cur.right != null) queue.add(cur.right);
        }
        lists.add(list);
      }
      return lists;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
