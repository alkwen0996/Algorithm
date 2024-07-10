import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int blue, white;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] paper = new int[n][n];
        boolean[][] isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        white = 0; // 0
        blue = 0; // 1
        countPaper(paper, isVisited, 0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    } // main

    private static void countPaper(final int[][] paper, final boolean[][] isVisited, final int row, final int column, final int size) {
        if (checkPaper(paper, row, column, size)) {
            checkVisited(isVisited, row, column, size);

            if (paper[row][column] == 0) {
                white++;
            } else {
                blue++;
            }

            return;
        }

        int newSize = size / 2;

        for (int i = row; i < row + size; i += newSize) {
            for (int j = column; j < column + size; j += newSize) {
                if (isVisited[i][j]) {
                    continue;
                }

                countPaper(paper, isVisited, i, j, newSize);
            }
        }
    }

    private static void checkVisited(final boolean[][] isCheck, final int row, final int column, final int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = column; j < column + size; j++) {
                isCheck[i][j] = true;
            }
        }
    }

    private static boolean checkPaper(final int[][] paper, final int row, final int column, final int size) {
        for (int i = row; i < row + size; i++) {
            for (int j = column; j < column + size; j++) {
                if (paper[row][column] != paper[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
} // class
