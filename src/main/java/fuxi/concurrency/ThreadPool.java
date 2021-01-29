package fuxi.concurrency;

import org.junit.Test;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/7/1814:58
 */
public class ThreadPool {

	private static volatile ExecutorService threadPool;
	/**
	 * 线程池：
	 *
	 * 降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
	 * 提高响应速度。当任务到达时，任务可以不需要的等到线程创建就能立即执行。
	 * 提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，
	 * 使用线程池可以进行统一的分配，调优和监控。
	 *
	 */


	/**
	 * Executors 返回线程池对象的弊端如下：
	 *
	 * FixedThreadPool 和 SingleThreadExecutor ： 允许请求的队列长度为 Integer.MAX_VALUE ，
	 * 可能堆积大量的请求，从而导致OOM。
	 * CachedThreadPool 和 ScheduledThreadPool ： 允许创建的线程数量为 Integer.MAX_VALUE ，
	 * 可能会创建大量线程，从而导致OOM。
	 *
	 * 正确的做法是通过 ThreadPoolExecutor 的方式手动创建线程池
	 */


	/**
	 * 创建单例模式的 线程池
	 * @return
	 */
	public static ExecutorService getThreadPool() {
		if (ThreadPool.threadPool == null) {
			synchronized (ThreadPool.class) {
				if (ThreadPool.threadPool == null) {
					ThreadPool.threadPool = new ThreadPoolExecutor(1, 2, 0, SECONDS,
							new LinkedBlockingQueue<Runnable>(100), new ThreadPoolExecutor.AbortPolicy());
				}
			}
		}
		return ThreadPool.threadPool;
	}


	@Test
	public void FutureTest() throws ExecutionException, InterruptedException {
		Callable<Integer> callable = new Callable<Integer>() {
			/**
			 * Computes a result, or throws an exception if unable to do so.
			 *
			 * @return computed result
			 * @throws Exception if unable to compute a result
			 */
			@Override
			public Integer call() throws Exception {
				return 123123;
			}
		};

		ExecutorService pool = ThreadPool.getThreadPool();

		Future<String> future = pool.submit(() -> {
			try { SECONDS.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
			return "我已经执行完了";
		});
		System.out.println("下面将要等待：？ ");
		System.out.println(future.get());
		System.out.println("上面执行完了吗");

		pool.execute(() -> System.out.println("I have no thing to return !"));


	}


	@Test
	public void ScheduledThreadPoolTest() {//预定线程，最大线程数是：Integer.MAX_VALUE
		ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
		service.scheduleAtFixedRate(() -> System.out.println("Scheduled is comming "), 3, 2, SECONDS);
		for (; ; ) {

		}
	}


	@Test
	public void singletonThreadPoolTest() {

		//多次获取线程池，检验是否是单例
		int numberOfTimesTheThreadPoolWasCreated = 10;
		//创建多个线程，并发执行，检验线程池
		int numberOfThreadsCreated = 10;

		while (numberOfTimesTheThreadPoolWasCreated-- > 0) {
			ExecutorService pool = getThreadPool();
			System.out.println("pool = " + pool);
			while (numberOfThreadsCreated-- > 0) {
				pool.execute(() -> {
					synchronized (this) {
						System.out.println("I a is Runnable: " + Thread.currentThread().getName());
						try { SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
					}
				});
			}
		}

		//防止@Test体检触发 System.exit() 而关闭虚拟机
		for (; ; ) {
		}
	}


	/**
	 * Runnable 和 Callable 接口
	 */
	@Test
	public void runnableCallable() {
		Runnable runnable = () -> System.out.println(" I an is Runnable interface");
		Callable callable = () -> "I an is Callable interface";
	}
}
