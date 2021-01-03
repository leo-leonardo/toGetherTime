package edu.gdut.togethertime.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    private static final List<String> CHARS = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H"
            , "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
    private static final List<String> NUMBERS = Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9");

    public static Long randomId() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<6; i++) {
            sb.append(NUMBERS.get(random.nextInt(10)));
        }
        return Long.valueOf(sb.toString());
    }

    public static String randomString(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(CHARS.get(random.nextInt(CHARS.size())));
        }
        return stringBuilder.toString();
    }
}
