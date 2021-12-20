package Bruth_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1018 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int M = Integer.parseInt(stringTokenizer.nextToken());
        char[][] chessBoard = new char[N][M];

        for (int i = 0; i < N; i++) {
            char [] boardColor = bufferedReader.readLine().toCharArray();
            System.arraycopy(boardColor, 0, chessBoard[i], 0, boardColor.length);
        }

        int result = solve(chessBoard, N, M);
        System.out.println(result);
    }

    private static int solve(final char[][] chessBoard, final int N, final int M) {
        int changeBoardCount = 0;
        for (int i =0; i < N; i++){
            for (int j =0; j < M; j++){
                System.out.print(chessBoard[i][j]);
            }
            System.out.println();
        }

        return changeBoardCount;
    }
}



