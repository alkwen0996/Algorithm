package BaekJoon.Loop_For;

import java.util.Scanner;

public class No_2742 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        for (int i = N; i > 0; i--){
            System.out.println(i);
        }

        scanner.close();
    }
}
