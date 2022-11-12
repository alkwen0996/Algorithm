import java.awt.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    public static final char BOMB = '*';
    public static final char EMPTY = '.';
    public static final char ONE_MORE_BOMB = 'O';
    public static final char ZERO_BOMB = 'X';

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            final int lengthOfLine = Integer.parseInt(bufferedReader.readLine());

            final char[][] map = new char[lengthOfLine][lengthOfLine];

            for (int j = 0; j < lengthOfLine; j++) {
                final char[] inputLine = bufferedReader.readLine().toCharArray();
                System.arraycopy(inputLine, 0, map[j], 0, inputLine.length);
            }

            stringBuilder.append("#").append(i).append(" ").append(solution(map)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int solution(char[][] map) {
        // 무조건 0인 아이들을 다 클릭한 후에 빈공간인 경우를 클릭한다.
        // 숫자가 다 채워진 후에 남은 빈공간을 클릭해 나가면 최소 클릭횟수를 구할 수 있다.
        // 1. 8방탐색으로 각 칸 근처의 폭탄을 구해서 저장한다.
        // 2. map 전체를 돌면서 '.'이고 근처의 폭탄개수가 0인 칸을 클릭한다.
        // 3. 클릭한 칸을 기준으로 bfs를 통해 해당칸의 주변 폭탄의 개수가 0이고 빈칸이면 큐에 담아 탐색하고 아닐경우 큐에 담지않는다.
        // 4. 2,3번을 반복하면서 click개수를 카운팅해준다.
        // 5. 더이상 0이 없다면 남은 '.'의 개수를 기존의 click 개수에 더해준다.
        // 6. click개수를 출력한다.

        final int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
        final int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

        int minimumClickCount = 0;
        final int[][] bombCountMap = new int[map.length][map.length];

        countNearBomb(map, bombCountMap, dx, dy);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (bombCountMap[i][j] == 0) {
                    bfs(map, bombCountMap, dx, dy, new Point(i, j));
                    minimumClickCount++;
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (bombCountMap[i][j] > 0) {
                    minimumClickCount++;
                }
            }
        }

        return minimumClickCount;
    }

    private static void countNearBomb(final char[][] map, final int[][] bombCountMap, final int[] dx, final int[] dy) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                int count = 0;

                if (map[i][j] == BOMB) {
                    bombCountMap[i][j] = -1;
                    continue;
                }

                for (int k = 0; k < dx.length; k++) {
                    int nextX = i + dx[k];
                    int nextY = j + dy[k];

                    if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map.length) {
                        continue;
                    }

                    if (map[nextX][nextY] == BOMB) {
                        count++;
                    }
                }

                bombCountMap[i][j] = count;
            }
        }

    }

    private static void bfs(final char[][] map, final int[][] bombCountMap, final int[] dx, final int[] dy, final Point startPoint) {
        final Deque<Point> queue = new ArrayDeque<>();
        queue.add(startPoint);

        while (!queue.isEmpty()) {
            final Point point = queue.poll();
            map[point.x][point.y] = ZERO_BOMB;

            for (int k = 0; k < dx.length; k++) {
                int nextX = point.x + dx[k];
                int nextY = point.y + dy[k];

                if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map.length) {
                    continue;
                }

                if (bombCountMap[nextX][nextY] == -1) {
                    continue;
                }

                if (map[nextX][nextY] == EMPTY && bombCountMap[nextX][nextY] == 0) {
                    queue.add(new Point(nextX, nextY));
                }

                bombCountMap[nextX][nextY] = -1;
                map[nextX][nextY] = ONE_MORE_BOMB;
            }
        } // 시작점 좌표 기준으로 연결된 부분중 데이터가 없는부분에 대해 모두 검사.
    }

}
