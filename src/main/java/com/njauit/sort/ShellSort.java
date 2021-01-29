package com.njauit.sort;

import java.util.Arrays;

/**
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2020/5/2517:29
 */
public class ShellSort {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(shellSort(new int[] {1, 3, 7, 3, 4, 1, 9, 6})));
  }

  private static int[] shellSort(int[] ints) {
    for (int gep = ints.length / 2; gep > 0; gep /= 2) {
      for (int i = gep; i < ints.length; i++) {
        for (int j = i; j > gep - 1; j -= gep) {
          swap(ints, j - gep, j);
        }
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
