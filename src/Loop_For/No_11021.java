package Loop_For;

import java.util.Scanner;

public class No_11021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            System.out.println("Case #"+(i+1)+": "+(scanner.nextInt()+scanner.nextInt()));
        }

        scanner.close();
    }
}
