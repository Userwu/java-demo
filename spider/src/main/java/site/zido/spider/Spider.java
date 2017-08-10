package site.zido.spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Spider {
    public static String get(String url){
        StringBuilder result = new StringBuilder();
        try {
            URL origin = new URL(url);
            URLConnection conn = origin.openConnection();
            conn.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = br.readLine()) != null){
                result.append(line).append("\n");
            }
        } catch (MalformedURLException e) {
            System.err.println("网页地址错误");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("链接打开错误");
            e.printStackTrace();
        }
        return result.toString();
    }
}
