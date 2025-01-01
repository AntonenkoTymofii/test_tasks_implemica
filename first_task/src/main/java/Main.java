import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of pairs of parentheses
        System.out.print("Enter N: ");
        int n = scanner.nextInt();

        // Calculate and print the number of valid bracket expressions
        System.out.println("Number of valid bracket expressions: " + catalanNumber(n));
    }

    // Method to calculate the n-th Catalan number
    private static long catalanNumber(int n) {
        // Array to store Catalan numbers
        long[] catalan = new long[n + 1];

        // Base case: C0 = 1
        catalan[0] = 1;

        // Iteratively calculate Catalan numbers using the recurrence relation
        for (int i = 1; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                // C_n = sum of C_j * C_(n-j-1) for all j in [0, n-1]
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

        // Return the n-th Catalan number
        return catalan[n];
    }
}
