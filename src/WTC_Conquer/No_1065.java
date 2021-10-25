package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1065 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int result = solve(N);
        System.out.println(result);
    }

    private static int solve(final int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i < 100) {
                count++;
            } else {
                if (checkHanSoo(i)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean checkHanSoo(final int n) {
        boolean checkNumber = false;
        int hundredDigit = n / 100;
        int tensDigit = (n % 100) / 10;
        int unit = ((n % 100) % 10);

        int firstDiff = tensDigit - unit;
        int secondDiff = hundredDigit - tensDigit;

        if (secondDiff == firstDiff) {
            checkNumber = true;
        }

        return checkNumber;
    }
}
