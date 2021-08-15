package ConditionalStatement_IF;

import java.util.Scanner;

public class No_2884 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int H = scanner.nextInt();
        int M = scanner.nextInt();

        M = M - 45;

        if (M < 0) {
            H = H - 1;
            M = M + 60;
        }

        if (H < 0) {
            H = 24 + H;
        }

        System.out.println(H + " " + M);

        scanner.close();
    }
}
