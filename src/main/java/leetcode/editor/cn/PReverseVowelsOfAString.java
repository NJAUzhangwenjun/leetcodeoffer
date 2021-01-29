//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
//
//
//
// 示例 1：
//
// 输入："hello"
//输出："holle"
//
//
// 示例 2：
//
// 输入："leetcode"
//输出："leotcede"
//
//
//
// 提示：
//
//
// 元音字母不包含字母 "y" 。
//
// Related Topics 双指针 字符串


/**
 * @author 张文军
 * @Company:南京农业大学
 * @version:1.0
 */

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;

//Java：反转字符串中的元音字母
public class PReverseVowelsOfAString {
	public static void main(String[] args) {
		Solution solution = new PReverseVowelsOfAString().new Solution();
		// TO TEST
	}


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String reverseVowels(String s) {
			if (s.length() <= 0)
				return "";
			HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'i', 'o', 'u', 'e', 'A', 'I', 'O', 'U', 'E'));
			char[] c = s.toCharArray();
			int l = 0, r = s.length() - 1;
			while (l < r) {
				while (l < r && !set.contains(c[l])) {
					l++;
				}
				while (l < r && !set.contains(c[r])) {
					r--;
				}
				if (l < r) {
					char temp = c[l];
					c[l++] = c[r];
					c[r--] = temp;
				}
			}
			return new String(c);
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}
