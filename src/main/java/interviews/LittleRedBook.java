package interviews;

import java.util.Scanner;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/9/1210:15
 */
public class LittleRedBook {

	/*请完成下面这个函数，实现题目要求的功能
	当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
	******************************开始写代码******************************/
	private static int ret = Integer.MAX_VALUE;

	static int findMin(int[] tree) {
		if (tree == null || tree.length == 0)
			return -1;
		for (int i = 0; i < tree.length; i++) {
			if (ret > tree[i]) {
				ret = tree[i];
			}
		}
		if (ret - 1 > 1)
			return 1;
		else
			return ret - 1;
	}


	static int solution(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int ret = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int j = s.lastIndexOf(c);
			if (j == -1||j==i) {
				ret += 1;
			} else if (j > i) {
				ret += 1;
				i = j;
			}
		}
		return ret;
	}

	/******************************结束写代码******************************/




	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int res;

		String _s;
		try {
			_s = in.nextLine();
		} catch (Exception e) {
			_s = null;
		}

		res = solution(_s);
		System.out.println(String.valueOf(res));

	}
}
