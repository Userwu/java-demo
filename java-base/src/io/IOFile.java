package io;

import java.io.*;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * java基础学习-io-文件篇.
 * Date: 2017/1/12 0012
 * Time: 0:33
 *
 * @author <a href="http://userwu.github.io">wuhongxu</a>.
 * @version 1.0.0
 */
public class IOFile {
    public void copy() {
        try {
            final FileInputStream fis = new FileInputStream(new File("io/iofile/one.txt"));
            final FileOutputStream fos = new FileOutputStream(new File("io/iofile/two.txt"));
            final byte[] bytes = new byte[1024];
            int read = 0;
            while ((read = fis.read(bytes)) != -1) {
                System.out.println(bytes[0]);
                fos.write(bytes, 0, read);
            }
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void useReadForCopy() {
        try (FileReader fr = new FileReader(new File("io/iofile/one.txt"));
             FileWriter fw = new FileWriter(new File("io/iofile/three.txt"))) {
            final char[] chars = new char[1024];
            int read = 0;
            while ((read = fr.read(chars)) != -1) {
                System.out.println(chars[0]);
                fw.write(chars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 这是组合流的使用方式之一，将多个流进行组合，从而达到只取你想要的数据的效果
     */
    public void useBuffer() {
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("io/iofile/one.txt")))) {
            final int i = dis.readInt();
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过此方法可实现复制时过滤某个字符
     */
    public void usePushBack() {
        char[] cs = new char[50000];
        final File file = new File("io/iofile/four.txt");
        if (!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        int i = 0;
        try (PushbackInputStream pis = new PushbackInputStream(new BufferedInputStream(new FileInputStream("io/iofile/one.txt")));
             FileWriter fw = new FileWriter(file/*,true*/)) {
            while (true) {
                final int read = pis.read();
                if (read == -1) {
                    break;
                }
                if (read == 'd') {
                    System.out.print((char) read);
                    pis.unread(read);
                    pis.skip(1);
                    continue;
                }
                cs[i++] = (char) read;
                System.out.println();
            }
            fw.write(cs,0,i);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userScanner(){
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            final String s = scanner.nextLine();
            if("q".equals(s))
                break;
            System.out.println(s);
        }
    }
}

class TestFileTest{
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("one", 1000, 1996, 8, 1);
        staff[1] = new Employee("two", 1000, 1996, 8, 1);
        staff[2] = new Employee("three", 1000, 1996, 8, 1);

        try(PrintWriter out = new PrintWriter("io/iofile/employee.dat","UTF-8")){
            TestFileTest.writeData(staff,out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void writeData(Employee[] employees,PrintWriter out){
        out.println(employees.length);
        for (Employee employee : employees) {
            writeEmployee(out,employee);
        }
    }

    private static void writeEmployee(PrintWriter out, Employee employee) {
        GregorianCalendar calendar = new GregorianCalendar();

    }
}

class Employee{
    private String name;
    private int money;
    private int year;
    private int mouth;
    private int day;

    public Employee(String name, int money, int year, int mouth, int day) {
        this.name = name;
        this.money = money;
        this.year = year;
        this.mouth = mouth;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMouth() {
        return mouth;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}

