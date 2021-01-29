package interviews;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/9/1615:27
 */
public class Alibaba {
	public static void main(String[] args) {
		SequentialPrintNumber.sequentialPrinting();
		RedEnvelope.redEnvelopes(100, 10);
	}
}

class SequentialPrintNumber {
	/**
	 * // 题目：实现三个线程，线程A负责打印1、4、7。。。100，线程B负责打印2，5，8。。。98，
	 * // 线程C负责打印3、6、9。。。99，保证整体的输出顺序是1、2、3、4、5、6。。。100
	 *
	 * */
	private static volatile int Who = 1;
	private static ReentrantLock lock = new ReentrantLock();
	private static final Condition conditionA = lock.newCondition();
	private static final Condition conditionB = lock.newCondition();
	private static final Condition conditionC = lock.newCondition();
	private static final int terminationCondition = 100;

	public static void sequentialPrinting() {

		Thread threadA = new Thread() {
			@Override
			public void run() {

				for (int i = 1; i <= terminationCondition; i += 3) {
					lock.lock();
					try {
						while (Who != 1) {
							conditionA.await();
						}
						System.out.print(i + " ");
						Who = 2;

						conditionB.signalAll();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
				}
			}
		};

		Thread threadB = new Thread() {
			@Override
			public void run() {
				for (int i = 2; i <= terminationCondition; i += 3) {
					lock.lock();
					try {
						while (Who != 2) {
							conditionB.await();
						}
						System.out.print(i + " ");
						Who = 3;
						conditionC.signalAll();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
				}
			}
		};
		Thread threadC = new Thread() {
			@Override
			public void run() {
				for (int i = 3; i <= terminationCondition; i += 3) {
					lock.lock();
					try {
						while (Who != 3) {
							conditionC.await();
						}
						System.out.print(i + " ");
						Who = 1;
						conditionA.signalAll();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} finally {
						lock.unlock();
					}
				}
			}
		};
		threadA.start();
		threadB.start();
		threadC.start();
	}

}

class RedEnvelope {
	/**
	 * // 题目：请编写一个红包随机算法。
	 * // 给定一定的金额，一定的人数，保证每个人都能随机获得一定的金额，红包必须全部分完。
	 * // 比如100元的红包，10个人抢，每人分得一些金额。约束条件为，最佳手气金额不能超过最大金额的90%。
	 * // 请给出java代码
	 */

	public static void redEnvelopes(double totalMoney, int count) {
		double money = 0;
		Random random = new Random();
		while (count > 1) {
			//最佳手气金额不能超过最大金额的90%
			double max = totalMoney * 0.9;
			double r = random.nextDouble();
			money = r * max;
			//每人分得一些金额
			if (money <= 0) {
				continue;
			} else {
				money = Math.floor(money * 100) / 100;
			}
			System.out.println(money + " ");
			count--;
			totalMoney -= money;
		}

	}

}


