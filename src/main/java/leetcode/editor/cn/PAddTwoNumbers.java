/**
 * @author 张文军 @Company:南京农业大学
 * @version:1.0
 */
package leetcode.editor.cn;

// Java：两数相加 : 2

public class PAddTwoNumbers {
  public static void main(String[] args) {
    Solution solution = new PAddTwoNumbers().new Solution();
    // TO TEST
  }

  // leetcode submit region begin(Prohibit modification and deletion)

  class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode pre = new ListNode();
      ListNode ret = pre;
      int m = 0;
      while (null != l1 || null != l2) {
        if (null != l1) {
          m += l1.val;
          l1 = l1.next;
        }
        if (null != l2) {
          m += l2.val;
          l2 = l2.next;
        }

        pre.next = new ListNode(m % 10);
        pre = pre.next;
        m = m / 10;
      }
      if (m != 0) {
        pre.next = new ListNode(m);
      }
      return ret.next;
    }
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
