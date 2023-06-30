import java.awt.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public static int solution(int[][] maps) {
        Deque<Point> queue = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        int[][] dist = new int[maps.length][maps[0].length];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        dist[0][0] = 1;
        queue.add(new Point(0, 0));
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
//            print(isVisited, dist);

            if (now.x == maps.length - 1 && now.y == maps[0].length - 1) {
//                System.out.println("end");
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int nextX = now.x + dx[i];
                int nextY = now.y + dy[i];

                if (nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length) {
                    continue;
                }

                if (isVisited[nextX][nextY] || maps[nextX][nextY] == 0) {
                    continue;
                }

                dist[nextX][nextY] += dist[now.x][now.y] + 1;
                isVisited[nextX][nextY] = true;
                queue.add(new Point(nextX, nextY));
            }
        }

        if (dist[maps.length - 1][maps[0].length - 1] == 0) {
            return -1;
        }

        return dist[maps.length - 1][maps[0].length - 1];
    }
}