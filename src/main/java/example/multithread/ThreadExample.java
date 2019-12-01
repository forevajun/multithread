package example.multithread;

import java.util.ArrayList;
import java.util.List;

public class ThreadExample {

    public static void main(String[] args) {

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
