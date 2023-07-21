import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static final String NEW_LINE = "\n";
    private static int n;
    private static int[][] map;
    private static List<Range> ranges;

    public static void main(String[] args) throws IOException {
        inputData();
        getPrefixSum();
    }

    private static void getPrefixSum() {
        StringBuilder stringBuilder = new StringBuilder();

        int[][] prefixSumMap = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSumMap[i][j] = prefixSumMap[i - 1][j] + prefixSumMap[i][j - 1] - prefixSumMap[i - 1][j - 1] + map[i][j];
            }
        }

        for (Range range : ranges) {
            Point start = range.start;
            Point end = range.end;

            int result = prefixSumMap[end.x][end.y] - prefixSumMap[end.x][start.y - 1] - prefixSumMap[start.x - 1][end.y] + prefixSumMap[start.x - 1][start.y - 1];
            stringBuilder.append(result).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static void inputData() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        ranges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            ranges.add(new Range(
                    new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())),
                    new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()))
            ));
        }
    }

    static class Range {
        private final Point start;
        private final Point end;

        public Range(final Point start, final Point end) {
            this.start = start;
            this.end = end;
        }
    }

}
