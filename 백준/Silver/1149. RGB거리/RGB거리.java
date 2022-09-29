
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

        prices = new int[numberOfHouse][numberOfColor];
        memorization = new int[numberOfHouse][numberOfColor];

        for (int i = 0; i < numberOfHouse; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            prices[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            prices[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            prices[i][2] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(calculateMinimumPaintPrice(numberOfHouse));
    }

    private static int calculateMinimumPaintPrice(final int numberOfHouse) {
        for (int i = 1; i < numberOfHouse; i++) {
            prices[i][RED] += Math.min(prices[i - 1][GREEN], prices[i - 1][BLUE]);
            prices[i][GREEN] += Math.min(prices[i - 1][RED], prices[i - 1][BLUE]);
            prices[i][BLUE] += Math.min(prices[i - 1][GREEN], prices[i - 1][RED]);
        }

        return Arrays.stream(prices[numberOfHouse-1])
                .min()
                .getAsInt();
    }

}