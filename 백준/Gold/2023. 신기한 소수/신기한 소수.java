import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());
        final StringBuilder stringBuilder = new StringBuilder();

        findAmazingPrimeNumber(n, 0, "", stringBuilder);
        System.out.println(stringBuilder);
    }

    private static void findAmazingPrimeNumber(final int n, final int index, final String amazingNumber, final StringBuilder stringBuilder) {
        if (index == n) {
            stringBuilder.append(amazingNumber).append(NEW_LINE);

            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (checkPrimeNumber(Integer.parseInt(amazingNumber + i))) {
                findAmazingPrimeNumber(n, index + 1, amazingNumber + i, stringBuilder);
            }
        }
    }


    private static boolean checkPrimeNumber(final int number) {
        if (number == 1) {
            return false;
        }

        // 각 자리가 소수인지 확인
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}