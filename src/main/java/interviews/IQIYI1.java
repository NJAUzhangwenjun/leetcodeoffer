package interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/9/1314:45
 */
public class IQIYI1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		int[] ints = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			ints[i] = Integer.parseInt(s[i]);
		}
		List<List<Integer>> lists = threeNumberSum(ints);
		for (List<Integer> list : lists) {
			for (Integer i : list) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> threeNumberSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums == null || nums.length <= 2) return ans;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0) break;
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			int target = -nums[i];
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				if (nums[left] + nums[right] == target) {
					ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

					left++; right--;
					while (left < right && nums[left] == nums[left - 1]) left++;
					while (left < right && nums[right] == nums[right + 1]) right--;
				} else if (nums[left] + nums[right] < target) {
					left++;
				} else {
					right--;
				}
			}
		}
		return ans;
	}


}
