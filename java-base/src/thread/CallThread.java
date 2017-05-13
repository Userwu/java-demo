package thread;

import java.util.concurrent.Callable;

/**
 * Created by zido on 17-5-13.
 * <p>
 * Date:17-5-13 下午2:14
 *
 * @author <a href="zido.site">zido</a>
 * @version 1.0.0
 */
public class CallThread implements Callable<Integer> {
  @Override
  public Integer call() throws Exception {
    return 1+1;
  }

  public static void main(String[] args) {
    Callable ca = new CallThread();

  }
}
