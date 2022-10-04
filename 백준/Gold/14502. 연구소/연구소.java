
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

    private static int[][] originalMap;
    private static int maximumSafetyAreaCount, height, width; // 최대 안전 지역 개수

    private static final int[] horizontalDirection = {1, 0, -1, 0};
    private static final int[] verticalDirection = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        height = Integer.parseInt(stringTokenizer.nextToken());
        width = Integer.parseInt(stringTokenizer.nextToken());

        originalMap = new int[height][width];
        maximumSafetyAreaCount = Integer.MIN_VALUE;

        for (int i = 0; i < height; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < width; j++) {
                originalMap[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        selectBlanks(3, 0);
        System.out.println(maximumSafetyAreaCount);
    }

    private static void selectBlanks(final int wallCount, final int index) {
        if (wallCount == index) {
            maximumSafetyAreaCount = Math.max(spreadVirus(), maximumSafetyAreaCount);

            return;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (originalMap[i][j] == 0) {
                    originalMap[i][j] = 1;
                    selectBlanks(wallCount, index + 1);
                    originalMap[i][j] = 0;
                }
            }
        }

    }

    private static int countSafetyArea(final int[][] copyMap) {
        int safetyAreaCount = 0;

        for (final int[] row : copyMap) {
            for (int j = 0; j < copyMap[0].length; j++) {
                if (row[j] == 0) {
                    safetyAreaCount++;
                }
            }
        }

        return safetyAreaCount;
    }

    private static int spreadVirus() {
        final Deque<Point> queue = new ArrayDeque<>();
        final int[][] copyMap = new int[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (originalMap[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }

        copyMap(copyMap);

        while (!queue.isEmpty()) {
            for (int i = 0, size = queue.size(); i < size; i++) {
                final Point virusPoint = queue.poll();

                final int currentX = virusPoint.x;
                final int currentY = virusPoint.y;

                for (int j = 0; j < horizontalDirection.length; j++) {
                    final int nextX = currentX + horizontalDirection[j];
                    final int nextY = currentY + verticalDirection[j];

                    if (nextX < 0 || nextY < 0 || nextX >= height || nextY >= width) {
                        continue;
                    }

                    if (copyMap[nextX][nextY] == 1 || copyMap[nextX][nextY] == 2) {
                        continue;
                    }

                    queue.add(new Point(nextX, nextY));
                    copyMap[nextX][nextY] = 2;
                }
            }

        }

        return countSafetyArea(copyMap);
    }

    private static void copyMap(final int[][] copyMap) {
        for (int i = 0; i < copyMap.length; i++) {
            System.arraycopy(originalMap[i], 0, copyMap[i], 0, originalMap[i].length);
        }
    }

}
