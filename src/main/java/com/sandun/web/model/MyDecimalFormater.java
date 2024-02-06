package com.sandun.web.model;

import java.text.DecimalFormat;

public class MyDecimalFormater {

    private static DecimalFormat decimalFormat = new DecimalFormat("#,###.00");

    public static synchronized DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }

    public void setPattern(String pattern) {
        decimalFormat.applyPattern(pattern);
    }

    public static String format(double decimal) {
        return "LKR " + decimalFormat.format(decimal);
    }

    public static String format(long decimal) {
        return "LKR " + decimalFormat.format(decimal);
    }

    public static String formatWithOutLKR(double decimal) {
        return decimalFormat.format(decimal);
    }

    public static String formatWithOutLKR(long decimal) {
        return decimalFormat.format(decimal);
    }
}
