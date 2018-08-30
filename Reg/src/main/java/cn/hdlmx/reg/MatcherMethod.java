package cn.hdlmx.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherMethod {
    public static int groupCount(String target) {

        String reg = "(\\\\d{4})-((\\\\d{2})-(\\\\d{2}))";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(target);
        System.out.println(matcher.groupCount());
        if(matcher.find()){
            //必须要有这句
            System.out.printf("\nmatcher.group(0) value:%s", matcher.group(0));
            System.out.printf("\nmatcher.group(1) value:%s", matcher.group(1));
            System.out.printf("\nmatcher.group(2) value:%s", matcher.group(2));
            System.out.printf("\nmatcher.group(3) value:%s", matcher.group(3));
            System.out.printf("\nmatcher.group(4) value:%s", matcher.group(4));
        }else{
            System.out.println("no match!");
        }

        return matcher.groupCount();
    }
}
