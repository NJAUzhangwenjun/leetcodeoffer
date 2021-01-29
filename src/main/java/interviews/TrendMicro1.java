package interviews;

import java.util.Scanner;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/9/1218:58
 */
public class TrendMicro1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String n = in.nextLine();
		int x = Integer.parseInt(in.nextLine());
		String s = removeKdigits(n, x);
		System.out.println(s);

	}

	public static String removeKdigits(String num, int k) {
		StringBuilder sb = new StringBuilder();
		int len = num.length();
		char[] stack = new char[len];
		int count = 0;
		for (int i = 0; i < len; i++) {
			while (count != 0 && k > 0 && num.charAt(i) < stack[count - 1]) {
				//根据贪心算法删除比后一个大的值
				count--;
				k--;
			}
			stack[count++] = num.charAt(i);
		}
		int start = 0;
		while (start < count && stack[start] == '0')
			start++;
		return start >= count - k ? "0" : new String(stack, start, count - start - k);
	}


}
