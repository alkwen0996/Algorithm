import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int m = Integer.parseInt(stringTokenizer.nextToken());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());

            int[][] map = new int[m][n];
            boolean[][] isVisited = new boolean[map.length][map[0].length];

            List<Point> cabbages = new ArrayList<>();

            for (int j = 0; j < k; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());

                map[x][y] = 1;
                cabbages.add(new Point(x, y));
            }

            int bugCount = 0;

            for (int j = 0; j < cabbages.size(); j++) {
                Point point = cabbages.get(j);

                if (isVisited[point.x][point.y]) {
                    continue;
                }

                isVisited[point.x][point.y] = true;
                bfs(map, point, isVisited);
                bugCount++;
            }

            stringBuilder.append(bugCount).append("\n");
        }

        System.out.println(stringBuilder);
    } // main

    private static void bfs(final int[][] map, final Point startPoint, final boolean[][] isVisited) {
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(startPoint);

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length) {
                    continue;
                }

                if (map[nextX][nextY] == 0) {
                    continue;
                }

                if (isVisited[nextX][nextY]) {
                    continue;
                }

                queue.add(new Point(nextX, nextY));
                isVisited[nextX][nextY] = true;
            }
        }

    }

} // class
