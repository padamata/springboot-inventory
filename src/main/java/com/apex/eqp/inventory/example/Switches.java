package com.apex.eqp.inventory.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Switches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of switches (n): ");
        int n = scanner.nextInt();

        // Create an array to represent the switches, initialized to false (OFF)
        boolean[] switches = new boolean[n + 1]; // Using 1-based indexing

        // Round 1: Turn ON all switches
        for (int i = 1; i <= n; i++) {
            switches[i] = true;
        }

        // Rounds 2 to n
        for (int round = 2; round <= n; round++) {
            for (int j = round; j <= n; j += round) {
                // Toggle the switch
                switches[j] = !switches[j];
            }
        }

        // Collect and print all switches that are ON
        List<Integer> onSwitches = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (switches[i]) {
                onSwitches.add(i);
            }
        }

        System.out.println("Switches that are ON: " + onSwitches);
        
        // Close the scanner
        scanner.close();
    }
}