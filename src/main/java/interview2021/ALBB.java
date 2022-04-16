package interview2021;

import java.util.Scanner;

/**
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/3/2515:04
 */
public class ALBB {
  public static int minCount = Integer.MAX_VALUE;

  static void dfs(int count, int[] a) {
    // 递归出口
    Boolean flag = true;
    for (int i = 0; i < 10; i++)
      if (a[i] > 0) {
        flag = false;
        break;
      }
    if (flag) {
      if (count < minCount) minCount = count;
      return;
    }

    if (count + 1 >= minCount) return; // 剪枝
    // 优先出顺子
    for (int i = 0; i < 6; i++) {
      if (a[i] > 0 && a[i + 1] > 0 && a[i + 2] > 0 && a[i + 3] > 0 && a[i + 4] > 0) {
        for (int j = 0; j < 5; j++) a[i + j]--;
        dfs(count + 1, a);
        for (int j = 0; j < 5; j++) a[i + j]++;
      }
    }
    // 再考虑出对子
    for (int i = 0; i < 10; i++) {
      if (a[i] >= 2) {
        a[i] -= 2;
        dfs(count + 1, a);
        a[i] += 2;
      }
    }
    // 出一张牌
    for (int i = 0; i < 10; i++) {
      if (a[i] >= 1) {
        a[i]--;
        dfs(count + 1, a);
        a[i]++;
      }
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String text = scanner.nextLine();
    String[] s = text.split(" ");
    int[] a = new int[s.length];
    for (int i = 0; i < s.length; i++) {
      a[i] = Integer.parseInt(s[i]);
    }
    //    int[] a = new int[] {1, 1, 1, 2, 2, 2, 2, 2, 1, 1};
    dfs(0, a);
    System.out.println("minCount = " + minCount);
  }
}
