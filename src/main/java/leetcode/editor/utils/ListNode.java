package leetcode.editor.utils;

import java.util.List;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode() {}

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  @Override
  public String toString() {
    ListNode listNode = this;
    final StringBuilder b = new StringBuilder("{");
    while (listNode != null) {
      b.append(listNode.val + "->");
      listNode = listNode.next;
    }
    return b.substring(0, b.length() - 2)+"}";
  }

  public static ListNode getListNode(List<Integer> list) {
    ListNode dummyHead = new ListNode(0),ret = dummyHead;
    for (Integer i : list) {
      dummyHead.next = new ListNode(i);
      dummyHead = dummyHead.next;
    }
    return ret.next;
  }

  public static ListNode getListNode(int ... list) {
    ListNode dummyHead = new ListNode(0),ret = dummyHead;
    for (Integer i : list) {
      dummyHead.next = new ListNode(i);
      dummyHead = dummyHead.next;
    }
    return ret.next;
  }
}
