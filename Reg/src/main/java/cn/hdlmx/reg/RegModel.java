package cn.hdlmx.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegModel {

    public static boolean d(String target) {
        String reg = "^\\D\\d{2,}(handong)*(han|mu)[xyz][^nmp][a-z][0-9]\\d+$";
        boolean isMatch = Pattern.matches(reg, target);
        return isMatch;
    }

    //邮箱的正则匹配
    /*
     * 例如：
     * handong_11@vip.com.cn
     * 开头只能是数字或者字母
     * 中间可以包含_或者.
     * 结尾可以有多个.com，.cn这种
     * */
    public static boolean emailReg(String target) {
        String reg = "^[a-zA-Z0-9]+([_.][a-zA-Z0-9])*@\\w+(.\\w+)+$";
        boolean isMatch = Pattern.matches(reg, target);
        return isMatch;
    }

    /*
     *手机号码的正则匹配
     *
     * */
    public static boolean phoenNumberReg(String target) {
        String reg = "^1[345789]\\d{9}";
        boolean isMatch = Pattern.matches(reg, target);
        return isMatch;
    }

    /*
     * 增强型的手机号码验证
     * 带有运营商固定号段的
     * */
    public static boolean phoenNubmberRegimproveD(String target) {
        String reg = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
        boolean isMatch = Pattern.matches(reg, target);
        return isMatch;
    }

    public static String StringEs(String target) {
        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？_]";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(target);
        boolean isMatch = mat.matches();
        System.out.println(isMatch);
        return mat.replaceAll("").trim();
    }
}
