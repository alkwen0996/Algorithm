import java.awt.*;
import java.util.*;

class Solution {
    public int solution(String[] maps) {
        char[][] newMap = new char[maps.length][maps[0].length()];
        
        Point start = null;
        Point lever = null;
        Point end = null;

        for (int i = 0; i < maps.length; i++) {
            char[] charArray = maps[i].toCharArray();

            for (int j = 0; j < charArray.length; j++) {
                newMap[i][j] = charArray[j];

                if (newMap[i][j] == 'S') {
                    start = new Point(i, j);
                    continue;
                }

                if (newMap[i][j] == 'L') {
                    lever = new Point(i, j);
                    continue;
                }

                if (newMap[i][j] == 'E') {
                    end = new Point(i, j);
                }
            }
        }

        int fromStoL = bfs(newMap, start, lever);
        int fromLtoE = bfs(newMap, lever, end);

        if (fromStoL == -1 || fromLtoE == -1) {
            return -1;
        }

        return fromStoL + fromLtoE;
    }
    
    public int bfs(char[][] newMap, Point start, Point end) {
        int[][] distanceMap = new int[newMap.length][newMap[0].length];

        Deque<Point> queue = new ArrayDeque<>();
        queue.add(start);

        boolean[][] isVisited = new boolean[newMap.length][newMap[0].length];
        isVisited[start.x][start.y] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.x == end.x && point.y == end.y) {
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= distanceMap.length || nextY >= distanceMap[0].length) {
                    continue;
                }

                if (isVisited[nextX][nextY] || newMap[nextX][nextY] == 'X') {
                    continue;
                }

                queue.add(new Point(nextX, nextY));
                isVisited[nextX][nextY] = true;
                distanceMap[nextX][nextY] = distanceMap[point.x][point.y] + 1;
            }
        }

        if (distanceMap[end.x][end.y] == 0) {
            return -1;
        }

        return distanceMap[end.x][end.y];
    }
}