package interviews;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: zhanghub.cn
 * @version: 1.0
 * @date 2020/9/2416:05
 */
public class AliAuto {

	/**
	 * 数独
	 */

	public static void main1(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()){
			int[][]a=new int[9][9];
			boolean[][] cols = new boolean[9][9];
			boolean[][] rows = new boolean[9][9];
			boolean[][] blocks = new boolean[9][9];

			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length; j++) {
					a[i][j]=sc.nextInt();
					if(a[i][j]!=0){
						int k = i/3*3+ j/3;
						int val=a[i][j]-1;
						rows[i][val] = true;
						cols[j][val] = true;
						blocks[k][val] = true;
					}
				}
			}
			dfs(a, cols, rows, blocks);
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 8; j++) {
					System.out.print(a[i][j]+" ");
				}
				System.out.println(a[i][8]);
			}
		}
	}
	public static boolean dfs(int[][] a,boolean[][] cols,boolean[][] rows,boolean[][] blocks) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(a[i][j]==0){
					int k=i/3*3+j/3;
					for (int l = 0; l < 9; l++) {
						if(!cols[j][l]&&!rows[i][l]&&!blocks[k][l]){
							rows[i][l] = cols[j][l] = blocks[k][l] = true;
							a[i][j] = 1 + l;
							if(dfs(a, cols, rows, blocks)) return true;
							rows[i][l] = cols[j][l] = blocks[k][l] = false;
							a[i][j] = 0;
						}
					}
					return false;
				}
			}
		}
		return true;
	}


	/**
	 *
	 * @param tasks int整型一维数组 待加工的零件
	 * @param n int整型 n的值
	 * @return int整型
	//	 */
	//	public static int leastWorkTime(int[] tasks, int n) {
	//		// write code here
	////		PriorityQueue<Integer> queue = new PriorityQueue<>;
	//		for (int i = 0; i < tasks.length; i++) {
	//			queue.add(tasks[i]);
	//		}
	//
	//		while (queue.size() > 1) {
	//			queue.poll();
	//			queue.add(n + queue.poll());
	//		}
	//		return queue.peek()-1;
	//	}

	//	public static void main(String[] args) {
	//		System.out.println(
	//				"leastWorkTime(new int[]{1,1,1,2,3,3,3},2) = " + leastWorkTime(new int[]{1, 1, 1, 2, 3, 3, 3}, 2));
	//	}


	private static Pattern h = Pattern.compile("[A-Z]");
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String ret = humpToLine(s);
		System.out.println(ret);
	}
	private static String humpToLine(String s){
		Matcher matcher = h.matcher(s);
		StringBuffer buffer = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(buffer, "_" + matcher.group(0).toLowerCase());
		}
		matcher.appendTail(buffer);
		return buffer.toString().substring(1);
	}










}
