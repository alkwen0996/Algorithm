package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int boardSize = Integer.parseInt(bufferedReader.readLine());
        final char[][] board = new char[boardSize][boardSize];

        for (int i = 0; i < boardSize; i++) {
            char[] line = bufferedReader.readLine().toCharArray();

            System.arraycopy(line, 0, board[i], 0, line.length);
        }

        int result = solution(board);
        System.out.println(result);
    }

    private static int solution(final char[][] board) {
        int maxCountEatCandies = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j + 1 < board.length) {
                    char temp = board[i][j + 1];
                    board[i][j + 1] = board[i][j];
                    board[i][j] = temp;

                    maxCountEatCandies = Math.max(maxCountEatCandies, countEatCandies(board));

                    temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;
                }

                if (i + 1 < board.length) {
                    char temp = board[i + 1][j];
                    board[i + 1][j] = board[i][j];
                    board[i][j] = temp;

                    maxCountEatCandies = Math.max(maxCountEatCandies, countEatCandies(board));

                    temp = board[i][j];
                    board[i][j] = board[i + 1][j];
                    board[i + 1][j] = temp;
                }
            }
        }

        return maxCountEatCandies;
    }

    private static int countEatCandies(final char[][] board) {
        int eatCandies = 1;

        for (int i = 0; i < board.length; i++) {
            int lineEatCandies = 1;

            for (int j = 0; j < board.length - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    lineEatCandies++;
                } else {
                    lineEatCandies = 1;
                }

                eatCandies = Math.max(eatCandies, lineEatCandies);
            }

            lineEatCandies = 1;
            for (int j = 0; j < board.length - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    lineEatCandies++;
                } else {
                    lineEatCandies = 1;
                }

                eatCandies = Math.max(eatCandies, lineEatCandies);
            }
        }

        return eatCandies;
    }
}
