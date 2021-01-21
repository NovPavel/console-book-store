package com.company.console.validator;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

public class UserValidator {

    public static boolean loginValid(String login) {
        return login.length() >= 2;
    }


    public static boolean passwordValid(String password) {
        return password.length() >= 2;
    }
}
