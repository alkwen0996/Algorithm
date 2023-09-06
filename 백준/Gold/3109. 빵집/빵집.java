import java.awt.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static final String NEW_LINE = "\n";
    public static final String SPACE = " ";
    public static final char Building = 'x';
    public static final char PIPE = '-';

    public static int[] moveX = {-1, 0, 1};
    public static int[] moveY = {1, 1, 1};
    public static int R, C, pipelineCount;
    public static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] line = bufferedReader.readLine().toCharArray();
            System.arraycopy(line, 0, map[i], 0, C);
        }

        solution();
        System.out.println(pipelineCount);
    }

    private static void solution() {
        pipelineCount = 0;

        for (int i = 0; i < R; i++) {
            map[i][0] = PIPE;
            installPipeLine(new Point(i, 0));
        }

    }

    private static boolean installPipeLine(final Point point) {
        if (point.y == C - 1) {
            pipelineCount++;

            return true;
        }

        for (int i = 0; i < moveX.length; i++) {
            int nextX = point.x + moveX[i];
            int nextY = point.y + moveY[i];

            if (nextX >= R || nextY >= C || nextX < 0 || nextY < 0) {
                continue;
            }

            if (map[nextX][nextY] == Building) {
                continue;
            }

            if (map[nextX][nextY] == PIPE) {
                continue;
            }

            map[nextX][nextY] = PIPE;

            if (installPipeLine(new Point(nextX, nextY))) {
                return true;
            }
        }

        return false;
    }

}