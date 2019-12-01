package example.multithread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorParallelTest {

    @Test
    public void executorTest() {

        final int COUNT_PARALLEL_THREADS = 5;
        final int COUNT_ALL_THREADS = 8;

        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_PARALLEL_THREADS);
        CountDownLatch latch = new CountDownLatch(COUNT_ALL_THREADS);

        executorService.execute(new MyThread(1, latch));
        executorService.execute(new MyThread(2, latch));
        executorService.execute(new MyThread(3, latch));
        executorService.execute(new MyThread(4, latch));
        executorService.execute(new MyThread(5, latch));
        executorService.execute(new MyThread(6, latch));
        executorService.execute(new MyThread(7, latch));
        executorService.execute(new MyThread(8, latch));

        try {
            latch.await(30, TimeUnit.SECONDS); // waiting from main thread another threads (while count != 0), or interrupt after 30 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown(); // interrupt all threads
    }

    private static class MyThread extends Thread {
        private CountDownLatch latch;
        private int count;

        MyThread(int count, CountDownLatch latch) {
            this.count = count;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " [START] " + count);
            try {
                // do something ...
                Thread.sleep(3000);

                latch.countDown();  // count--
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " [END] " + count);
        }
    }
}
