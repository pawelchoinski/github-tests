package org.pwl.framework;

import java.util.Random;

public class StringUtils {
    public static String generateRandomString(int length) {
        int leftLimit = 97; // 'a'
        int rightLimit = 122; // 'z'
        Random random = new Random();
        return random.ints(leftLimit, rightLimit+1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
