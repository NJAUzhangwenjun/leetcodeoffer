package fuxi.concurrency;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 生产者消费者模式
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/7/1913:08
 */
class ProducerConsumer {
	public void prod() {
		System.out.println("prod");
	}

	public void consume() {
		System.out.println("consume");
	}
}

/**
 * @author user
 */
public class ProducerConsumerTest {
	/**
	 * 需要注意的是：如果需要有序执行，就需要设置一个标志位，并且要循环检测标志位的变化情况；
	 */
	private static Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private AtomicBoolean flag = new AtomicBoolean(true);


	/**
	 * 使用Synchronized 方式；
	 *
	 * 注意：需要在调用wait()或者notify()之前，必须使用synchronized语义绑定住被wait/notify的对象
	 * 	（即：被Synchronized绑定的对象和调用 notify()/notifyAll()的对象是同一个）
	 */
	public void ProductCustomerTest() {
		new Thread(() -> {
			// TODO:
			ProducerConsumer producerConsumer = new ProducerConsumer();
			for (int i = 0; i < 20; i++) {
				synchronized (flag) {
					while (!flag.get()) {
						try {
							flag.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					producerConsumer.prod();
					flag.set(!flag.get());
					flag.notifyAll();
				}
			}
		}, "ProducerConsumerTest-1").start();

		new Thread(() -> {
			// TODO:
			ProducerConsumer producerConsumer = new ProducerConsumer();
			for (int i = 0; i < 20; i++) {
				synchronized (flag) {
					while (flag.get()) {
						try {
							flag.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					producerConsumer.consume();
					flag.set(!flag.get());
					flag.notifyAll();
				}
			}
		}, "ProducerConsumerTest-2").start();

	}

	/**
	 * 使用Look和Condition ；
	 */
	public void conditionTest() {
		new Thread(() -> {
			// TODO:
			ProducerConsumer producerConsumer = new ProducerConsumer();
			for (int i = 0; i < 20; i++) {
				lock.lock();
				try {
					while (!flag.get()) {
						try {
							condition.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					producerConsumer.prod();
					flag.set(!flag.get());
					condition.signalAll();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}

			}
		}, "ProducerConsumerTest-1").start();


		new Thread(() -> {
			// TODO:
			ProducerConsumer producerConsumer = new ProducerConsumer();
			for (int i = 0; i < 20; i++) {
				lock.lock();
				try {
					while (flag.get()) {
						try {
							condition.await();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					producerConsumer.consume();
					flag.set(!flag.get());
					condition.signalAll();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}

			}
		}, "ProducerConsumerTest-2").start();

	}

	public static void main(String[] args) {
		ProducerConsumerTest producerConsumerTest = new ProducerConsumerTest();
		//producerConsumerTest.ProductCustomerTest();
		producerConsumerTest.conditionTest();
	}


}
