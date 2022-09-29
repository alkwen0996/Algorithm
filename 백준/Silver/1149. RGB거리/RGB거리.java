
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[][] prices;
    private static int[][] memorization;
    private static int RED = 0, BLUE = 1, GREEN = 2;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int numberOfHouse = Integer.parseInt(bufferedReader.readLine());
        final int numberOfColor = 3;

        prices = new int[numberOfHouse + 1][numberOfColor];
        memorization = new int[numberOfHouse + 1][numberOfColor];

        for (int i = 1; i <= numberOfHouse; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            prices[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            prices[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            prices[i][2] = Integer.parseInt(stringTokenizer.nextToken());
        }

        memorization[1][RED] = prices[1][RED];
        memorization[1][GREEN] = prices[1][GREEN];
        memorization[1][BLUE] = prices[1][BLUE];

        calculatePrice_byRecursive(numberOfHouse, RED);
        calculatePrice_byRecursive(numberOfHouse, GREEN);
        calculatePrice_byRecursive(numberOfHouse, BLUE);

        final int minimumPrice = Arrays.stream(memorization[numberOfHouse])
                .min()
                .getAsInt();

        System.out.println(minimumPrice);
    }

    private static int calculatePrice_byRecursive(final int numberOfHouse, final int color) { // 반복문 사용
        if (memorization[numberOfHouse][color] == 0) {
            if (color == RED) {
                memorization[numberOfHouse][RED]
                        = Math.min(calculatePrice_byRecursive(numberOfHouse - 1, GREEN), calculatePrice_byRecursive(numberOfHouse - 1, BLUE))
                +prices[numberOfHouse][RED];
            }

            if (color == GREEN) {
                memorization[numberOfHouse][GREEN]
                        = Math.min(calculatePrice_byRecursive(numberOfHouse - 1, RED), calculatePrice_byRecursive(numberOfHouse - 1, BLUE))
                        +prices[numberOfHouse][GREEN];
            }

            if (color == BLUE) {
                memorization[numberOfHouse][BLUE]
                        = Math.min(calculatePrice_byRecursive(numberOfHouse - 1, GREEN), calculatePrice_byRecursive(numberOfHouse - 1, RED))
                        +prices[numberOfHouse][BLUE];
            }

        }

        return memorization[numberOfHouse][color];
    }
}