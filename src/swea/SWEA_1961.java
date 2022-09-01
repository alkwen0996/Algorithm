package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1961 {

    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";
    private static final String SYMBOL = "#";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int countOfTestCase = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < countOfTestCase; i++) {
            final int lengthOfBoard = Integer.parseInt(bufferedReader.readLine());
            final int[][] board = new int[lengthOfBoard][lengthOfBoard];

            for (int j = 0; j < lengthOfBoard; j++) {
                final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                for (int k = 0; k < lengthOfBoard; k++) {
                    board[j][k] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            stringBuilder.append(SYMBOL).append(i + 1).append(NEW_LINE).append(solve(board));
        }

        System.out.println(stringBuilder);
    }

    private static StringBuilder solve(final int[][] board) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int x = 0; x < board.length; x++) {
            for (int i = 0; i < board.length; i++) {
                stringBuilder.append(board[board.length - i - 1][x]);
            }

            stringBuilder.append(SPACE);

            for (int i = 0; i < board.length; i++) {
                stringBuilder.append(board[board.length - x - 1][board.length - i - 1]);
            }

            stringBuilder.append(SPACE);

            for (int i = 0; i < board.length; i++) {
                stringBuilder.append(board[i][board.length - 1 - x]);
            }

            stringBuilder.append(NEW_LINE);
        }

        return stringBuilder;
    }

}
