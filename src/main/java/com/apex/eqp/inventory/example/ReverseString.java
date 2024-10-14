package com.apex.eqp.inventory.example;


import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        getReverseStringUsingLoop(input);

        getReverseStringUsingStringBuilder(input);

        String reversed = getReverseStringUsingRecursion(input);

        System.out.println("Reversed string using Recursion: " + reversed);

        scanner.close();
    }


    public static void getReverseStringUsingLoop(String str){
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        System.out.println("Reversed string using loops: " + reversed);

    }

    public static void getReverseStringUsingStringBuilder(String str){

        String reversed = new StringBuilder(str).reverse().toString();

        System.out.println("Reversed string using StringBuilder: " + reversed);
    }

    public static String getReverseStringUsingRecursion(String str){
        if (str.isEmpty()) {
            return str;
        }
        return str.charAt(str.length() - 1) + getReverseStringUsingRecursion(str.substring(0, str.length() - 1));

    }
}