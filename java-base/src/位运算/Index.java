package 位运算;

/**
 * java基础学习-位运算.
 * Date: 2017/1/12 0012
 * Time: 0:08
 *
 * @author <a href="http://userwu.github.io">wuhongxu</a>.
 * @version 1.0.0
 */
public class Index {
    /**
     * 一个数 and 1的结果就是取二进制的最末位，这可以用来判断一个整数的奇偶
     */
    public void and() {
        final long start2 = System.currentTimeMillis();
        StringBuilder str2 = new StringBuilder("");
        for (int i = 0; i < 1000000; i++) {
            if ((i & 1) == 0) {
                str2.append(i).append(" ");
            }
        }
        final long end2 = System.currentTimeMillis();
        System.out.println(str2.toString());
        System.out.println(end2 - start2);


    }

    public void quyu(){
        final long start = System.currentTimeMillis();
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < 1000000; i++) {
            if ((i % 2) == 0) {
                str.append(i).append(" ");
            }
        }
        final long end = System.currentTimeMillis();
        System.out.println(str.toString());
        System.out.println(end - start);
    }
}
