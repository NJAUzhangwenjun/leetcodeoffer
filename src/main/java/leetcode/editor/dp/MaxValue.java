package leetcode.editor.dp;

/**
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/3/321:02
 */
public class MaxValue {
  /*map: start:length*/
  private int ret = 0;

  public int maxValue(int[][] ints) {
    return opt(ints,0,0);
  }

  private int opt(int[][] ints, int i, int ret) {
    if (i>=ints.length) {
      return ret;
    }

    /*不选*/
//    ret = Math.max(opt(ints,i+1),opt(ints,i+1)+ints[i]);
    return i;
  }

  public static void main(String[] args) {
    final MaxValue maxValue = new MaxValue();
    int[][] ints = {
      {1, 4, 5},
      {3, 5, 1},
      {0, 6, 8},
      {4, 7, 4},
      {6, 10, 2},
      {8, 11, 4}
    };
    final int i = maxValue.maxValue(ints);
    System.out.println("i = " + i);
  }
}
