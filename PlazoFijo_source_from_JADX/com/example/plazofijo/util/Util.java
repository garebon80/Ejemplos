package com.example.plazofijo.util;

import java.text.DecimalFormat;

public class Util {
    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        long factor = (long) Math.pow(10.0d, (double) places);
        return ((double) Math.round(value * ((double) factor))) / ((double) factor);
    }

    public static String doubleFormat(Double number) {
        return new DecimalFormat("#,###").format(number);
    }
}
