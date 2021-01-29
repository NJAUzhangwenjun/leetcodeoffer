package interview;

import java.util.LinkedList;
import java.util.Queue;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 * }
 */

public class Solution {
	/**
	 * 判断是否为回文链表
	 * @param head ListNode类 链表头
	 * @return bool布尔型
	 */
	public boolean isPalindrome(ListNode head) {
		if (head==null|| head.next==null) return true;
		// write code here
		Queue<Integer> queue = new LinkedList<>();

		while (head != null) {
			if (queue.isEmpty())
				queue.add(head.val);
			else if (queue.peek()!=head.val)
				queue.add(head.val);
			else
				queue.remove();
			head = head.next;
		}
		return queue.isEmpty();
	}


	public class ListNode {
		int val;
		ListNode next = null;
	}
}
