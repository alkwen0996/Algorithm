package BaekJoon.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1012 {
    private static int width;
    private static int height;
    private static int areaCount;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] searchAreaWidth = {1, 0, -1, 0};
    private static final int[] searchAreaHeight = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine());

        while (testCase-- > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            width = Integer.parseInt(stringTokenizer.nextToken());
            height = Integer.parseInt(stringTokenizer.nextToken());
            int locationCount = Integer.parseInt(stringTokenizer.nextToken());

            map = new int[width][height];
            visited = new boolean[width][height];
            areaCount = 0;

            for (int i = 0; i < locationCount; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                map[Integer.parseInt(stringTokenizer.nextToken())][Integer.parseInt(stringTokenizer.nextToken())] = 1;
            }

            int result = solution();
            System.out.println(result);
        }

    }

    private static int solution() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if ((map[i][j]) == 1 && !visited[i][j]) {
                    dfs(i, j);
                    areaCount++;
                }
            }
        }

        return areaCount;
    }

    private static void dfs(final int i, final int j) {
        visited[i][j] = true;

        for (int k = 0; k < searchAreaHeight.length; k++) {
            int X = i + searchAreaWidth[k];
            int Y = j + searchAreaHeight[k];

            if (X >= 0 && Y >= 0 && (X <= width - 1) && (Y <= height - 1)) {
                if (!visited[X][Y] && map[X][Y] == 1) {
                    dfs(X, Y);
                }
            }

        }

    }

}
