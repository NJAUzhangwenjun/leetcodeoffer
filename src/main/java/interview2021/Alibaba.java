package interview2021;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 张文军 @Description: @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/3/1118:29
 */
public class Alibaba {

  /**
   * 现有n根木材，要把这n根木材截成相同长度的m段，求可以截取的最大段长 • 木材长度为正整数，截段后的长度也是正整数； • 木材只能截段成长度更短的多段木材（且长度为正整数），不能“拼接”；
   * 比如n=4，木材长度分别为[20,66,8,42]，m=3。 可以截取的最大段长为33。 比如n=3，木材长度分别为[10,5,13]，m=4。 可以截取的最大段长为5。
   * 比如n=1，木材长度分别为[20]，m=20。可以截取的最大段长为1。
   */
  public int woodCut(int[] woods, int k) {

    //    大概思路就是从1遍历到木棍最长的长度，每次遍历的长度作为m，
    //    如果可以将所有木头截出来k个长度为m的木块，则更新最大值，最后输出最大值即可

    int maxWood = Integer.MIN_VALUE;
    // 找到数组中的最大值
    for (int i = 0; i < woods.length; i++) {
      maxWood = Math.max(woods[i], maxWood);
    }
    int max = 0;
    int m = 1;
    while (m <= maxWood) {
      int cnt = 0;
      for (int i = 0; i < woods.length; i++) {
        cnt += woods[i] / m;
      }
      // 如果当前可以截出来超过k段，就更新结果
      if (cnt >= k) max = Math.max(max, m);
      m++;
    }
    return max;
  }

  public static void main(String[] args) throws InterruptedException {
    Alibaba a = new Alibaba();
    int v = 0;
    for (int j = 1; j <= 10000; j++) {
      v += j;
    }
    System.out.println("v1 = " + v);
    a.sum(10000L, 5);
  }

  private static volatile AtomicLong sums = new AtomicLong(0);
  private static final AtomicInteger THREADS = new AtomicInteger(1);
  private static CountDownLatch COUNT;

  public void sum(Long n, int tn) throws InterruptedException {
    COUNT = new CountDownLatch(tn);
    for (int i; (i = THREADS.getAndIncrement()) <= tn; ) {
      int finalI = i;
      new Thread(
              () -> {
                Long sum = 0L;
                for (long j = finalI; j <= n; j += tn) sum += j;
                while (!sums.compareAndSet(sums.get(), sums.get() + sum)) ;
                COUNT.countDown();
              })
          .start();
    }
    COUNT.await();
    System.out.println("v2 = " + sums);
  }
}
