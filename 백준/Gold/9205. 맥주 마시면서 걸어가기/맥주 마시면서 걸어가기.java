import java.awt.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            List<Point> points = new ArrayList<>();

            StringTokenizer stringTokenizer;

            for (int j = 0; j < n + 2; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                points.add(new Point(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
            }

            List<List<Integer>> graph = new ArrayList<>();

            for (int j = 0; j < n + 2; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < n + 2; j++) {
                for (int k = j + 1; k < n + 2; k++) {
                    if (isManhattanDistance(points.get(j), points.get(k))) {
                        graph.get(j).add(k);
                        graph.get(k).add(j);
                    }
                }
            }

            stringBuilder.append(goFestival(graph, n)).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static String goFestival(final List<List<Integer>> graph, final int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);

        boolean[] isVisited = new boolean[n + 2];
        isVisited[0] = true;

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();

            if (vertex == n + 1) {
                return "happy";
            }

            for (int i = 0; i < graph.get(vertex).size(); i++) {
                Integer nextVertex = graph.get(vertex).get(i);

                if (isVisited[nextVertex]) {
                    continue;
                }

                isVisited[nextVertex] = true;
                queue.add(nextVertex);
            }
        }

        return "sad";
    }

    private static boolean isManhattanDistance(final Point point1, final Point point2) {
        return (Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y)) <= 1000;
    }

}
