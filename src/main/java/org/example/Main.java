package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the bar heights separated by spaces (eg: 9 2 4 1 5 7): ");
        String input = scanner.nextLine();
        scanner.close();

        String[] inputArray = input.split(" ");
        int[] bars = new int[inputArray.length];
        
        for (int i = 0; i < inputArray.length; i++) {
            bars[i] = Integer.parseInt(inputArray[i]);
        }

        int water = waterCalculation(bars);
        System.out.println("Total amount of accumulated water is: " + water);
    }
    
    public static int waterCalculation(int[] bars) {

        // If the array is empty or has 1 element
        if (bars.length <= 2) {
            return 0;
        }

        int[] leftMax = new int[bars.length];
        int[] rightMax = new int[bars.length];

        leftMax[0] = bars[0];
        rightMax[bars.length - 1] = bars[bars.length - 1];

        for (int i = 1; i < bars.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], bars[i]);
        }

        for (int i = bars.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], bars[i]);
        }

        int water = 0;

        for (int i = 0; i < bars.length; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - bars[i];
        }

        return water;
    }
}