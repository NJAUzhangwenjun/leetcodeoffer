/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

// Java：反转链表 : 206

// 反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
// 输出: 5->4->3->2->1->NULL
//
// 进阶:
// 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表

import leetcode.editor.utils.ListNode;

public class PReverseLinkedList {
  public static void main(String[] args) {
    Solution solution = new PReverseLinkedList().new Solution();
    // TO TEST
  }
  // 反转链表 : 206

  // leetcode submit region begin(Prohibit modification and deletion)
  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode()
   * {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
   * this.next = next; } }
   */
  class Solution {
    public ListNode reverseList(ListNode head) {
      if (head == null) {
        return null;
      }
      ListNode pre = null;
      ListNode cur = head;
      while (cur != null) {
        ListNode next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
      }
      return pre;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
