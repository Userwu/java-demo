package site.zido.file;

public class FileMain {
    public static void main(String[] args) {
        //当前工作目录
        System.out.println(System.getProperty("user.dir"));
        //设置工作目录
        System.setProperty("user.dir","/home");
        System.out.println(System.getProperty("user.dir"));


    }
}
