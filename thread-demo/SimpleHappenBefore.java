/**
 * 一个简单的展示Happen-Before的例子.
 * 这里有两个共享变量:a和flag,初始值分别为0和false.在ThreadA中先给     a=1,然后flag=true.
 * 如果按照有序的话,那么在ThreadB中如果if(flag)成功的话,则应该a=1,而a=a*1之后a仍然为1,下方的if(a==0)应该永远不会为
 * 真,永远不会打印.
 * 但实际情况是:在试验100次的情况下会出现0次或几次的打印结果,而试验1000次结果更明显,有十几次打印.
 */
public class SimpleHappenBefore {
  static volatile int x = 0, y = 0;
  static volatile int a = 0, b = 0;
  
  public static void main(String[] args) throws InterruptedException {
      for(int i = 0; i < 100000; i++){
        Thread one = new Thread(new Runnable() {
            public void run() {
                a = 1;
                x = b;
            }
        });
    
        Thread other = new Thread(new Runnable() {
            public void run() {
                b = 1;
                y = a;
            }
        });
        one.start();other.start();
        one.join();other.join();

        if(x == 0 && y == 0){

        System.out.println("第"+i+"次 输出(" + x + "," + y + ")");
          return;
        }
        x = 0; y = 0;
        a = 0; b = 0; 
      }
  }
}