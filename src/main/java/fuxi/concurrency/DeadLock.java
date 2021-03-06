package fuxi.concurrency;

/**
 * @author 张文军 @Description: 死锁 @Company:南京农业大学工学院
 * @version:1.0
 * @date 2021/3/515:20
 */
public class DeadLock implements Runnable {

  private volatile String lockA;
  private volatile String lockB;

  public DeadLock(String lockA, String lockB) {
    this.lockA = lockA;
    this.lockB = lockB;
  }

  @Override
  public void run() {
    synchronized (lockA) {
      System.out.println(lockA + "等待---" + lockB);
      synchronized (lockB) {
        System.out.println("获取到" + lockB);
      }
    }
  }

  public static void main(String[] args) {
    String lockA = "lockA";
    String lockB = "lockB";
    new Thread(new DeadLock(lockA, lockB)).start();
    new Thread(new DeadLock(lockB, lockA)).start();

  }
}
