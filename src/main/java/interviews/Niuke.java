package interviews;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/9/1721:46
 */
public class Niuke {
	/**
	 * 对于两个字符串A和B，我们需要进行插入、删除和修改操作将A串变为B串，定义
	 * c0，c1, c2分别为三种操作的代价，请设计一个高效算法，求出将A串变为B串所需
	 * 要的最少代价。
	 * 给定两个字符串A和B，及它们的长度和三种操作代价，请返回将A串变为B串所需要
	 * 的最小代价。保证两串长度均小于等于300，且三种代价值均小于等于100。
	 * 测试样例:
	 */

	public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
		int[][] dp = new int[n+1][m+1];
		dp[0][0] = 0;
		for(int i=1;i<=n;i++){
			dp[i][0]=i*c1;
		}
		for(int i=1;i<=m;i++){
			dp[0][i]=i*c0;
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(A.charAt(i-1)!=B.charAt(j-1)){
					dp[i][j]=Math.min(dp[i-1][j-1]+c2,Math.min(dp[i-1][j]+c1,dp[i][j-1]+c0));
				}else
					dp[i][j]=dp[i-1][j-1];
			}
		}
		return dp[n][m];
	}
	/**
	 * 农夫John有一-大群羊，为了便于管理，他给这些羊都编上了编号(1..n)，然后他按
	 * 照编号依次将这些羊用绳子连在了一起。现在他领着羊群到一个绿草带上吃草，
	 * 为了简化问题，我们这里将绿草带看成一条-维的数轴，他把编号为1的羊用绳子
	 * 和草地一端的木桩连在了一起，但是麻烦的是，羊群的顺序乱了，现在编号为i的
	 * 羊在离木桩第X远的地方吃草。更麻烦的是，可能会有两根连接的绳子因为相交
	 * 而缠在了一起，这里的相交是指对于两根绳子A(连接编号la和ra,其中Xia小于Xra)
	 * 和B(连接编号Ib和rb，其中Xb小于Xrb),Xa <XIp<Xra且Xb<Xra <Xp。现在John想要
	 * 避免这样的相交的情况，请你帮他计算为了节约体力最少要调整几只羊的位置才
	 * 能实现不相交。
	 */
	public int getAns(int[] A, int n) {
		// write code here
		return 0;
	}

}
