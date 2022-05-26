package BaekJoon.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1707 {

    private static final String YES = "YES";
    private static final String NEW_LINE = "\n";
    private static final String NO = "NO";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            final List<List<Integer>> graph = new ArrayList<>();

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            final int vertex = Integer.parseInt(stringTokenizer.nextToken());
            final int edge = Integer.parseInt(stringTokenizer.nextToken());

            for (int j = 0; j < vertex + 1; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < edge; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                final int firstRelation = Integer.parseInt(stringTokenizer.nextToken());
                final int secondRelation = Integer.parseInt(stringTokenizer.nextToken());

                graph.get(firstRelation).add(secondRelation);
                graph.get(secondRelation).add(firstRelation);
            }

            final int[] visitedVertex = new int[vertex + 1];
            boolean bipartiteGraph = true;

            for (int startIndex = 1; startIndex < graph.size(); startIndex++) {
                if (visitedVertex[startIndex] == 0) {
                    if (bfs(startIndex, graph, visitedVertex)) {
                        bipartiteGraph = false;
                        break;
                    }
                }
            }

            if (bipartiteGraph) {
                stringBuilder.append(YES).append(NEW_LINE);
                continue;
            }

            stringBuilder.append(NO).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static boolean bfs(final int startIndex, final List<List<Integer>> graph, final int[] visitedVertex) {
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex);
        visitedVertex[startIndex] = 1;

        while (!queue.isEmpty()) {
            final int vertex = queue.poll();

            for (int i = 0; i < graph.get(vertex).size(); i++) {
                final int checkConnectedVertex = graph.get(vertex).get(i);

                if (visitedVertex[vertex] == visitedVertex[checkConnectedVertex]) {
                    return true;
                }

                if (visitedVertex[checkConnectedVertex] == 0) {
                    visitedVertex[checkConnectedVertex] = 3 - visitedVertex[vertex];
                    queue.add(checkConnectedVertex);
                }
            }
        }

        return false;
    }

}
