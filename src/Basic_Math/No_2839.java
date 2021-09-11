package Basic_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2839 {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(bufferedReader.readLine());

        if (inputNumber == 4 || inputNumber == 7) {
            System.out.println(-1);
        }else if (inputNumber % 5 == 0) {
            System.out.println(inputNumber / 5);
        }else if ((inputNumber % 5) == 1 || (inputNumber % 5) == 3) {
            System.out.println((inputNumber / 5) + 1);
        }else if ((inputNumber % 5) == 2 || (inputNumber % 5) == 4) {
            System.out.println((inputNumber / 5) + 2);
        }
    }
}
