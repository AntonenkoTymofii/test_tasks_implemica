package org.example;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        // Initialize the factorial result as 1
        BigInteger factorial = BigInteger.ONE;

        // Calculate 100! (factorial of 100)
        for (int i = 2; i <= 100; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        // Initialize the sum of digits
        int sumOfDigits = 0;

        // Convert the factorial result to a string to process each digit
        String digits = factorial.toString();

        // Iterate through each character (digit) and add its numeric value to the sum
        for (char digit : digits.toCharArray()) {
            sumOfDigits += Character.getNumericValue(digit);
        }

        // Print the result
        System.out.println("Sum of the digits in 100! is: " + sumOfDigits);
    }}