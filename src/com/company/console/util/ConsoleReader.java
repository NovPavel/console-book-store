package com.company.console.util;

import java.util.Scanner;

public class ConsoleReader {

    public static String readString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Integer readInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static Double readDouble(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

}
