package edu.gdut.togethertime.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    private static final List<String> CHARS = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H"
            , "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

    public static Long randomId() {
        Random random = new Random();
        return random.nextLong();
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
