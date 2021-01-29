package com.njauit.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2020/5/2517:29
 */
public class CountingSort {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(countingSort(new int[] {1, 3, 7, 3, 4, 1, 9, 6}, 0, 10)));
  }

  /**
   * 计数排序
   *
   * @param ints 待排序数组
   * @param min 范围->数组中最小值
   * @param max 范围->数组中过最大值
   */
  private static int[] countingSort(int[] ints, int min, int max) {

    int[] count = new int[max - min + 1];
    int[] newInts = new int[ints.length];

    for (int i = 0; i < ints.length; i++) count[ints[i]] += 1;

    for (int i = 0, index = 0; i < count.length; i++) {
      int ct = count[i];
      while (ct-- > 0) newInts[index++] = i;
    }
    System.arraycopy(newInts, 0, ints, 0, ints.length);
    return ints;
  }

  public void radixSort(int[] array) {

    int max = array[0];
    for (int i = 0; i < array.length; i++) { // 找到数组中的最大值
      if (array[i] > max) {
        max = array[i];
      }
    }

    int keysNum = 0; // 关键字的个数，我们使用个位、十位、百位...当做关键字，所以关键字的个数就是最大值的位数
    while (max > 0) {
      max /= 10;
      keysNum++;
    }
    List<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < 10; i++) { // 每位可能的数字为0~9，所以设置10个桶
      buckets.add(new ArrayList<Integer>()); // 桶由ArrayList<Integer>构成
    }

    for (int i = 0; i < keysNum; i++) { // 由最次关键字开始，依次按照关键字进行分配
      for (int j = 0; j < array.length; j++) { // 扫描所有数组元素，将元素分配到对应的桶中
        // 取出该元素对应第i+1位上的数字，比如258，现在要取出十位上的数字，258%100=58,58/10=5
        int key = array[j] % (int) Math.pow(10, i + 1) / (int) Math.pow(10, i);
        buckets.get(key).add(array[j]); // 将该元素放入关键字为key的桶中
      }
      // 分配完之后，将桶中的元素依次复制回数组
      int counter = 0; // 元素计数器
      for (int j = 0; j < 10; j++) {
        ArrayList<Integer> bucket = buckets.get(j); // 关键字为j的桶
        while (bucket.size() > 0) {
          array[counter++] = bucket.remove(0); // 将桶中的第一个元素复制到数组，并移除
        }
      }
    }
  }
}
