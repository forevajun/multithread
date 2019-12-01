package example.multithread;

import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.anarsoft.vmlens.concurrent.junit.ThreadCount;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ConcurrentTestRunner.class)
public class ConcurrentJUnitTest {

    private final static int THREAD_COUNT = 8;

    @Test
    @ThreadCount(THREAD_COUNT)
    public void test() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());;
    }

}
