//字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
//将返回左旋转两位得到的结果"cdefgab"。
//
//
//
// 示例 1：
//
// 输入: s = "abcdefg", k = 2
//输出: "cdefgab"
//
//
// 示例 2：
//
// 输入: s = "lrloseumgh", k = 6
//输出: "umghlrlose"
//
//
//
//
// 限制：
//
//
// 1 <= k < s.length <= 10000
//
// Related Topics 字符串


/**
 * @author 张文军
 * @Company:南京农业大学
 * @version:1.0
 */

package leetcode.editor.cn;

//Java：左旋转字符串
public class PZuoXuanZhuanZiFuChuanLcof{
    public static void main(String[] args) {
        Solution solution = new PZuoXuanZhuanZiFuChuanLcof().new Solution();
        // TO TEST
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public String reverseLeftWords(String s, int n) {
		if (s == null ||s.length()==0|| n > s.length()) {
			return "";
		}
		String s1 = s.substring(0, n);
		String s2 = s.substring(n);
		return s2 + s1;
	}
}

//leetcode submit region end(Prohibit modification and deletion)
/*
	* 	select max(Salary) as SecondHighestSalary from Employee
		where Salary<(select max(Salary) from Employee)
	*
*/



}
