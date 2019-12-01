package example.multithread;

import com.mycila.junit.concurrent.ConcurrentJunitRunner;
import com.mycila.junit.concurrent.Concurrency;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(ConcurrentJunitRunner.class)
@Concurrency(5)
public class ConcurrentJUnitTest2 {

    @Test public void test0() throws Throwable { printAndWait(); }
    @Test public void test1() throws Throwable { printAndWait(); }
    @Test public void test2() throws Throwable { printAndWait(); }
    @Test public void test3() throws Throwable { printAndWait(); }
    @Test public void test4() throws Throwable { printAndWait(); }
    @Test public void test5() throws Throwable { printAndWait(); }
    @Test public void test6() throws Throwable { printAndWait(); }
    @Test public void test7() throws Throwable { printAndWait(); }
    @Test public void test8() throws Throwable { printAndWait(); }
    @Test public void test9() throws Throwable { printAndWait(); }

    private void printAndWait() throws Throwable {
        System.out.println(Thread.currentThread().getName() + " [START] " + getClass().getName() + " " + new Throwable().getStackTrace()[1].getMethodName());
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " [END] " + getClass().getName() + " " + new Throwable().getStackTrace()[1].getMethodName());
    }
}
