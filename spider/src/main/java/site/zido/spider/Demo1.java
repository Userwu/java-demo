package site.zido.spider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 爬去百度首页的某些信息
 */
public class Demo1 {
    public static void main(String[] args) {
        String host = "http://www.acfun.cn/";
        StringBuffer result = new StringBuffer();
        BufferedReader br = null;
        String pattern = "\"";
        Pattern p = Pattern.compile(pattern);
        try{
            URL url = new URL(host);
            URLConnection connection = url.openConnection();


            connection.connect();
            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line ;
            while ((line = br.readLine())!= null) {
                result.append(line).append("\n");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matcher matcher = p.matcher(result);
        while (matcher.find()){
            System.out.println(matcher.start());
            System.out.println(matcher.end());
        }
        System.out.println(result);
    }
}
