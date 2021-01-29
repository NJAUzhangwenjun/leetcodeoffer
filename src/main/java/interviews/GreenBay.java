package interviews;

/**
 * @Description: kujiale
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/9/1718:49
 */

public class GreenBay {
	/**
	 * 取余数
	 * @param base int整型 基数
	 * @param power long长整型 幂
	 * @return int整型
	 */
	public int getRemainder(int base, long power) {
		int a = base;
		long b = power;
		int m = 100;
		int r = 1;
		a %= m;
		while (b > 1) {
			if ((b & 1) != 0) {
				r = (r * a) % m;
			}
			a = (a * a) % m;
			b /= 2;
		}
		return (r * a) % m;
	}
	/**
	 *
	 * @param root TreeNode类 根节点
	 * @return long长整型
	 */
	private int sum = 0;
	public long sumOfLeftLeaves(TreeNode root) {
		// write code here
		if (root == null) {
			return 0;
		}
		dfs(root, 0);
		return sum;
	}
	private void dfs(TreeNode root, int path) {
		if (root.left == null && root.right == null && path == 1) {
			sum += root.val;
		}
		if (root.left != null)
			dfs(root.left, 1);
		if (root.right != null)
			dfs(root.right, -1);
	}
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;
	}
	public static void main(String[] args) {
		GreenBay kujiale = new GreenBay();
		System.out.println("kujiale.getRemainder(20200827, 10) = " + kujiale.getRemainder(20200827,10));
	}
}
