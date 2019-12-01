package example.multithread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreadParallelTest {

    @Test
    public void threadTest1() {

        List<MyThread> threads = new ArrayList<>();
        threads.add(new MyThread(1));
        threads.add(new MyThread(2));
        threads.add(new MyThread(3));
        threads.add(new MyThread(4));
        threads.add(new MyThread(5));
        threads.add(new MyThread(6));
        threads.add(new MyThread(7));
        threads.add(new MyThread(8));

        for (MyThread thread : threads) {
            thread.start();
        }

        for (MyThread thread : threads) {
            try {
                thread.join();  // waiting from main thread another threads
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void threadTest2() {
        final int COUNT_THREAD = 50;
        List<MyThread> threads = new ArrayList<>(COUNT_THREAD);
        for (int i = 0; i < COUNT_THREAD; i++) {
            threads.add(new MyThread(i));
        }
        for (MyThread thread : threads) {
            thread.start();
        }
        for (MyThread thread : threads) {
            try {
                thread.join();  // waiting from main thread another threads
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
