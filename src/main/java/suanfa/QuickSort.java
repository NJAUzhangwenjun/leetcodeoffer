package suanfa;

import java.util.Arrays;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/7/1323:38
 */
public class QuickSort {


	public int partition(int[] ints) {
		return partition(ints, 0, 0, ints.length - 1);
	}


	public int partition(int[] ints, int par,int l,int r) {
		int num = ints[par];

		while (l < r) {

			while (l < ints.length && ints[l] < num) {
				l++;
			}
			while (r >= 0 && ints[r] > num) {
				r--;
			}

			if (l < r) {
				swap(ints, l, r);
			}

		}
		swap(ints, par, l);
		return r;
	}

	private void swap(int[] ints, int l, int r) {
		int temp = ints[l];
		ints[l] = ints[r];
		ints[r] = temp;
	}


	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] ints = {5, 7, 3, 2};
		System.out.println("quickSort.partition(new int[5,7,3,2]) = " + quickSort.partition(ints));
		System.out.println(Arrays.toString(ints));
	}
}
