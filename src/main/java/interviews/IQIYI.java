package interviews;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/9/1314:45
 */
public class IQIYI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int i = LongestStringWithoutRepeatedSubString(s);
		System.out.println(i);
	}

	public static int LongestStringWithoutRepeatedSubString(String s) {
		if (s.length() == 0) return 0;
		Set<Character> set = new HashSet<>();
		LinkedList<Integer> list = new LinkedList<>();
		char[] charsArray = s.toCharArray();
		int left = 0;
		int res = 0;
		for (int right = 0, len = charsArray.length; right < len; ++right) {
			if (set.contains(charsArray[right])) {
				res = Math.max(res, right - left);
				while (set.contains(charsArray[right])) {
					int index = list.removeFirst();
					set.remove(charsArray[index]);
				}
				list.addLast(right);
				left = list.getFirst();
				set.add(charsArray[right]);
			} else if (right == len - 1) {
				res = Math.max(res, right - left + 1);
			} else {
				set.add(charsArray[right]);
				list.addLast(right);
			}
		}
		return res;
	}

}
