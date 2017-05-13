package thread;
/**
 * 实现Runnable借口,并实现该接口的run方法<br/>
 * 创建一个Thread对象,用实现的Runnable借口的对象
 * 作为参数实例化Thread对象<br.>
 * 调用此对象的start方法<br/>
 */
public class RunThread implements Runnable{
  @Override
  public void run(){
    System.out.println("run thread");
  }
  public static void main(String[] args){
    Thread th = new Thread(new RunThread());
    th.start();
  }
}
