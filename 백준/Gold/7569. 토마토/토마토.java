import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static int m, n, h;
    private static int[][] box;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        m = Integer.parseInt(stringTokenizer.nextToken()); // 가로
        n = Integer.parseInt(stringTokenizer.nextToken()); // 세로
        h = Integer.parseInt(stringTokenizer.nextToken()); // 높이

        box = new int[n * h][m];
        final Deque<Point> ripenTomato = new ArrayDeque<>();

        for (int i = 0; i < n * h; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(stringTokenizer.nextToken());

                if (box[i][j] == 1) {
                    ripenTomato.add(new Point(i, j));
                }
            }
        }

        ripenTomato(ripenTomato);
    }

    private static void ripenTomato(final Deque<Point> ripenTomato) {
        final boolean[][] isVisited = new boolean[n * h][m];
        final int[] moveX = {1, 0, -1, 0};
        final int[] moveY = {0, 1, 0, -1};
        final int[] moveZ = {n, -n};
        int day = 0;

        while (!ripenTomato.isEmpty()) {
            int size = ripenTomato.size();

            for (int i = 0; i < size; i++) {
                final Point point = ripenTomato.poll();

                int x = point.x;
                int y = point.y;

                searchFourDirection(ripenTomato, moveX, x, y, moveY, isVisited);
                searchUpAndDown(ripenTomato, moveZ, x, y, isVisited);
            }

            if (ripenTomato.isEmpty()) {
                break;
            }

            day++;
        }

        if (searchRemainTomato()) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }

    }

    private static void searchFourDirection(final Deque<Point> ripenTomato, final int[] moveX, final int x, final int y, final int[] moveY, final boolean[][] isVisited) {
        for (int j = 0; j < moveX.length; j++) {
            int nextX = x + moveX[j];
            int nextY = y + moveY[j];

            if (nextX < 0 || nextX >= (n * h) || nextY < 0 || nextY >= m) {
                continue;
            }

            if ((nextX / n) != (x / n) || (nextX % n) >= n) {
                continue;
            }

            if (isVisited[nextX][nextY] || box[nextX][nextY] == -1 || box[nextX][nextY] == 1) {
                continue;
            }

            box[nextX][nextY] = 1;
            ripenTomato.add(new Point(nextX, nextY));
            isVisited[nextX][nextY] = true;
        }
    }

    private static void searchUpAndDown(final Deque<Point> ripenTomato, final int[] moveZ, final int x, final int y, final boolean[][] isVisited) {
        for (final int k : moveZ) {
            int nextX = x + k;

            if (nextX < 0 || nextX >= (n * h) || y < 0 || y >= m) {
                continue;
            }

            if (isVisited[nextX][y] || box[nextX][y] == -1 || box[nextX][y] == 1) {
                continue;
            }

            box[nextX][y] = 1;
            ripenTomato.add(new Point(nextX, y));
            isVisited[nextX][y] = true;
        }
    }

    private static boolean searchRemainTomato() {
        for (final int[] line : box) {
            for (int j = 0; j < box[0].length; j++) {
                if (line[j] == 0) {
                    return true;
                }
            }
        }

        return false;
    }

}
