package site.zido.spider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyzer {
    public static String findLink(String origin,String word){
        String pattern = "<a [\\w\"=\\s/#]+?>" + word + "</a>";
        String pattern2 = "href=\"(.+?)\"";
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(origin);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
        return "";
    }
}
