package cn.hdlmx.reg;

import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {


    @Test
    public void testMatcher() {
        String numer = "2017-04-25";
        Assert.assertEquals(4, MatcherMethod.groupCount(numer));
    }

    @Test
    public void test() {
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }
    }

    @Test
    public void TestD() {
        String target = "s22211handonghanxaa211";//false
        Assert.assertFalse(!RegModel.d(target));
    }

    @Test
    public void emailRegTest() {
        String target = "123456@vip.qq.com";
        Assert.assertFalse(!RegModel.emailReg(target));
    }

    @Test
    public void phoenNumberTest() {
        String target = "18721500549";
        Assert.assertFalse(!RegModel.phoenNumberReg(target));
    }

    @Test
    public void StringEs() {
        String totalStr = "~`<>?^&*()you@##%$$#^%^h^&&*&*()<>?ai@#@$~~`_+|dong?><:";
        String res="youhaidong";
        Assert.assertEquals(res,RegModel.StringEs(totalStr));

    }

}
