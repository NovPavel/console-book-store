package com.company.console.validator;

public class BookValidator {

    public static boolean validId(int id){
        return id > 0;
    }

    public static boolean validName(String name){
        return name.length() > 2;
    }

    public static boolean validPages(int pages){
        return pages > 2;
    }

    public static boolean validPrice(int price){
        return price > 1;
    }

    public static boolean validDescription (String description){
        return description.length() > 4;
    }

}
