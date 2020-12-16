package edu.gdut.togethertime.utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public class CodingUtils {
    private static final Pattern PATTERN = Pattern.compile("^GDUT:TogetherTime (.){2}");

    public static String encode(String str, String charset) {
        try {
            return new String(str.getBytes(charset));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
