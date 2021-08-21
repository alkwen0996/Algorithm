package Function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1065 {
    private static final int TEN = 10;
    private static final int HUNDRED = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int result = solve(N);
        System.out.println(result);
    }

    private static int solve(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            count = countArithmeticSequence(N, count, i);
        }

        return count;
    }

    private static int countArithmeticSequence(int N, int count, int i) {
        if (String.valueOf(i).length() < 3) {
            count++;
        }
        if (String.valueOf(i).length() == 3) {
            count += checkThirdDigitArithmeticsSequence(i);
        }

        return count;
    }

    private static int checkThirdDigitArithmeticsSequence(int i) {
        int hundredDigit = i / HUNDRED;
        int tenDigit = (i % HUNDRED) / TEN;
        int unitDigit = i % TEN;

        if (hundredDigit + unitDigit == tenDigit * 2) {
            return 1;
        }
        return 0;
    }
}
