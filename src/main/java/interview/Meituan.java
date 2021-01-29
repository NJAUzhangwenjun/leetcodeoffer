package interview;

import java.util.Scanner;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/8/2916:11
 */
public class Meituan {
	/**
	 * 小团深谙保密工作的重要性，因此在某些明文的传输中会使用一种加密策略，小团如果需要传输一个字符串S，
	 * 则他会为这个字符串添加一个头部字符串和一个尾部字符串。头部字符串满足至少包含一个“MT”子序列，且以
	 * T结尾。尾部字符串需要满足至少包含一个“MT”子序列，且以M开头。例如AAAMT和MAAAT都是一个合法的头部
	 * 字符串，而MTAAA就不是合法的头部字符串。很显然这样的头尾字符串并不一定是唯一的，因此我们还有一个约
	 * 束，就是S是满足头尾字符串合法的情况下的最长的字符串。
	 *
	 * 很显然这样的加密策略是支持解码的，给出你一个加密后的字符串，请你找出中间被加密的字符串S。
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		String t = null;
		int m = 2;
		n = Integer.parseInt(sc.nextLine());
		t = sc.nextLine();
		System.out.println("n = " + n);
		System.out.println("t = " + t);

		ptintS(n, t);
	}
	private static void ptintS(int n, String t) {
		if (n <= 0 || t.length() == 0)
			return;
		int i = 0;
		Boolean M = false;
		while (i < t.length()) {
			while (i < t.length() && t.charAt(i) != 'T') {
				if (t.charAt(i) == 'M')
					M = true;
				i++;
			}
			if (i < t.length() && M)
				break;
			i++;
			if (i >= t.length())
				return;
		}
		int j = t.length() - 1;
		Boolean T = false;
		while (j >= 0) {
			while (j >= 0 && t.charAt(j) != 'M') {
				if (t.charAt(j) == 'T')
					T = true;
				j--;
			}
			if (j >= 0 && T)
				break;
			j--;
			if (j < 0)
				return;
		}

		if (j - i + 1 <= 0)
			return;
		String substring = t.substring(i + 1, j);
		System.out.println(substring);
	}
}
