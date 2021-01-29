package interviews;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/9/1020:12
 */
public class TuhuRaisesACar {
	/**
	 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
	 * calculate combination Number
	 * @param r int整型
	 * @param n int整型
	 * @return int整型
	 */
	public int combination (int r, int n) {
		// write code here
		if (r==0)
			return 1;
		if (r==1)
			return n;
		if (r>n/2)return combination(n - r, n);
		if (r>1)
			return combination(r - 1, n - 1) + combination(r, n - 1);
		return -1;
	}

	/**
	 * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
	 *
	 * @param array1 int整型一维数组
	 * @param n int整型
	 * @param array2 int整型一维数组
	 * @param m int整型
	 * @return int整型一维数组
	 */
	public int[] arrayMerge (int[] array1, int n, int[] array2, int m) {
		// write code here
		int[] c = new int[m+n];
		int i = 0,j =m-1,k=0;
		while (i < n && j >=0) {
			if (array1[i] >= array2[j]) {
				c[k++] = array2[j--];
			} else {
				c[k++] = array1[i++];
			}
		}

		while (j >=0) {
			c[k++] = array2[j--];
		}
		while (i < n) {
			c[k++] = array1[i++];
		}
		return c;
	}


	public int[] arrayMerge2 (int[] array1, int n, int[] array2, int m) {
		// write code here
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(array1[i]);
		}for (int i = 0; i < m; i++) {
			list.add(array1[i]);
		}
		Collections.sort(list);
		int[] ints = list.stream().mapToInt(Integer::valueOf).toArray();
		return ints;
	}
}
