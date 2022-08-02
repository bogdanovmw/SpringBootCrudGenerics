package com.example.Test.utils;

import java.util.Random;

public class RandomGenerator {
    public static String getRandomString () {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int length = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
