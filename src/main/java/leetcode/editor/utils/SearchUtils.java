package leetcode.editor.utils;

/**
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/1/311:32
 */
public class SearchUtils {
  private static int index = Integer.MAX_VALUE;

  /**
   * 二分法查找
   *
   * @param arr 数组
   * @param n 查找元素
   * @return 元素index；如果为 Integer.MAX_VALUE,则为空
   */
  public static int search(int[] arr, int n) {
    search(arr, 0, arr.length - 1, n);
    return index;
  }

  private static void search(int[] arr, int l, int r, int n) {
    if (l > r) {
      return;
    }
    final int mid = (l + r) / 2;
    if (arr[mid] == n) {
      index = mid;
      return;
    }
    if (arr[mid] > n) search(arr, l, mid - 1, n);
    if (arr[mid] < n) search(arr, mid + 1, r, n);
  }
}
