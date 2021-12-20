package WTC_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_05 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());

        System.out.println(solve(number));
    }

    private static int solve(final int number) {
        int count = 0;

        for (int i = 1; i <= number; i++) {
            int tenThousands = i / 10000;
            int thousands = i % 10000 / 1000;
            int hundreds = i % 1000 / 100;
            int tens = i % 1000 % 100 / 10;
            int units = i % 1000 % 100 % 10;

            if (units == 3 || units == 6 || units == 9) {
                count++;
            }
            if(tens == 3 || tens == 6 || tens == 9){
                count++;
            }
            if(hundreds == 3 || hundreds == 6 || hundreds == 9){
                count++;
            }
            if(thousands == 3 || thousands == 6 || thousands == 9){
                count++;
            }
        }

        return count;
    }
}
