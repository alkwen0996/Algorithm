package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2001 {

    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";
    private static final String SYMBOL = "#";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int countOfTestCase = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < countOfTestCase; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int lengthOfBoardLine = Integer.parseInt(stringTokenizer.nextToken());
            final int flapperSize = Integer.parseInt(stringTokenizer.nextToken());

            final int[][] board = new int[lengthOfBoardLine][lengthOfBoardLine];

            for (int j = 0; j < lengthOfBoardLine; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                for (int k = 0; k < lengthOfBoardLine; k++) {
                    board[j][k] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            stringBuilder.append(SYMBOL)
                    .append(i + 1)
                    .append(SPACE)
                    .append(solve(flapperSize, board))
                    .append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int solve(final int flapperSize, final int[][] board) {
        int maxCountOfKillingFly = 0;

        if (flapperSize == board.length) {
            for (final int[] line : board) {
                maxCountOfKillingFly += Arrays.stream(line).sum();
            }

            return maxCountOfKillingFly;
        }

        for (int i = 0; i < board.length; i++) {
            int lastIndex = board.length - flapperSize;

            for (int j = 0; j < board.length; j++) {

                if (i <= lastIndex && j <= lastIndex) {
                    maxCountOfKillingFly = Math.max(maxCountOfKillingFly, getCountOfKillFly(i, j, flapperSize, board));
                }
            }
        }

        return maxCountOfKillingFly;
    }

    private static int getCountOfKillFly(final int startIndexX, final int startIndexY, final int flapperSize, final int[][] board) {
        int sum = 0;

        for (int i = startIndexX; i <= startIndexX + flapperSize - 1; i++) {
            for (int j = startIndexY; j <= startIndexY + flapperSize - 1; j++) {
                sum += board[i][j];
            }
        }

        return sum;
    }

}
