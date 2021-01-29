package cn.njauit.al;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/8/1019:04
 */
public class MinLength {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Integer[] trees = new Integer[N];
		int i = 0;
		while (in.hasNextInt()) {
			trees[i++] = in.nextInt();
		}
		Arrays.sort(trees);

		int ret = 0;

		int mind = N % 2 == 1 ? (N + 1) / 2 : N / 2;

		for (int j = 0; j < trees.length; j++) {
			Integer tree = trees[j];
			ret += Math.abs(tree - trees[mind]);
		}
		System.out.println(ret);
	}

	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		String [] treeIndex = sc.nextLine().split(" ");
		List<Integer[]> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			Integer[] ints = new Integer[2];
			for (int j = 0; j < 2; j++) {
				ints[0] = sc.nextInt();
			}
			list.add(ints);
		}

		//根据treeIndex构建Tree

		//按照 list 行走

		//输出结果

	}
}
