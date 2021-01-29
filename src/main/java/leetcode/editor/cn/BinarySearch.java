package leetcode.editor.cn;

/**
 * @Description: 二分法查找
 * @author 张文军
 * @Company: zhanghub.cn
 * @version: 1.0
 * @date 2020/11/923:51
 */
public class BinarySearch<T extends Comparable<T>> {
	int targetIndex = -1;

	public int binarySearch(T[] arr, T target) {
		int l = 0, r = arr.length - 1;
		binarySearch(arr, target, l, r);
		return targetIndex;
	}

	private void binarySearch(T[] arr, T target, int l, int r) {
		if (l > r)
			return;
		int mid = (l + r) / 2;
		if (target == arr[mid]) {
			targetIndex = mid;
			return;
		}
		if (target.compareTo(arr[mid]) < 0)
			binarySearch(arr, target, l, mid - 1);
		if (target.compareTo(arr[mid]) > 0)
			binarySearch(arr, target, mid + 1, r);
	}

	public static void main(String[] args) {
		int[] ints = {1, 2, 3, 4, 6,12,45,57,78,89,90,112, 122, 123, 124, 126,1212,1245,1257,1278,1290};
		BinarySearch<Integer> search = new BinarySearch<>();
		search.sort(1290,ints, 0, ints.length - 1);
	}

	private int sort(int key, int[] target, int left, int right) {
		if (left > right)
			return -1;
		int mid = left + (right - left) / 2;
		int m = (left + right) / 2;
		System.out.println("mid = " + mid+";m = "+m);
		if (key < target[mid])
			return sort(key, target, left, mid - 1);
		if (key > target[mid])
			return sort(key, target, mid + 1, right);
		else
			return mid;
	}
}
