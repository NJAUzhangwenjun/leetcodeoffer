package interviews;

import java.util.Scanner;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/9/1218:58
 */
public class TrendMicro {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] s = in.nextLine().split(" ");
		String middleOrder = s[0];
		String postOrder = s[1];
		cal_tree(middleOrder,postOrder);
		if (res.length()!=middleOrder.length()) return;
		System.out.println(res);
	}
	//全局变量存放后序序列
	//先写根，后写左子树，最后写右子树
	public static String res = "";
	//两个字符串是否包含了相同的字符
	public static boolean StringEquals(String a1, String a2) {
		boolean state = true;
		if (a1.length() != a2.length()) {
			state = false;
		}
		if (a1.length() == a2.length()) {
			for (int i = 0; i < a1.length(); i++) {
				if (a2.indexOf(a1.charAt(i)) == -1)
					state = false;
			}
		}
		return state;
	}

	public static void cal_tree(String smid, String slast) {
		boolean state = StringEquals(smid, slast);
		if (state == false)
			return;
		if (smid.length() == 0)
			return;
		if (smid.length() == 1) {
			res += smid;
			return;
		}
		char root = slast.charAt(slast.length()-1);
		int mid = smid.indexOf(root);
		String c=smid.substring(0, mid);
		String d = smid.substring(mid+1);
		res += String.valueOf(root);
		cal_tree(c,slast.substring(0, c.length()));
		cal_tree(d,slast.substring(c.length(),slast.length()-1));
		return;
	}



}
