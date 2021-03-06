// 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 示例:
//
// 输入: [1,2,3,null,5,null,4]
// 输出: [1, 3, 4]
// 解释:
//
//   1            <---
// /   \
// 2     3         <---
// \     \
//  5     4       <---
//
// Related Topics 树 深度优先搜索 广度优先搜索 递归 队列

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

import leetcode.editor.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Java：二叉树的右视图 : 199
public class PBinaryTreeRightSideView {
  public static void main(String[] args) {
    Solution solution = new PBinaryTreeRightSideView().new Solution();
    // TO TEST
  }
  // 二叉树的右视图 : 199

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
   * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
   */
  class Solution {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
      if (root == null) return list;

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int size = queue.size();
        while (size-- > 0) {
          TreeNode cur = queue.poll();
          if (size == 0) list.add(cur.val);
          if (cur.left != null) queue.add(cur.left);
          if (cur.right != null) queue.add(cur.right);
        }
      }
      return list;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
