package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1974 {

    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";
    private static final String SYMBOL = "#";
    private static final int LENGTH_OF_BOARD = 9;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int countOfTestCase = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < countOfTestCase; i++) {
            final int[][] board = new int[LENGTH_OF_BOARD][LENGTH_OF_BOARD];

            for (int j = 0; j < LENGTH_OF_BOARD; j++) {
                final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                for (int k = 0; k < LENGTH_OF_BOARD; k++) {
                    board[j][k] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            stringBuilder.append(SYMBOL).append(i + 1).append(SPACE).append(solve(board)).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int solve(final int[][] board) {
        if(checkColumn(board) && checkRow(board) && checkSection(board)){
            return 1;
        }

        return 0;
    }

    private static boolean checkSection(final int[][] board) {
        for (int i = 0; i < LENGTH_OF_BOARD; i+=3) {
            for (int j = 0; j < LENGTH_OF_BOARD; j+=3) {
                int sum = 0;

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        sum += board[i + k][j + l];
                    }
                }

                if(sum != 45){
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkRow(final int[][] board) {
        for (int i = 0; i < LENGTH_OF_BOARD; i++) {
            int sumOfRow = 0;

            for (int j = 0; j < LENGTH_OF_BOARD; j++) {
                sumOfRow += board[i][j];
            }

            if(sumOfRow != 45){
                return false;
            }
        }

        return true;
    }

    private static boolean checkColumn(final int[][] board) {
        for (int i = 0; i < LENGTH_OF_BOARD; i++) {
            int sumOfColumn = 0;

            for (int j = 0; j < LENGTH_OF_BOARD; j++) {
                sumOfColumn += board[j][i];
            }

            if(sumOfColumn != 45){
                return false;
            }
        }

        return true;
    }

}
