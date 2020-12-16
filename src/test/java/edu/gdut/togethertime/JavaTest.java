package edu.gdut.togethertime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootTest
public class JavaTest {
    @Test
    void testMatcher() {
        Pattern pattern = Pattern.compile("^(ABCD) (test)+ (efgh){1}");
        String str1 = "ABCD test efgh";
        Matcher matcher = pattern.matcher(str1);
        System.out.println(str1 + " : " + matcher.matches());
        str1 = "ABCD efgh";
        matcher = pattern.matcher(str1);
        System.out.println(str1 + " : " + matcher.matches());
        str1 = "ABCD test efgh efgh";
        matcher = pattern.matcher(str1);
        System.out.println(str1 + " : " + matcher.matches());
        str1 = "ABCD testtest efgh ";
        matcher = pattern.matcher(str1);
        System.out.println(str1 + " : " + matcher.matches());
        str1 = "ABCD testtest efgh";
        matcher = pattern.matcher(str1);
        System.out.println(str1 + " : " + matcher.matches());
        str1 = "ABCD test efgh";
        matcher = pattern.matcher(str1);
        System.out.println(str1 + " : " + matcher.matches());
    }
}
