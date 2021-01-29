package interview;

import java.util.Stack;

public class Solution1 {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.add(node);
	}

	public int pop() {
		if (!stack2.isEmpty())
			return stack2.pop();
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}

	class MaxStack {
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> max = new Stack<Integer>();


		public void push(int node) {
			if (stack.isEmpty()) {
				max.add(node);
				stack.add(node);
			} else if (max.peek() < node) {
				max.add(node);
				stack.add(node);
			} else {
				stack.add(node);
			}
		}

		public int pop() {
			if (stack.isEmpty())
				throw new RuntimeException(" Stack is Empty");
			if (stack.peek().equals(max.peek())) {
				max.pop();
				return stack.pop();
			} else {
				return stack.pop();
			}
		}
	}

}
