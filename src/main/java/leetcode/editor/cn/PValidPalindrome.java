//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串


/**
 * @author 张文军
 * @Company:南京农业大学
 * @version:1.0
 */

package leetcode.editor.cn;

//Java：验证回文串
public class PValidPalindrome {
	public static void main(String[] args) {
		Solution solution = new PValidPalindrome().new Solution();
		// TO TEST
		System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
	}


	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean isPalindrome(String s) {
			if (s.length() == 0)
				return true;
			int l = 0;
			int r = s.length() - 1;
			while (l < r) {
				while (l < r && !Character.isLetterOrDigit(s.indexOf(r)))
					r--;
				Character.toLowerCase(s.indexOf(r));

				while (l < r && !Character.isLetterOrDigit(s.indexOf(l))) {l++;}
				Character.toLowerCase(s.indexOf(l));
				if (s.indexOf(l) != s.indexOf(r))
					return false;
			}
			return true;
		}
	}
	//leetcode submit region end(Prohibit modification and deletion)

}
