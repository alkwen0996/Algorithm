package Bruth_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1018 {
    private static final char WHITE = 'W';
    private static final char BLACK = 'B';
    private static final int BOARD_SQUARE_COUNT = 64;
    private static char[][] chessBoard;
    private static int paintCount = 64;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int M = Integer.parseInt(stringTokenizer.nextToken());

        chessBoard = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] chessBoardLine = bufferedReader.readLine().toCharArray();
            System.arraycopy(chessBoardLine, 0, chessBoard[i], 0, M);
        }

        final int cuttingChessBoardRow = N - 7;
        final int cuttingChessBoardColumn = M - 7;

        for (int i = 0; i < cuttingChessBoardRow; i++) {
            for (int j = 0; j < cuttingChessBoardColumn; j++) {
                paintChessBoardSquare(i, j);
            }
        }

        System.out.println(paintCount);
    }

    private static void paintChessBoardSquare(final int i, final int j) {
        final int endOfRow = i + 8;
        final int endOfColumn = j + 8;

        char square = chessBoard[i][j];
        int paintSquareCount = 0;

        for (int x = i; x < endOfRow; x++) {
            for (int y = j; y < endOfColumn; y++) {
                if (square == chessBoard[x][y]) {
                    paintSquareCount++;
                }

                square = changeColor(square);
            }

            square = changeColor(square);
        }

        paintSquareCount = Math.min(paintSquareCount, BOARD_SQUARE_COUNT - paintSquareCount);
        paintCount = Math.min(paintSquareCount, paintCount);
    }

    private static char changeColor(char square) {
        if (square == WHITE) {
            square = BLACK;
        } else {
            square = WHITE;
        }

        return square;
    }

}



