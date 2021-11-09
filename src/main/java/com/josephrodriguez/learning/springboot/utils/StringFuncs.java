package com.josephrodriguez.learning.springboot.utils;

public class StringFuncs {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotNullOrEmpty(String str) {
        return !isNullOrEmpty(str);
    }

    public static String thenIfEmpty(String str, String value) {
        return isNotNullOrEmpty(str) ? str : value;
    }
}
