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
        return string != null && (string.equalsIgnoreCase("true")
                || string.equalsIgnoreCase("false"));
    }

    public static boolean validateStringNotEmpty(String string) {
        return string != null && !string.equals("");
    }
}
