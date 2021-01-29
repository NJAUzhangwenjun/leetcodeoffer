package com.njauit.sort;

import java.util.Arrays;

/**
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2020/5/2515:07
 */
public class SelectSort {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(sort(new int[] {1, 3, 7, 3, 4, 1, 9, 6})));
  }

  private static int[] sort(int[] ints) {
    for (int i = 0; i < ints.length-1; i++) {
      for (int j = i + 1; j <ints.length ; j++) {
        swap(ints, i, j);
      }
    }
    return ints;
  }

  /**
   * 交换 如果ints [i]> ints [j]，则交换
   *
   * @param ints
   * @param i
   * @param j
   */
  private static void swap(int[] ints, int i, int j) {
    if (ints[i] > ints[j]) {
      int anInt = ints[i];
      ints[i] = ints[j];
      ints[j] = anInt;
    }
  }
}
