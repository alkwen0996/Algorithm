package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1979 {

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
            final int wordLength = Integer.parseInt(stringTokenizer.nextToken());

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
                    .append(solve(wordLength, board))
                    .append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int solve(final int wordLength, final int[][] board) {
        int wordPlaceCount = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    continue;
                }

                if (checkWidthPlace(i, j, wordLength, board)) {
                    wordPlaceCount++;
                }

                if (checkHeightPlace(i, j, wordLength, board)) {
                    wordPlaceCount++;
                }

            }
        }

        return wordPlaceCount;
    }

    private static boolean checkHeightPlace(final int x, final int y, final int wordLength, final int[][] board) {
        if (x > 0 && board[x - 1][y] == 1) {
            return false;
        }

        int blankSpaceCountY = 0;

        for (int i = x; i < board.length; i++) {
            if (board[i][y] == 0) {
                break;
            }

            blankSpaceCountY++;
        }

        return blankSpaceCountY == wordLength;
    }

    private static boolean checkWidthPlace(final int x, final int y, final int wordLength, final int[][] board) {
        if (y > 0 && board[x][y - 1] == 1) {
            return false;
        }

        int blankSpaceCountX = 0;

        for (int i = y; i < board.length; i++) {
            if (board[x][i] == 0) {
                break;
            }

            blankSpaceCountX++;
        }

        return blankSpaceCountX == wordLength;
    }

}
