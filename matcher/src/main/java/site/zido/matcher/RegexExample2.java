package site.zido.matcher;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample2 {

    public static void main(String[] args) {
        String pattern = "do[a-z]+?(es){2,}?";
        Pattern compile = Pattern.compile(pattern);
        Matcher matcher = compile.matcher("dodwadwesesesdodawdfhghfgdaweseses");
        int count = 0;
        while (matcher.find()){
            count++;
            System.out.println("start : " + matcher.start());
            System.out.println("end : "+ matcher.end());
            System.out.println("content : "+ matcher.group());
            StringBuffer sb = new StringBuffer();
            matcher.appendReplacement(sb,"does");
            System.out.println("replace:"+sb.toString());
        }
        System.out.println(count);
        System.out.println();
    }
}
