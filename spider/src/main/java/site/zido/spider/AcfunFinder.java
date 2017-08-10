package site.zido.spider;

public class AcfunFinder {
    private static String AcfunURL = "http://www.acfun.cn";
    public static void main(String[] args) {
        String s = Spider.get(AcfunURL);
//        System.out.println(s);
        Analyzer.findLink(s,"文章");
    }
}
