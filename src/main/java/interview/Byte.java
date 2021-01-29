package interview;

import java.util.*;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/8/719:58
 */
public class Byte {
	/**
	 * 二叉树的先序遍历，层序遍历的实现
	 */
	private Queue<TreeNode> queue = new LinkedList<>();
	private List<Integer> list = new ArrayList<Integer>();


	public void level(TreeNode root) {
		if (root == null)
			return;
		queue.add(root);
		while (queue.size() != 0) {
			int size = queue.size();
			while (size-- > 0) {
				TreeNode curNode = queue.poll();
				if (curNode.left != null) {queue.add(curNode.left);}
				if (curNode.right != null) {queue.add(curNode.right);}
				System.out.print(" " + curNode.val);
			}
			System.out.println();
		}

	}


	public void preOrder(TreeNode root) {
		if (root == null)
			return;
		if (root != null) {
			System.out.print(" " + root.val);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public void preOrderStack(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			System.out.print(" " + cur.val);
			if (cur.right != null) {
				stack.add(cur.right);
			}
			if (cur.left != null) {
				stack.add(cur.left);
			}
		}
	}


	public void bfs(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode top = queue.remove();
			System.out.println(top.val);
			if (top.left != null)
				queue.add(top.left);
			if (top.right != null)
				queue.add(top.right);
		}
	}

	public static void main(String[] args) {
		Byte aByte = new Byte();
		TreeNode root = aByte.getTree();
		//byteBeat.level(root);
		//byteBeat.bfs(root);
		aByte.preOrder(root);
		System.out.println();
		aByte.preOrderStack(root);
	}

	public TreeNode getTree() {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(6);
		TreeNode t4 = new TreeNode(1);
		TreeNode t5 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;

		return t1;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class QueueByStack<E> implements Queue<E> {

		private Stack<E> stackPut;
		private Stack<E> stackOut;

		public QueueByStack() {
			this.stackPut = new Stack<E>();
			this.stackOut = new Stack<E>();
		}

		@Override
		public int size() {
			return stackOut.size() + stackPut.size();
		}

		@Override
		public boolean isEmpty() {
			return size() == 0;
		}

		@Override
		public boolean contains(Object o) {
			return false;
		}

		@Override
		public Iterator<E> iterator() {
			return null;
		}

		@Override
		public Object[] toArray() {
			return new Object[0];
		}

		@Override
		public <T> T[] toArray(T[] a) {
			return null;
		}

		@Override
		public boolean add(E e) {
			return stackPut.add(e);
		}

		@Override
		public boolean remove(Object o) {
			if (!stackPut.isEmpty()) {
				stackOut.push(stackPut.pop());
			}
			if (stackOut.contains(o))
				return stackOut.remove(o);
			throw new RuntimeException(o + " not in this Queue ");
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends E> c) {
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			return false;
		}

		@Override
		public void clear() {

		}

		@Override
		public boolean offer(E e) {
			return false;
		}

		@Override
		public E remove() {
			if (!stackPut.isEmpty()) {
				stackOut.push(stackPut.pop());
			}
			return null;
		}

		@Override
		public E poll() {
			return null;
		}

		@Override
		public E element() {
			return null;
		}

		@Override
		public E peek() {
			return null;
		}
	}


}
