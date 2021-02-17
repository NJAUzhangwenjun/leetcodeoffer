package leetcode.editor.mode.backtracking;

import leetcode.editor.utils.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 张文军 @Description: 广度优先遍历 @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/2/177:25
 */
public class BFS {
  public void bfs(Node head) {
    if (head == null) return;
    Queue<Node> queue = new LinkedList<>();
    queue.add(head);
    while (!queue.isEmpty()) {
      final Node cur = queue.peek();
      System.out.println(" " + cur.value);
      if (cur.left != null) queue.add(cur.left);
      if (cur.right != null) queue.add(cur.right);
    }
  }
}
