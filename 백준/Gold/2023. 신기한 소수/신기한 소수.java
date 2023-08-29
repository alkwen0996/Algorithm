
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final String NEW_LINE = "\n";

    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int inputNumberLength = Integer.parseInt(bufferedReader.readLine());

        findInterestingPrimeNumber(inputNumberLength, 0, "");
        System.out.println(stringBuilder);
    }

    private static void findInterestingPrimeNumber(final int inputNumber, int index, final String interestingPrimeNumber) {
        if (index == inputNumber) {
            stringBuilder.append(interestingPrimeNumber).append(NEW_LINE);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (isPrimeNumber(Integer.parseInt(interestingPrimeNumber + i))) {
                findInterestingPrimeNumber(inputNumber, index + 1, interestingPrimeNumber + i);
            }
        }

    }

    private static boolean isPrimeNumber(final int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
