/**
 * NoVisibility
 */
public class NoVisibility {
  private static boolean ready;
  private static int number;

  private static class MyThread extends Thread{
    @Override
    public void run(){
      while(!ready){
        Thread.yield();
      }
      if(number != 42)
        System.out.println(number);
    }
  }

  public static void main(String[] args) throws InterruptedException {
    for(int i = 0 ; i < 100000; i++){
      Thread my = new MyThread();
      my.start();
      number = 42;
      ready = true;
      my.join();
    }
  }
}