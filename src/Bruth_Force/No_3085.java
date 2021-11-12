package Bruth_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_3085 {
    private static char[][] candy;
    private static int boardSize;
    private static int candiesCount;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boardSize = Integer.parseInt(bufferedReader.readLine());

        candy = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            char[] row = bufferedReader.readLine().toCharArray();
            if (boardSize >= 0) {
                System.arraycopy(row, 0, candy[i], 0, boardSize);
            }
        }

        solution();
        System.out.println(candiesCount);
    }

    private static void solution() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize - 1; j++) {
                boolean checkChange = checkCandyChangeRow(i, j);
                if (checkChange) {
                    changeCandyRowPosition(i, j);
                }
                countEatCandies();
                changeCandyRowPosition(i, j);
            }
        }

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize - 1; j++) {
                boolean checkChange = checkCandyChangeColumn(i, j);
                if (checkChange) {
                    changeCandyColumnPosition(i, j);
                }
                countEatCandies();
                changeCandyColumnPosition(i, j);
            }
        }
    }

    private static void changeCandyColumnPosition(final int i, final int j) {
        char temp = candy[j][i];
        candy[j][i] = candy[j + 1][i];
        candy[j + 1][i] = temp;
    }

    private static boolean checkCandyChangeColumn(final int i, final int j) {
        return candy[j][i] != candy[j + 1][i];
    }

    private static void countEatCandies() {
        int count = 0;

        for (int i = 0; i < boardSize; i++) {
            count = 1;
            for (int j = 0; j < boardSize - 1; j++) {
                if (candy[i][j] == candy[i][j + 1]) {
                    count++;
                } else {
                    count = 1;
                }
                candiesCount = Math.max(candiesCount, count);
            }
        }

        for (int i = 0; i < boardSize; i++) {
            count = 1;
            for (int j = 0; j < boardSize - 1; j++) {
                if (candy[j][i] == candy[j + 1][i]) {
                    count++;
                } else {
                    count = 1;
                }
                candiesCount = Math.max(candiesCount, count);
            }
        }
    }

    private static void changeCandyRowPosition(final int i, final int j) {
        char temp = candy[i][j];
        candy[i][j] = candy[i][j + 1];
        candy[i][j + 1] = temp;
    }

    private static boolean checkCandyChangeRow(final int i, final int j) {
        return candy[i][j] != candy[i][j + 1];
    }
}
