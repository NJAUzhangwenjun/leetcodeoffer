package leetcode.editor.cn;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: zhanghub.cn
 * @version: 1.0
 * @date 2020/11/101:17
 */
public class LeetCodeUtils {
	public static  void swap(int[] nums, int pre, int cur) {
		int temp = nums[pre];
		nums[pre] = nums[cur];
		nums[cur] = temp;
	}
}
