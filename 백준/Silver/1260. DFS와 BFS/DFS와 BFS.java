import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int v = Integer.parseInt(stringTokenizer.nextToken());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int v1, v2;

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            v1 = Integer.parseInt(stringTokenizer.nextToken());
            v2 = Integer.parseInt(stringTokenizer.nextToken());

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        boolean[] isVisited = new boolean[n + 1];
        StringBuilder stringBuilder = new StringBuilder();

        dfs(graph, isVisited, v, stringBuilder);
        System.out.println(stringBuilder);

        stringBuilder = new StringBuilder();
        isVisited = new boolean[n + 1];

        bfs(graph, isVisited, v, stringBuilder);
        System.out.println(stringBuilder);
    }

    private static void bfs(final List<List<Integer>> graph, final boolean[] isVisited, final int v, final StringBuilder stringBuilder) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(v);
        isVisited[v] = true;

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            stringBuilder.append(currentVertex).append(" ");

            for (int i = 0; i < graph.get(currentVertex).size(); i++) {
                Integer nextVertex = graph.get(currentVertex).get(i);

                if (isVisited[nextVertex]) {
                    continue;
                }

                queue.add(nextVertex);
                isVisited[nextVertex] = true;
            }
        }
    }

    private static void dfs(final List<List<Integer>> graph, final boolean[] isVisited, final int v, final StringBuilder stringBuilder) {
        if (isVisited[v]) {
            return;
        }

        isVisited[v] = true;
        stringBuilder.append(v).append(" ");

        for (int i = 0; i < graph.get(v).size(); i++) {
            dfs(graph, isVisited, graph.get(v).get(i), stringBuilder);
        }
    }

} // class
