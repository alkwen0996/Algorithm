package BaekJoon.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576 {

    private static final int NO_RIPEN_TOMATO = 0;
    private static final int RIPEN_TOMATO = 1;
    private static final int[] widthSearchPosition = {1, 0, -1, 0};
    private static final int[] heightSearchPosition = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int width = Integer.parseInt(stringTokenizer.nextToken());
        final int height = Integer.parseInt(stringTokenizer.nextToken());

        final Queue<Position> ripenTomatoPositions = new LinkedList<>();
        final int[][] map = new int[height][width];

        for (int i = 0; i < height; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());

                if (map[i][j] == RIPEN_TOMATO) {
                    ripenTomatoPositions.add(new Position(i, j, 0));
                }
            }
        }

        System.out.println(bfs(map, ripenTomatoPositions, width, height));
    }

    private static int bfs(final int[][] map, final Queue<Position> ripenTomatoPositions, final int width, final int height) {
        int day = 0;

        while (!ripenTomatoPositions.isEmpty()) {
            final Position position = ripenTomatoPositions.poll();
            day = position.day;

            for (int i = 0; i < widthSearchPosition.length; i++) {
                int nextPositionX = position.x + widthSearchPosition[i];
                int nextPositionY = position.y + heightSearchPosition[i];

                if (nextPositionX >= 0 && nextPositionY >= 0 && nextPositionY < width && nextPositionX < height) {
                    if (map[nextPositionX][nextPositionY] == NO_RIPEN_TOMATO) {
                        map[nextPositionX][nextPositionY] = RIPEN_TOMATO;
                        ripenTomatoPositions.add(new Position(nextPositionX, nextPositionY, day + 1));
                    }
                }
            }
        }

        if (searchNoRipen(map)) {
            return -1;
        }

        return day;
    }

    private static boolean searchNoRipen(final int[][] map) {
        for (final int[] tomato : map) {
            for (int j = 0; j < map[0].length; j++) {
                if (tomato[j] == NO_RIPEN_TOMATO) {
                    return true;
                }
            }
        }

        return false;
    }

    private static class Position {
        private int x;
        private int y;
        private int day;

        public Position(final int x, final int y, final int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

}
