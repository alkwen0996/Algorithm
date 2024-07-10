import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int gray, white, black;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] paper = new int[n][n];

        StringTokenizer stringTokenizer;
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        gray = 0; // -1
        white = 0; // 0
        black = 0; // 1

        countPaper(paper, 0, 0, n);
        System.out.println(gray);
        System.out.println(white);
        System.out.println(black);
    } // main

    private static void countPaper(final int[][] paper, int row, int column, int size) {
        if (checkPaper(paper, row, column, size)) {
            if (paper[row][column] == -1) {
                gray++;
            } else if (paper[row][column] == 0) {
                white++;
            } else {
                black++;
            }

            return;
        }

        int newSize = size / 3;

        for (int i = row; i < row + size; i += newSize) {
            for (int j = column; j < column + size; j += newSize) {
                countPaper(paper, i, j, newSize);
            }
        }
    }

    private static boolean checkPaper(final int[][] paper, int row, int column, final int size) {
        int element = paper[row][column];

        for (int i = row; i < row + size; i++) {
            for (int j = column; j < column + size; j++) {
                if (element != paper[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
} // class
