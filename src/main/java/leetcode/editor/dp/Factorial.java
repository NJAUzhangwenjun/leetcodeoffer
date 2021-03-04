package leetcode.editor.dp;

/**
 * @author 张文军
 * @Description:
 * @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/3/319:04
 */
public class Factorial {
  public int f(int n) {
    if (n < 0) {
      throw new IllegalArgumentException("n is less zero");
    }
    return dp(n);
  }

    private int dp(int n) {
    if (n == 0||n==1) return 1;
    int ret = 1;
    int count = 1;
    while (n>count) {
      ret *= ++count;
    }
    //        return dp(n-1)*n;
    return ret;
    }

  public static void main(String[] args) {
      final Factorial factorial = new Factorial();
      final int f = factorial.f(5);
    System.out.println("f = " + f);
  }
}

