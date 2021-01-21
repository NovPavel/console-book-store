package com.company.console.validator;

import java.util.regex.Pattern;

public class AddressValidator {
    public static boolean validStreet(String street) {
        Pattern compile = Pattern.compile("\\w\\D+");
        return compile.matcher(street).matches() && street.length() > 2;
    }

    public static boolean validHome(int home) {
        return home > 0;
    }

    public static boolean validId(int id) {
        return id > 0;
    }

}
