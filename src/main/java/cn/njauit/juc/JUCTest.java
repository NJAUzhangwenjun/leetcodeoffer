package cn.njauit.juc;

import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: zhanghub.cn
 * @version: 1.0
 * @date 2020/11/523:23
 */
public class JUCTest {
	private static volatile CountDownLatch countDownLatch = new CountDownLatch(5);
	private static volatile CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		JUCTest t = new JUCTest();
//		t.s();
//		countDownLatch.await();
		t.c();
//		cyclicBarrier.await();
		System.out.println("JUCTest.main CarryOut！");

	}

	@Test
	public void s() {
		
		for (int i = 0; i < 5; i++) {
			new Thread(() -> {
				synchronized (this.getClass()) {
					try { SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
					System.out.println(Thread.currentThread().getName());
					countDownLatch.countDown();
				}
			}, "JUCTest"+i).start();
		}

	}

	public void c() {
		for (int i = 0; i < 5; i++) {
			synchronized (this.getClass()) {
				new Thread(() -> {
					try { SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
					System.out.println(Thread.currentThread().getName());
					try {
						cyclicBarrier.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}, "JUCTest"+i).start();
			}
		}

		HashMap<String, String> map = new HashMap<>();
		map.put("xxx", "xxx");
	}
}
