package leetcode.editor.mode.backtracking;

import leetcode.editor.utils.Node;

import java.util.Stack;

/**
 * @author 张文军 @Description: 深度优先遍历 @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/2/177:09
 */
public class DFS {
  /*递归写法*/
  public void dfs1(Node head) {
    if (head == null) return;
    System.out.print(" " + head.value);
    dfs1(head.right);
    dfs1(head.left);
  }

  /**
   * 非递归写法
   *
   * @param head
   */
  public void dfs2(Node head) {
    if (head == null) return;
    final Stack<Node> stack = new Stack<>();
    stack.push(head);
    while (!stack.isEmpty()) {
      final Node cur = stack.pop();
      System.out.println(" " + cur.value);
      if (cur.right != null) stack.push(cur.right);
      if (cur.left != null) stack.push(cur.left);
    }
  }
}
