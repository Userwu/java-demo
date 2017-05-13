package thread;
/**
 * some method about thread
 * 继承Thread方法实现的线程
 */

public class MyThread extends Thread{
  private final Object lock = new Object();
  public static void main(String[] args){
    Thread th = new MyThread();
    th.start();
  }
  @Override
  public void run(){
    synchronized (lock) {
      System.out.println("我的世界");
    }
  }
}
