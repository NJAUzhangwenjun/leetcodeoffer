package interview;

import java.util.Arrays;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/8/722:10
 */
public class QuickSort {


	public void quickSort(int[] nums, int left, int right) {
		if (right-left < 1)
			return;
		int partition = partition(nums, left, right);
		quickSort(nums, left, partition - 1);
		quickSort(nums, partition + 1, right);
	}
	private int partition(int[] nums, int left, int right) {
		int min = left;//记录第一个作为基数
		while (left < right) {
			//要先从右边开始
			while (left < right && nums[right] > nums[min])
				right--;
			while (left < right && nums[left] <= nums[min]) {left++;}
			if (left < right) {
				swap(nums, left, right);
				left++;
				right--;
			}
		}
		swap(nums, min, right);
		return left;
	}
	private void swap(int[] nums, int left, int right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int[] ints = {5,5,6,63,3,3, 4, 7, 3, 7, 9};
		System.out.println(Arrays.toString(ints));
		quickSort.quickSort(ints, 0, ints.length - 1);
		System.out.println(Arrays.toString(ints));


	}
}
