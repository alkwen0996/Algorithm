
import java.awt.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    /*
    - 제일 낮은곳에서 제일 높은곳으로 등산로를 연결해야 한다. 이말인 즉, 제일 높은곳에서 제일 낮은곳으로 등산로를 연결해도 된다는 말이다.
    - 제일 높은 정점을 구해서 리스트에 저장한다. (복수일 가능성이 있어 리스트로 저장)
    - 땅을 팔수 있는 최대 깊이값이 주어지기 때문에 1~ 최대 깂이값만큼 땅을 팠을경우 등산로가 연결될 수 있는지 확인해야 한다.
    - 땅은 한번만 팔수있다!

     * 1. 높은 봉우리의 점들을 저장한다.
     * 2. 모든점에서 최대 깊이 K까지 깎는 탐색을 한다.
     * 3. 깎은 각각의 점을 기준으로 등산로 탐색을 수행한다.
     * 4. 2~3 작업을 반복한다.
     * */

    private static final String SHARP = "#";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static int maximumHikingTrail;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int numberOfTestCase = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer stringTokenizer;

        for (int i = 1; i <= numberOfTestCase; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int lengthOfMap = Integer.parseInt(stringTokenizer.nextToken()); // 지도의 한변
            final int maximumDigDepth = Integer.parseInt(stringTokenizer.nextToken()); // 최대 공사 가능 깊이
            final int[][] map = new int[lengthOfMap][lengthOfMap];
            int peek = Integer.MIN_VALUE; // 최고 높이의 봉우리

            for (int j = 0; j < lengthOfMap; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                for (int k = 0; k < lengthOfMap; k++) {
                    map[j][k] = Integer.parseInt(stringTokenizer.nextToken());
                    peek = Math.max(peek, map[j][k]);
                }
            }

            final List<Point> peeks = new ArrayList<>(); // 제일 높은 봉우리 들의 좌표 저장

            for (int j = 0; j < lengthOfMap; j++) {
                for (int k = 0; k < lengthOfMap; k++) {
                    if (peek == map[j][k]) {
                        peeks.add(new Point(j, k));
                    }
                }
            }

            maximumHikingTrail = Integer.MIN_VALUE;
            digPeeks(peeks, map, maximumDigDepth);

            stringBuilder.append(SHARP).append(i).append(SPACE).append(maximumHikingTrail).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static void digPeeks(final List<Point> peeks, final int[][] map, final int maximumDigDepth) {
        for (int i = 0; i <= maximumDigDepth; i++) {
            for (int j = 0; j < map.length; j++) {
                for (int k = 0; k < map.length; k++) {
                    if (map[j][k] - i < 0) {
                        continue;
                    }

                    map[j][k] -= i;

                    for (Point peek : peeks) {
                        dfs(peek, map, 1);
                    }

                    map[j][k] += i;
                }
            }
        }

    }

    private static void dfs(final Point point, final int[][] map, final int length) {
        for (int i = 0; i < dx.length; i++) {
            int nextX = point.x + dx[i];
            int nextY = point.y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map.length) {
                if (map[point.x][point.y] > map[nextX][nextY]) {
                    dfs(new Point(nextX, nextY), map, length + 1);
                }
            }
        }

        if (maximumHikingTrail < length) {
            maximumHikingTrail = length;
        }
    }

}