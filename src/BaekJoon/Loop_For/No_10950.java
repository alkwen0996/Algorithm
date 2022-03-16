package BaekJoon.Loop_For;

import java.util.Scanner;

public class No_10950 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++){
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            System.out.println(A+B);
        }

        scanner.close();
    }
}
