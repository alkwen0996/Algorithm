import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < map.length; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        bfs(map);
    } // main

    private static void bfs(final int[][] map) {
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        Queue<Point> queue = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int maximumSizePicture = 0;
        int pictureCount = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0 || isVisited[i][j]) {
                    continue;
                }

                queue.add(new Point(i, j));
                int pictureSize = 0;
                pictureCount++;

                while (!queue.isEmpty()) {
                    pictureSize++;
                    Point point = queue.poll();

                    isVisited[point.x][point.y] = true;

                    for (int k = 0; k < dx.length; k++) {
                        int nextX = point.x + dx[k];
                        int nextY = point.y + dy[k];

                        if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length) {
                            continue;
                        }

                        if (isVisited[nextX][nextY] || map[nextX][nextY] == 0) {
                            continue;
                        }

                        queue.add(new Point(nextX, nextY));
                        isVisited[nextX][nextY] = true;
                    }
                }

                if (maximumSizePicture < pictureSize) {
                    maximumSizePicture = pictureSize;
                }
            }
        }

        System.out.println(pictureCount);
        System.out.println(maximumSizePicture);
    }
} // class
