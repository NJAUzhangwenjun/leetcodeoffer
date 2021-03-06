/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

// Java：二叉树的最近公共祖先 : 236

// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
// 一个节点也可以是它自己的祖先）。”
//
//
//
// 示例 1：
//
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// 输出：3
// 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
//
//
// 示例 2：
//
//
// 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// 输出：5
// 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
//
//
// 示例 3：
//
//
// 输入：root = [1,2], p = 1, q = 2
// 输出：1
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [2, 105] 内。
// -109 <= Node.val <= 109
// 所有 Node.val 互不相同 。
// p != q
// p 和 q 均存在于给定的二叉树中。
//
// Related Topics 树

import leetcode.editor.utils.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PLowestCommonAncestorOfABinaryTree {
  public static void main(String[] args) {
//    Solution solution = new PLowestCommonAncestorOfABinaryTree().new Solution();
    // TO TEST
  }
  // 二叉树的最近公共祖先 : 236

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
    /*class Solution {
      public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> lp = new ArrayList<>();
        ArrayList<TreeNode> path = new ArrayList<>();
        ArrayList<TreeNode> lq = new ArrayList<>();
        dfs(root, p, q, path, lp, lq);
        int size = Math.min(lp.size(), lq.size());
        TreeNode res = null;
        for (int j = 0; j < size; j++) if (lp.get(j).equals(lq.get(j))) res = lp.get(j);
        return res;
      }

      private void dfs(
          TreeNode root,
          TreeNode p,
          TreeNode q,
          ArrayList<TreeNode> path,
          ArrayList<TreeNode> lp,
          ArrayList<TreeNode> lq) {
        if (root == null) return;
        path.add(root);
        if (root.equals(p)) {
          lp.addAll(path);
        }
        if (root.equals(q)) {
          lq.addAll(path);
        }
        dfs(root.left, p, q, path, lp, lq);
        dfs(root.right, p, q, path, lp, lq);
        path.remove(path.size() - 1);
      }
    }*/
  class Solution {
    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public void dfs(TreeNode root) {
      if (root.left != null) {
        parent.put(root.left.val, root);
        dfs(root.left);
      }
      if (root.right != null) {
        parent.put(root.right.val, root);
        dfs(root.right);
      }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      dfs(root);
      while (p != null) {
        visited.add(p.val);
        p = parent.get(p.val);
      }
      while (q != null) {
        if (visited.contains(q.val)) return q;
        q = parent.get(q.val);
      }
      return null;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)


}
