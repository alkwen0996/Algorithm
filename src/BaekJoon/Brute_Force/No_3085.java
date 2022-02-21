package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_3085 {
    private static char[][] boards;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int lineCount = Integer.parseInt(bufferedReader.readLine());

        boards = new char[lineCount][lineCount];

        for (int i = 0; i < lineCount; i++) {
            char[] line = bufferedReader.readLine().toCharArray();
            System.arraycopy(line, 0, boards[i], 0, line.length);
        }

        int result = solution();
        System.out.println(result);
    }

    private static int solution() {
        int answerCount = 0;

        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards.length - 1; j++) {
                boolean checkCandyChangeRow = checkCandyChangeRow(i, j);

                if (checkCandyChangeRow) {
                    candyChangeRowPosition(i, j);
                }

                int countEatCandies = countEatCandies();
                answerCount = Math.max(answerCount, countEatCandies);
                candyChangeRowPosition(i,j);
            }
        }

        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards.length - 1; j++) {
                boolean checkCandyChangeColumn = checkCandyChangeColumn(i, j);

                if (checkCandyChangeColumn) {
                    candyChangeColumnPosition(i, j);
                }

                int countEatCandies = countEatCandies();
                answerCount = Math.max(answerCount, countEatCandies);
                candyChangeColumnPosition(i, j);
            }
        }

        return answerCount;
    }

    private static void candyChangeColumnPosition(final int i, final int j) {
        char temp = boards[i][j];
        boards[i][j] = boards[i][j + 1];
        boards[i][j + 1] = temp;
    }

    private static boolean checkCandyChangeColumn(final int i, final int j) {
        return boards[i][j] != boards[i][j + 1];
    }

    private static boolean checkCandyChangeRow(final int i, final int j) {
        return boards[i][j] != boards[j + 1][i];
    }

    private static void candyChangeRowPosition(final int i, final int j) {
        char temp = boards[i][j];
        boards[i][j] = boards[j + 1][i];
        boards[j + 1][i] = temp;
    }

    private static int countEatCandies() {
        int eatCandyCount = 0;

        for (int i = 0; i < boards.length; i++) {
            int lineCount = 1;

            for (int j = 0; j < boards.length - 1; j++) {
                if (boards[i][j] == boards[i][j + 1]) {
                    lineCount++;
                } else {
                    lineCount = 1;
                }

                eatCandyCount = Math.max(eatCandyCount, lineCount);
            }
        }

        for (int i = 0; i < boards.length; i++) {
            int lineCount = 1;

            for (int j = 0; j < boards.length - 1; j++) {
                if (boards[j][i] == boards[j + 1][i]) {
                    lineCount++;
                } else {
                    lineCount = 1;
                }

                eatCandyCount = Math.max(eatCandyCount, lineCount);
            }
        }

        return eatCandyCount;
    }
}
