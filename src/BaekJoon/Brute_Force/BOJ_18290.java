package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18290 {
    private static int[][] boards = new int[10][10];
    private static boolean[][] visited = new boolean[10][10];
    private static int[] width = {0, 0, 1, -1};
    private static int[] height = {1, -1, 0, 0};

    private static int n, m, k;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken()); // k 개선택

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < m; j++) {
                boards[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int sum = 0;
        int count = 0;
        int prev = -1; // 오름차순 개념사용

        selectGrid(prev, count, sum);
        System.out.println(max);
    }

    private static void selectGrid(final int prev, final int count, final int sum) {
        if (count == k) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = prev + 1; i < n * m; i++) {
            int x = i / m;
            int y = i % m;

            boolean isCheck = true;

            for (int a = 0; a < width.length; a++) {
                int positionX = x + width[a];
                int positionY = y + height[a];

                if (positionX >= 0 && positionX < n && positionY >= 0 && positionY < m) {
                    if (visited[positionX][positionY]) {
                        isCheck = false;
                    }
                }
            }

            if (isCheck) {
                visited[x][y] = true;
                selectGrid(x * m + y, count + 1, sum + boards[x][y]);
                visited[x][y] = false;
            }
        }
    }

}

