// 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
// 式重构得到原数据。
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
// 反序列化为原始的树结构。
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
// 方法解决这个问题。
//
//
//
// 示例 1：
//
//
// 输入：root = [1,2,3,null,null,4,5]
// 输出：[1,2,3,null,null,4,5]
//
//
// 示例 2：
//
//
// 输入：root = []
// 输出：[]
//
//
// 示例 3：
//
//
// 输入：root = [1]
// 输出：[1]
//
//
// 示例 4：
//
//
// 输入：root = [1,2]
// 输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中结点数在范围 [0, 104] 内
// -1000 <= Node.val <= 1000
//
// Related Topics 树 设计

/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

import leetcode.editor.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Java：二叉树的序列化与反序列化 : 297
public class PSerializeAndDeserializeBinaryTree {
  public static void main(String[] args) {
    //        Solution solution = new PSerializeAndDeserializeBinaryTree().new Solution();
    // TO TEST
    Codec codec = new PSerializeAndDeserializeBinaryTree().new Codec();
    ArrayList<String> strings = new ArrayList<>();
    strings.add("1");
    strings.add("2");
    System.out.println("strings = " + strings.toString());
    String substring = strings.toString().substring(1, strings.toString().length() - 1);
    System.out.println("substring = " + substring);
  }
  // 二叉树的序列化与反序列化 : 297

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
   * right; TreeNode(int x) { val = x; } }
   */
  public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      if (root == null) return "";
      List<String> list = new ArrayList<>();
      dfs(list, root);
      return list.toString().substring(1, list.toString().length() - 1);
    }

    private void dfs(List<String> list, TreeNode root) {
      if (root == null) {
        list.add("null");
        return;
      }
      list.add(String.valueOf(root.val));
      dfs(list, root.left);
      dfs(list, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if (data == null || data.length() == 0) return null;
      String[] d = data.split(",");
      ArrayList<String> list = new ArrayList<>(Arrays.asList(d));
      return deserialize(list);
    }

    private TreeNode deserialize(ArrayList<String> list) {
      if (list.size()==0)return null;
      String remove = list.remove(0);
      if ("null".equals(remove.trim())) return null;
      TreeNode treeNode = new TreeNode(Integer.parseInt(remove.trim()));
      treeNode.left = deserialize(list);
      treeNode.right = deserialize(list);
      return treeNode;
    }
  }

  // Your Codec object will be instantiated and called as such:
  // Codec ser = new Codec();
  // Codec deser = new Codec();
  // TreeNode ans = deser.deserialize(ser.serialize(root));
  // leetcode submit region end(Prohibit modification and deletion)

}
