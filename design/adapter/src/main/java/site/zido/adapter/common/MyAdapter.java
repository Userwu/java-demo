package site.zido.adapter.common;

public class MyAdapter extends Source implements Targetable {
    public void method2(){
        System.out.println("from adapter method2");
    }

    public static void main(String[] args) {
        Targetable target = new MyAdapter();
        target.method1();
        target.method2();
    }
}
