package site.zido.matcher;

import java.util.regex.Pattern;

public class RegexExample1 {
    public static void main(String[] args) {
        String content = "I an zido from zidoshare.site";
        String pattern = ".*zidoshare.*";

        boolean isMatch = Pattern.matches(pattern,content);

        System.out.println(isMatch);
    }
}
