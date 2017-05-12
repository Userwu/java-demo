package thread;
/**
 * some method about thread
 */

public class MyThread extends Thread{
  private final Object lock = new Object();
  public static void main(String[] args){
    Thread th = new Thread(new MyThread());
    th.start();
  }
  @Override
  public void run(){
    synchronized (lock) {
      System.out.println("我的世界");
    }
  }
}
