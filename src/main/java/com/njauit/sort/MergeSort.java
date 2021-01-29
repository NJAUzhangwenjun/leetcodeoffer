package com.njauit.sort;

import java.util.Arrays;

/**
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2020/5/2517:29
 */
public class MergeSort {
  public static void main(String args[]) throws Exception {
    /*
    Scanner in = new Scanner(System.in);
    int[] a = new int[Integer.parseInt(in.next())];
    for (int i = 0; i < a.length; i++) {
      a[i] = Integer.parseInt(in.next());
    }*/
    System.out.println(Arrays.toString(mergeSort(new int[] {1, 3, 7, 3, 4, 1, 9, 6})));
  }

  private static int[] mergeSort(int[] ints) {
    mergeSort(ints, 0, ints.length - 1);
    return ints;
  }

  private static void mergeSort(int[] a, int low, int hight) {
    // 如果已经分割到单个元素了就直接结束分割
    if (low >= hight) return;

    int mid = (hight + low) >> 1;
    mergeSort(a, low, mid);
    mergeSort(a, mid + 1, hight);
    // 合并
    merge(a, low, mid, hight);
  }

  /**
   * 合并一个分前后有序的数组
   * 如 ：   [6, 7, 9, 1, 3, 4]
   * 合并后：[6, 7, 9, 1, 3, 4]
   * @param a 前后有序数组
   * @param low 开始位置
   * @param mid 中间不同序位置
   * @param hight 结束位置
   */
  private static void merge(int[] a, int low, int mid, int hight) {
    int[] ints = new int[hight - low + 1];
    int l = low;
    int h = mid + 1;
    int indexInts = 0;
    while (l <= mid && h <= hight) ints[indexInts++] = a[l] <= a[h] ? a[l++] : a[h++];
    while (l <= mid) ints[indexInts++] = a[l++];
    while (h <= hight) ints[indexInts++] = a[h++];
    System.arraycopy(ints, 0, a, low, ints.length);
  }
}
