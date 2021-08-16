package Loop_For;

import java.util.Scanner;

public class No_2439 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-i-1; j++) {
                System.out.print(" ");
            }
            for (int k = N; k > N-i-1; k--) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
