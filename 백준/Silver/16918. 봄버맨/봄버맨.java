
import java.awt.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


public class Main {

    public static final String NEW_LINE = "\n";
    public static final char BOMB01 = 'O';
    public static final char BOMB02 = 'X';
    public static final char EMPTY = '.';

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int row = Integer.parseInt(stringTokenizer.nextToken());
        final int column = Integer.parseInt(stringTokenizer.nextToken());
        final int timeLimit = Integer.parseInt(stringTokenizer.nextToken());

        final char[][] initialMap = new char[row][column];

        for (int i = 0; i < row; i++) {
            char[] line = bufferedReader.readLine().toCharArray();

            for (int j = 0; j < column; j++) {
                initialMap[i][j] = line[j];
            }
        }

        solution(initialMap, timeLimit);
        final StringBuilder stringBuilder = new StringBuilder();

        for (final char[] line : initialMap) {
            for (int j = 0; j < initialMap[0].length; j++) {
                if (line[j] == EMPTY) {
                    stringBuilder.append(EMPTY);
                    continue;
                }

                stringBuilder.append(BOMB01);
            }

            stringBuilder.append(NEW_LINE);
        }

        System.out.println(stringBuilder);

    }

    private static void solution(final char[][] map, final int timeLimit) {
        int countTime = 1;
        boolean bombType = false;

//        System.out.println("=====" + countTime + "=====");
        /*for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();*/

        while (countTime <= timeLimit) {
            if (countTime % 2 == 0) {
//                System.out.println("폭탄설치");
                bombType = installBomb(map, bombType);
            } else if (countTime % 2 == 1 && countTime >= 3) {
//                System.out.println("폭탄폭발");
                explodingBomb(map, bombType);
            }

            countTime++;

/*            System.out.println("=====" + countTime + "=====");
            for (int i = 0; i < map.length; i++) {
                System.out.println(Arrays.toString(map[i]));
            }
            System.out.println();*/
        }

    }

    private static boolean explodingBomb(final char[][] map, final boolean bombType) {
        final int[] dx = {1, 0, -1, 0};
        final int[] dy = {0, 1, 0, -1};

        char bomb;
        bomb = selectBomb(bombType);
//        System.out.println("폭탄: " + bomb);

        final Deque<Point> queue = new ArrayDeque<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == bomb) {
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            final Point bombPoint = queue.poll();
            map[bombPoint.x][bombPoint.y] = EMPTY;

            for (int i = 0; i < dx.length; i++) {
                int nextX = bombPoint.x + dx[i];
                int nextY = bombPoint.y + dy[i];

                if (nextY < 0 || nextX < 0 || nextX >= map.length || nextY >= map[0].length) {
                    continue;
                }

                map[nextX][nextY] = EMPTY;
            }
        }

        return !bombType;
    }

    private static boolean installBomb(final char[][] map, final boolean bombType) {
        char bomb;
        bomb = selectBomb(bombType);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == EMPTY) {
                    map[i][j] = bomb;
                }
            }
        }

        return !bombType;

    }

    private static char selectBomb(final boolean bombType) {
        if (bombType) {
            return BOMB01;
        } else {
            return BOMB02;
        }

    }

}

