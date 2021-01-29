package interviews;//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}
		int t ;
		for (int i = 0; i < n; i++) {
			t = list.get(i);
			list.remove(i);
			fM(list);
			list.add(i, t);
		}
	}

	private static void fM(List<Integer> list) {
		int[] a = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			a[i] = list.get(i);
		}
		Arrays.sort(a);
		System.out.println(a[a.length / 2]);
	}
}
