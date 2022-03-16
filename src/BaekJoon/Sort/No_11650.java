package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_11650 {
    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());
        final Queue<Point> points = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            points.add(new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
        }

        String result = solve(points, N);
        System.out.println(result);
    }

    private static String solve(final Queue<Point> points, final int n) {
        return createPrintFormat(points);
    }

    private static String createPrintFormat(final Queue<Point> points) {
        final StringBuilder stringBuilder = new StringBuilder();

        while (!points.isEmpty()) {
            Point point = points.poll();
            stringBuilder.append(point.x)
                    .append(SPACE)
                    .append(point.y)
                    .append(NEW_LINE);
        }

        return stringBuilder.toString();
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        public Point(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point point) {
            if (point.x > this.x) {
                return -1;
            } else if (point.x < this.x) {
                return 1;
            } else {
                return Integer.compare(this.y, point.y);
            }
        }

    }

}
