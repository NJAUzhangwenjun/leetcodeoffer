/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

import leetcode.editor.utils.ListNode;

/**
 * Java：K 个一组翻转链表 : 25
 *
 * <p>给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * <p>k 是一个正整数，它的值小于或等于链表的长度。
 *
 * <p>如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * <p>进阶：
 *
 * <p>你可以设计一个只使用常数额外空间的算法来解决此问题吗？ 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * <p>示例 1：
 *
 * <p>输入：head = [1,2,3,4,5], k = 2 输出：[2,1,4,3,5]
 *
 * <p>示例 2：
 *
 * <p>输入：head = [1,2,3,4,5], k = 3 输出：[3,2,1,4,5]
 *
 * <p>示例 3：
 *
 * <p>输入：head = [1,2,3,4,5], k = 1 输出：[1,2,3,4,5]
 *
 * <p>示例 4：
 *
 * <p>输入：head = [1], k = 1 输出：[1]
 *
 * <p>提示：
 *
 * <p>列表中节点的数量在范围 sz 内 1 <= sz <= 5000 0 <= Node.val <= 1000 1 <= k <= sz
 *
 * <p>Related Topics 链表
 */
public class PReverseNodesInKGroup {
  public static void main(String[] args) {
    Solution solution = new PReverseNodesInKGroup().new Solution();
    // TO TEST
  }
  // K 个一组翻转链表 : 25

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode()
   * {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
   * this.next = next; } }
   */
  class Solution {
    private ListNode next = null;
    public ListNode reverseKGroup(ListNode head, int k) {
      ListNode root = reverseList(head, k);
      next.next = reverseList(next, k);
      return root;
    }

    private ListNode reverseList(ListNode head, int k) {

      if (head == null) {
        return null;
      }
      ListNode pre = null;
      ListNode cur = head;
      while (k-- > 0) {
        if (cur != null) {
          ListNode next = cur.next;
          cur.next = pre;
          pre = cur;
          cur = next;
        } else return head;
      }
      /*将 反转后的子列表 与 后续列表连接*/
      next = head.next;
      return pre;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
