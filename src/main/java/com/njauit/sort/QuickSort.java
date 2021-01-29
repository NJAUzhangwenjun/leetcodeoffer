package com.njauit.sort;

import java.util.Arrays;

/**
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2020/5/2517:29
 */
public class QuickSort {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(quickSort(new int[] {4,6})));
  }

  private static int[] quickSort(int[] ints) {
    quickSort(ints, 0, ints.length - 1);
    return ints;
  }

  private static void quickSort(int[] ints, int low, int high) {
    if (low >= high) return;

    int pivot = partition(ints, low, high);

    quickSort(ints, low, pivot - 1);
    quickSort(ints, pivot + 1, high);
  }

  private static int partition(int[] ints, int low, int high) {
    int l = low;
    int h = high - 1;
    int pivot = ints[high];

    while (l <= h) {
      while (l <= h && ints[l] <= pivot) l++;
      while (l <= h && ints[h] > pivot) h--;
      if (l < h) {
        swap(ints, l, h);
        l++;
        h--;
      }
    }
    swap(ints, l, high);

    return l;
  }

  private static void swap(int[] ints, int l, int h) {
    int temp = ints[l];
    ints[l] = ints[h];
    ints[h] = temp;
  }
}
