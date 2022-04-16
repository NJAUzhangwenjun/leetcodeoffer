package interview2021;

/**
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/3/2919:42
 */
public class alb {
  // 题目1：小明现在手里有两个数a和b，你需要进行若干次操作使得a | b的值等于c，
  // 每次操作可以任选a, b两数之一的某一个二进制位进行取反操作，即0变1，1变0.
  // 其中 | 是按位或运算，其功能是参与运算的两数各对应的二进制位相或，
  // 只要对应的两个二进制位中有一个为1时，结果位就为1，否则为0.
  // 现在想让你求最少的翻转次数，使得 a | b = c 成立.
  // 示例：
  // a=2, b=6, c=5，则翻转次数为：3
  // a=1, b=2, c=3，则翻转次数为：0

  private int count = 0;
  private int x = 0;
  private int y = 0;

  public int xor(int a, int b, int c) {
    if ((a | b) == c) return 0;
    x = Integer.toBinaryString(a).length();
    y = Integer.toBinaryString(b).length();
    return xor(a, b, c,0,0,0);
  }
  public int xor(int a, int b, int c,int x,int y,int count) {
    if ((a | b) == c||(this.x <= x && this.y <= y)) return count;
    int aa = 0;
    int bb = 0;
    if (this.x >= x) {
      aa = a ^ (1 << x);
      System.out.println(
          "Integer.toBinaryString(aa).length() = " + Integer.toBinaryString(aa).length());
    }
    int i = xor(aa, b, c, x+1, y,count++);
    if (this.y >= y) {
      bb = b ^ (1 << y);
    }
    if (this.x <= x && this.y <= y) return 0;
    int j = xor(a, bb, c, x, y+1,count++);
    return Math.min(i,j);
  }
  // 题目2：有一根长度为n厘米的蜡烛，每分钟可以燃烧1厘米。
  // 现在我们会把这根蜡烛随机分成两根蜡烛。
  // 如图：有n-1个可以分的位置，在每个位置分开的概率都为1/(n-1).
  // 然后就可以得到两根蜡烛，把没有燃烧的蜡烛点燃，
  // 如果这两根蜡烛其中一根燃完时，另外一根的长度>=2，
  // 那么我们还必须对剩下的这根蜡烛再进行一次随机分开，再点燃的操作。
  // 这次操作后不能再进行任何操作。问所有的蜡烛全部烧完的期望时间（分钟数）。
  // 输入描述：
  // 一行：n(1<=n<=10^4)
  // 输出描述：
  // 一个浮点数（保留4位小数）（所有的蜡烛全部烧完的期望时间，分钟数）
  // 示例1：
  // 输入
  // 4
  // 输出
  // 2.0000

  public Double candleBurningTime(int n) {
    double ceil = Math.ceil(n / 2);
    return ceil;
  }

  public static void main(String[] args) {
    alb alb = new alb();
    //    Double aDouble = alb.candleBurningTime(4);
    //    System.out.println("aDouble = " + aDouble);
    int xor = alb.xor(2, 6, 5);
    System.out.println("xor = " + xor);
  }

  /**
   * 分段同时烧两根等价于两头烧n/2
   *
   * <p>长度 a b t1 t2 t 1 1 0 1 0 1
   *
   * <p>2 1 1 1 0 1
   *
   * <p>3 1 2 1 1 2
   *
   * <p>4 1 3 1 1 2 4 2 2 2 0 2
   *
   * <p>5 1 4 1 2 3 5 2 3 2 1 3
   *
   * <p>6 1 5 1 2 3 6 2 4 2 1 3 6 3 3 3 0 3
   *
   * <p>7 1 6 1 + 3 = 4 7 2 5 2 + 2 = 4 7 3 4 3 + 1 = 4
   *
   * <p>8 1 7 1 + 3 = 4 8 2 6 2 + 2 = 4 8 3 5 3 + 1 = 4 8 4 4 4
   *
   * <p>9 1 8 1 + 4 = 5 9 2 7 2 + 3 = 5 9 3 6 3 + 2 = 5 9 4 5 4 + 1 = 5
   *
   * <p>10 1 9 1 + 4 = 5 . . . 那么 其实期望就是 n/2向上取整
   */
}
