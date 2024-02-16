import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.LinkedList;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCase = Integer.parseInt(bufferedReader.readLine());
        final StringBuilder stringBuilder = new StringBuilder();

        StringTokenizer stringTokenizer;
        char[][] map;
        String line;
        Point man = null;
        int height, width;
        Queue<Point> firePoints;

        for (int i = 0; i < testCase; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            height = Integer.parseInt(stringTokenizer.nextToken());
            width = Integer.parseInt(stringTokenizer.nextToken());
            map = new char[width][height];

            firePoints = new LinkedList<>();

            for (int j = 0; j < width; j++) {
                line = bufferedReader.readLine();

                for (int k = 0; k < height; k++) {
                    map[j][k] = line.charAt(k);

                    if (map[j][k] == '@') {
                        man = new Point(j, k);
                    }

                    if (map[j][k] == '*') {
                        firePoints.add(new Point(j, k));
                    }
                }
            }

            stringBuilder.append(findRoute(map, man, firePoints)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static String findRoute(final char[][] map, final Point man, final Queue<Point> firePoints) {
        final int[] dx = {1, 0, -1, 0};
        final int[] dy = {0, 1, 0, -1};

        final Deque<Point> queue = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[map.length][map[0].length];
        queue.add(man);
        isVisited[man.x][man.y] = true;
        int time = 1;

        while (!queue.isEmpty()) {
            int size = firePoints.size();

            for (int i = 0; i < size; i++) {
                final Point firePoint = firePoints.poll();

                for (int j = 0; j < dx.length; j++) {
                    int nextX = firePoint.x + dx[j];
                    int nextY = firePoint.y + dy[j];

                    if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length) {
                        continue;
                    }

                    if (map[nextX][nextY] == '#' || map[nextX][nextY] == '*') {
                        continue;
                    }

                    firePoints.add(new Point(nextX, nextY));
                    map[nextX][nextY] = '*';
                }
            }

            size = queue.size();

            for (int i = 0; i < size; i++) {
                final Point point = queue.poll();

                map[point.x][point.y] = '.';

                for (int j = 0; j < dx.length; j++) {
                    int nextX = point.x + dx[j];
                    int nextY = point.y + dy[j];

                    if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length) {
                        return time + "";
                    }

                    if (map[nextX][nextY] == '#' || map[nextX][nextY] == '*') {
                        continue;
                    }

                    if (isVisited[nextX][nextY]) {
                        continue;
                    }

                    queue.add(new Point(nextX, nextY));
                    isVisited[nextX][nextY] = true;
                    map[nextX][nextY] = '@';
                }
            }

            time++;
        }

        return "IMPOSSIBLE";
    }

}
