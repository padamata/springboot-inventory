package com.apex.eqp.inventory.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilteringExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // Tokenizing and filtering tokens with length greater than 3
        String[] filteredTokens = Arrays.stream(input.split(" "))
                                        .filter(token -> token.length() > 3)
                                        .collect(Collectors.toList())
                                        .toArray(new String[0]);

        System.out.println("Filtered Tokens (length > 3):");
        for (String token : filteredTokens) {
            System.out.println(token);
        }

        scanner.close();
    }
}
