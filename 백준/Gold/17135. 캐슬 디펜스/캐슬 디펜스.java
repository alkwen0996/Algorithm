import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, range, maxKill;
    public static int[][] map, copyMap;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        range = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[N + 1][M];
        copyMap = new int[N + 1][M];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        maxKill = Integer.MIN_VALUE;
        selectArchers(0, 0, new int[3]);
        System.out.println(maxKill);
    }

    private static void selectArchers(final int count, final int start, final int[] archers) {
        if (count == 3) {
            copyMap();
            maxKill = Math.max(maxKill, playGame(archers));

            return;
        }

        for (int i = start; i < M; i++) {
            archers[count] = i;
            selectArchers(count + 1, i + 1, archers);
        }

    }

    private static void copyMap() {
        copyMap = new int[N + 1][M];

        for (int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, copyMap[i], 0, map[0].length);
        }

    }

    private static int playGame(final int[] archers) {
        int count = 0;

        for (int i = 0; i < N; i++) { // N번 턴
            List<Point> enemies = new ArrayList<>();

            for (int archerNumber : archers) { // 선택한 3명의 궁수 각각 작업 수행
                enemies.add(findEnemy(archerNumber));
            }

            for (Point enemy : enemies) {
                if (enemy.x != Integer.MAX_VALUE && enemy.y != Integer.MAX_VALUE) {
                    if (copyMap[enemy.x][enemy.y] != 0) {
                        count = killEnemy(count, enemy);
                    }
                }
            }

            moveEnemy();
        }

        return count;
    }

    private static int killEnemy(int count, final Point enemy) {
        copyMap[enemy.x][enemy.y] = 0;
        count++;

        return count;
    }

    private static Point findEnemy(final int archerNumber) {
        // 궁수 위치 = N, archerNumber
        int minimumDistance = Integer.MAX_VALUE;
        Point point = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for (int i = copyMap.length - 2; i >= 0; i--) {
            for (int j = 0; j < copyMap[0].length; j++) {
                int distance = Math.abs(N - i) + Math.abs(archerNumber - j);

                if (distance <= range) {
                    if (copyMap[i][j] == 1) {
                        if (minimumDistance > distance) {
                            point = new Point(i, j);
                            minimumDistance = distance;
                        } else if (minimumDistance == distance) {
                            if (point.y > j) {
                                point = new Point(i, j);
                            }
                        }
                    }
                }
            }
        }

        return point;
    }

    private static void moveEnemy() {
        for (int i = copyMap.length - 1; i >= 1; i--) {
            for (int j = 0; j < copyMap[0].length; j++) {
                copyMap[i][j] = copyMap[i - 1][j];
                copyMap[i - 1][j] = 0;
            }
        }

    }

}