package interviews;

import java.util.*;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: zhanghub.cn
 * @version: 1.0
 * @date 2020/9/2319:44
 */
class LearnFrom {


	/**
	 * 账户合并
	 * 时间限制： 3000MS
	 * 内存限制： 589824KB
	 * 题目描述：
	 * 给定一个帐户列表，每个元素accounts [i]是一个字符串列表，
	 * 其中第一个元素accounts [i] [0]是账户名称，其余元素是这个帐户的电子邮件。
	 * 现在，我们想合并这些帐户。 如果两个帐户有相同的电子邮件地址，则这两个帐户肯定属于同一个人。
	 * 请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为两个不同的人可能会使用相同的名称。
	 * 一个人可以拥有任意数量的账户，但他的所有帐户肯定具有相同的名称。 合并帐户后，按以下格式返回帐户
	 * ：每个帐户的第一个元素是名称，其余元素是按字典序排序后的电子邮件。 帐户本身可以按任何顺序返回。
	 */
}
class Main {


	/*请完成下面这个函数，实现题目要求的功能
	当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
	******************************开始写代码******************************/
//	static List<List<String>> mergeAccount(List<List<String>> accounts) {
//		// 在此处编写实现代码逻辑
//
//	}
	/******************************结束写代码******************************/


	static List<List<String>> mergeAccount(List<List<String>> accounts) {
		Map<String, String> map = new HashMap<String, String>();
		Map<String, ArrayList<String>> graph = new HashMap();
		for (List<String> account : accounts){
			String name = account.get(0);
			String mail = account.get(1);
			for (int i = 1; i < account.size(); i++){
				graph.computeIfAbsent(account.get(i), x -> new ArrayList<String>()).add(mail);
				graph.computeIfAbsent(mail, x -> new ArrayList<String>()).add(account.get(i));
				map.put(account.get(i), name);
			}
		}
		Set<String> seen = new HashSet<>();
		List<List<String>> ans = new ArrayList<>();
		for (String email : graph.keySet()){
			if (!seen.contains(email)){
				seen.add(email);
				Stack<String> stack = new Stack();
				List<String> temp = new ArrayList();
				stack.push(email);
				while (!stack.isEmpty()){
					String node = stack.pop();
					temp.add(node);
					for (String n : graph.get(node)){
						if (!seen.contains(n)){
							stack.push(n);
							seen.add(n);
						}
					}
				}
				Collections.sort(temp);
				temp.add(0, map.get(email));
				ans.add(temp);
			}
		}
		return ans;
	}
















	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int _count = Integer.parseInt(in.nextLine());

		int _i = 0;
		List<List<String>> _accounts = new ArrayList<List<String>>();
		while (_i++ < _count) {
			String _line = in.nextLine();
			String[] _item = _line.split(",");
			_accounts.add(Arrays.asList(_item));
		}

		List<List<String>> res = mergeAccount(_accounts);

		Collections.sort(res, new Comparator<List<String>>() {

			@Override
			public int compare(List<String> o1, List<String> o2) {
				String aName1 = String.join(",", o1);
				String aName2 = String.join(",", o2);
				return aName1.compareTo(aName2);
			}

		});

		for (int res_i = 0; res_i < res.size(); res_i++) {
			List<String> resItem = res.get(res_i);
			System.out.println(String.join(",", resItem));
		}
	}
}


/**
 * @author user
 */
//class Main2 {
//
//	public static class Node {
//
//		private int data;
//		private Node next;
//
//		public int getData() {
//			return data;
//		}
//
//		public void setData(int data) {
//			this.data = data;
//		}
//
//		public Node getNext() {
//			return next;
//		}
//
//		public void setNext(Node next) {
//			this.next = next;
//		}
//	}
//
//
//	/*请完成下面这个函数，实现题目要求的功能
//	当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
//	******************************开始写代码******************************/
//	static Node getCommon(Node headA, Node headB) {
//		if (headA == null || headB == null)
//			return null;
//		HashSet<Node> set = new HashSet<>();
//		while (headA != null) {
//			set.add(headA);
//			headA = headA.next;
//		}
//		while (headB != null && !set.contains(headB)) {
//			headB = headB.next;
//		}
//		return headB;
//	}
//
//	/******************************结束写代码******************************/
//
//
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//
//		String line1 = in.nextLine();
//		String line2 = in.nextLine();
//
//		Node headA = null;
//		Node headB = null;
//
//		Map<String, Node> map = new HashMap<String, Node>();
//
//		if (line1 != null && line1.length() > 0) {
//			String[] array1 = line1.split(",");
//			headA = new Node();
//			headA.setData(Integer.parseInt(array1[0].split("\\(")[0]));
//			map.put(array1[0], headA);
//			Node pre = headA;
//			for (int i = 1; i < array1.length; i++) {
//				Node node = map.get(array1[i]);
//				if (node == null) {
//					node = new Node();
//					node.setData(Integer.parseInt(array1[i].split("\\(")[0]));
//					map.put(array1[i], node);
//				}
//				pre.next = node;
//				pre = node;
//			}
//		}
//		if (line2 != null && line2.length() > 0) {
//			String[] array2 = line2.split(",");
//			headB = map.get(array2[0]);
//			if (headB == null) {
//				headB = new Node();
//				headB.setData(Integer.parseInt(array2[0].split("\\(")[0]));
//				map.put(array2[0], headB);
//			}
//			Node pre = headB;
//			for (int i = 1; i < array2.length; i++) {
//				Node node = map.get(array2[i]);
//				if (node == null) {
//					node = new Node();
//					node.setData(Integer.parseInt(array2[i].split("\\(")[0]));
//					map.put(array2[i], node);
//				}
//				pre.next = node;
//				pre = node;
//			}
//		}
//
//		Node res = getCommon(headA, headB);
//		System.out.println(res == null ? res : res.getData());
//	}
//}

