package com.sandeep.github01.CommonUtil;

public class CommonUtil {
    public static boolean isValidString(String s) {
        return (s != null && !s.trim().isEmpty() && !s.equalsIgnoreCase("null"));
    }
}
