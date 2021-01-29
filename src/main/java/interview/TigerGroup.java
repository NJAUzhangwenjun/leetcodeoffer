package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/8/2316:57
 */
public class TigerGroup {
	/**
	 * 排队
	 * @param head ListNode类 头结点
	 * @return ListNode类
	 */
	public ListNode lineUp(ListNode head) {
		// write code here
		if (head == null) {
			return null;
		}
		ListNode dummy1 = new ListNode(-1);
		ListNode d1 = dummy1;
		ListNode dummy2 = new ListNode(-1);
		ListNode d2 = dummy2;
		//是否为奇数数位
		Boolean flag = true;
		while (head != null) {
			if (flag) {
				dummy1.next = head;
			} else {
				dummy2.next = head;
			}
			head = head.next;
			flag = !flag;
		}
		dummy1.next = d2.next;

		return d1.next;
	}

	public class ListNode {
		int val;
		ListNode next = null;

		public ListNode(int val) {
			this.val = val;
		}
	}
	public static void main(String[] args) {
		TigerGroup tigerGroup = new TigerGroup();

		ArrayList<ArrayList<Integer>> arrayLists = tigerGroup.combinationSum(new int[]{3, 8, 6}, 14);
		for (ArrayList<Integer> list : arrayLists) {
			System.out.println(Arrays.toString(list.toArray(new Integer[0])));
		}
	}

	/**
	 * 合适的股票每手价格组合
	 * @param prices int整型一维数组 股票数量
	 * @param m int整型 资产值
	 * @return int整型ArrayList<ArrayList <>>
	 */
	private ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> combinationSum (int[] prices, int m) {
		// write code here
		if (prices==null||prices.length==0)
			return lists;
		dfs(prices,0, m, new ArrayList<Integer>());
		return lists;
	}

	/**
	 *
	 * @param prices 价格表
	 * @param k 第 k个个票
	 * @param m 当前还可以购买的金额
	 * @param list 组合价格表
	 */
	private void dfs(int[] prices,int k, int m, ArrayList<Integer> list) {
		if (m == 0) {
			ArrayList<Integer> l = new ArrayList<>(list);
			Collections.sort(l);
			lists.add(l);
			return;
		}
		if (k >= prices.length||m<0) {
			return;
		}
		//不买
		dfs(prices, k + 1, m, list);
		//买
		list.add(prices[k]);
		dfs(prices, k + 1, m - prices[k], list);
		list.remove(list.size() - 1);
	}
}
