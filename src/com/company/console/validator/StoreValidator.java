package com.company.console.validator;

public class StoreValidator {

    public static boolean validId(int id){
        return id > 0;
    }

    public static boolean validTitle (String title){
        return title.length() > 2;
    }
}
