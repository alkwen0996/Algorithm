import java.awt.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    private static int maximumEat;
    
    private static int[] dx = {1, 1, -1, -1};
    private static int[] dy = {1, -1, -1, 1};

    private static int[][] map, copyMap;
    private static Set<Integer> desertType;
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            final int lengthOfMap = Integer.parseInt(bufferedReader.readLine());

            map = new int[lengthOfMap][lengthOfMap];
            copyMap = new int[lengthOfMap][lengthOfMap];

            for (int j = 0; j < lengthOfMap; j++) {
                final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                for (int k = 0; k < lengthOfMap; k++) {
                    map[j][k] = Integer.parseInt(stringTokenizer.nextToken());
                    copyMap[j][k] = map[j][k];
                }
            }

            goDesertTour();
            stringBuilder.append("#").append(i).append(" ").append(maximumEat).append("\n");
        }

        System.out.println(stringBuilder); // 결과출력
    }

    private static void goDesertTour() {
        maximumEat = 0;

        for (int i = 0; i < map.length - 2; i++) {
            for (int j = 0; j < map.length - 1; j++) {
                isVisited = new boolean[map.length][map.length];
                desertType = new HashSet<>();

                desertType.add(map[i][j]);
                isVisited[i][j] = true;

                dfs(desertType, new Point(i, j), new Point(i, j), 1, 0);
                revertMap();
            }
        }

        if (maximumEat == 0) {
            maximumEat = -1;
        }

    }

    private static void dfs(final Set<Integer> desertType, final Point point, final Point startPoint, final int count, final int direction) {
        for (int i = direction; i < dx.length; i++) {
            int nextX = point.x + dx[i];
            int nextY = point.y + dy[i];

            if (nextX == startPoint.x && nextY == startPoint.y && count > 2) {
                maximumEat = Math.max(maximumEat, count);

                return;
            }

            if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map.length) {
                continue;
            }

            if (desertType.contains(map[nextX][nextY]) || isVisited[nextX][nextY]) {
                continue;
            }

            isVisited[nextX][nextY] = true;
            desertType.add(map[nextX][nextY]);

            dfs(desertType, new Point(nextX, nextY), startPoint, count + 1, i);

            desertType.remove(map[nextX][nextY]);
            isVisited[nextX][nextY] = false;
        }

    }

    private static void revertMap() {
        for (int i = 0; i < map.length; i++) {
            map[i] = copyMap[i].clone();
        }

    }

}
