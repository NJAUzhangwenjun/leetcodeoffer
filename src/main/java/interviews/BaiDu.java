package interviews;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/9/1418:35
 */
public class BaiDu {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		for (int i = 0; i < T; i++) {
			String[] s = in.nextLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			String[] nn = in.nextLine().split(" ");
			String[] mm = in.nextLine().split(" ");
			int[] a = new int[nn.length];
			int[] b = new int[mm.length];
			for (int j = 0; j < nn.length; j++) {
				a[j] = Integer.parseInt(nn[j]);
			}
			for (int j = 0; j < mm.length; j++) {
				b[j] = Integer.parseInt(mm[j]);
			}
			fulfilRequirements(a, b);
		}
	}

	private static void fulfilRequirements(int[] g, int[] s) {
		if (g == null || s == null)
			return;
		Arrays.sort(g);
		Arrays.sort(s);
		int gi = 0;
		int si = 0;
		while (gi < g.length && si < s.length) {
			while (gi < g.length && g[gi] < s[si]) {
				gi++;
			}
			if (gi < g.length && g[gi] >= s[si]) {
				System.out.print(g.length - gi - 1 + " ");
			}
			si++;
			gi++;
		}
	}

}
/**
 1
 3 6
 33 66 99
 3 6 9 30 60 90
 **/
