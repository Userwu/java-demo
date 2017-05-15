package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by zido on 17-5-13.
 * <p>
 * Date:17-5-13 下午2:14
 *
 * @author <a href="zido.site">zido</a>
 * @version 1.0.0
 */
public class CallThread implements Callable<Integer> {
  public static final Object lock = new Object();
  @Override
  public Integer call() throws Exception {
    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + " = " + i);
      if(i == 60){
        synchronized (lock){
          lock.wait();
        }
      }
    }

    return 1 + 1;
  }

  public static void main(String[] args) {
    Callable<Integer> ca = new CallThread();
    FutureTask<Integer> ft = new FutureTask<>(ca);
    Thread thread = null;
    for (int i = 0; i < 100; i++) {
      System.out.println(Thread.currentThread().getName() + " " + i);
      if (i == 30) {
        thread = new Thread(ft);
        thread.start();
      }
    }
    assert thread != null;
    synchronized (lock){
      lock.notify();
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("-------------主线程执行完毕----------");
    try {
      int sum = ft.get();//通过ft.get()方法获取子线程call()方法的返回值时，当子线程此方法还未执行完毕，ft.get()方法会一直阻塞，直到call()方法执行完毕才能取到返回值。
      System.out.println("sum = " + sum);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }
}
