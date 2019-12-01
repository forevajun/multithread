package example.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {

        final int COUNT_PARALLEL_THREADS = 5;

        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_PARALLEL_THREADS);

        executorService.execute(new MyThread(1));
        executorService.execute(new MyThread(2));
        executorService.execute(new MyThread(3));
        executorService.execute(new MyThread(4));
        executorService.execute(new MyThread(5));
        executorService.execute(new MyThread(6));
        executorService.execute(new MyThread(7));
        executorService.execute(new MyThread(8));

        executorService.shutdown(); // interrupt all threads
    }

    private static class MyThread extends Thread {
        private int count;

        MyThread(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " [START] " + count);
            try {
                // do something ...
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " [END] " + count);
        }
    }
}
