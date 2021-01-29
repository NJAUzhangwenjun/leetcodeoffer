package interviews;//

import java.util.Scanner;

public class Main22 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = Integer.parseInt(sc.nextLine());
		String[] s1 = sc.nextLine().split(" ");
		int n2 = Integer.parseInt(sc.nextLine());
		String[] s2 = sc.nextLine().split(" ");
		int[] res = null;
		res = fU(s1, s2);
		for (int i = 0; i < res.length; i++) {
			if (res[i] != 0)
				System.out.print(res[i] + " ");
		}
	}

	private static int[] fU(String[] s1, String[] s2) {
		int l1 = s1.length;
		int l2 = s2.length;
		int unionLen = Math.min(s1.length, s2.length);
		int[] res = new int[unionLen];
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < l1 && j < l2) {
			if (Integer.parseInt(s1[i]) < Integer.parseInt(s2[j])) {
				j++;
			} else if (Integer.parseInt(s1[i]) > Integer.parseInt(s2[j])) {
				i++;
			} else {
				res[k] = Integer.parseInt(s1[i]);
				i++;
				j++;
				k++;
			}
		}
		return res;
	}
}
