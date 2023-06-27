import java.awt.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int height = Integer.parseInt(stringTokenizer.nextToken());
        final int width = Integer.parseInt(stringTokenizer.nextToken());
        final int[][] array = new int[height][width];

        for (int i = 0; i < height; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < width; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        final List<Range> rangeList = new ArrayList<>();
        final int lineCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < lineCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            rangeList.add(new Range(
                    new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())),
                    new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()))
            ));
        }

        calculateSum(array, rangeList);
    }

    private static void calculateSum(final int[][] array, final List<Range> rangeList) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (final Range range : rangeList) {
            final Point startPoint = range.startPoint;
            final Point endPoint = range.endPoint;

            int sum = 0;

            for (int j = startPoint.x; j <= endPoint.x; j++) {
                for (int k = startPoint.y; k <= endPoint.y; k++) {
                    sum += array[j-1][k-1];
                }
            }

            stringBuilder.append(sum).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    static class Range{
        private Point startPoint;
        private Point endPoint;

        public Range(final Point startPoint, final Point endPoint) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }
    }

}
