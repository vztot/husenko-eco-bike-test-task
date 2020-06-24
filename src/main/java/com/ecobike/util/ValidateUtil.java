package com.ecobike.util;

public class ValidateUtil {
    public static boolean validateStringIsNumber(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean validateStringIsBoolean(String string) {
        try {
            Boolean.parseBoolean(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
