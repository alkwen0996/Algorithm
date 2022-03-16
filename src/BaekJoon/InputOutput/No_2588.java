package BaekJoon.InputOutput;

import java.util.Scanner;

public class No_2588 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int units = B%10;
        System.out.println(A*units);

        int tens = (B%100-units)/10;
        System.out.println(A*tens);

        int hundreds = (B-tens-units)/100;
        System.out.println(A*hundreds);

        System.out.println(A*B);

        scanner.close();
    }
}
