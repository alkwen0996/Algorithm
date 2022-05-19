package BaekJoon.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {

    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int vertex = Integer.parseInt(stringTokenizer.nextToken());
        final int edge = Integer.parseInt(stringTokenizer.nextToken());
        final int startVertex = Integer.parseInt(stringTokenizer.nextToken());

        final List<List<Integer>> relations = new ArrayList<>();

        for (int i = 0; i <= vertex; i++) {
            relations.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int vertex1 = Integer.parseInt(stringTokenizer.nextToken());
            final int vertex2 = Integer.parseInt(stringTokenizer.nextToken());

            relations.get(vertex1).add(vertex2);
            relations.get(vertex2).add(vertex1);
        }

        for (List<Integer> relation : relations) {
            Collections.sort(relation);
        }

        stringBuilder = new StringBuilder();
        boolean[] visitedVertex = new boolean[vertex + 1];

        dfs(startVertex, relations, visitedVertex);

        stringBuilder.append(NEW_LINE);
        visitedVertex = new boolean[vertex + 1];

        bfs(startVertex, relations, visitedVertex);

        System.out.println(stringBuilder);
    }

    private static void bfs(final int startVertex, final List<List<Integer>> relations, final boolean[] visitedVertex) {
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(startVertex);
        visitedVertex[startVertex] = true;

        while (!queue.isEmpty()) {
            int relation = queue.poll();
            stringBuilder.append(relation).append(SPACE);

            for (int i = 0; i < relations.get(relation).size(); i++) {
                int checkRelation = relations.get(relation).get(i);

                if (visitedVertex[checkRelation]) {
                    continue;
                }

                visitedVertex[checkRelation] = true;
                queue.add(checkRelation);
            }
        }

    }

    private static void dfs(final int startVertex, final List<List<Integer>> relations, final boolean[] visitedVertex) {
        if (visitedVertex[startVertex]) {
            return;
        }

        visitedVertex[startVertex] = true;
        stringBuilder.append(startVertex).append(SPACE);

        for (int i = 0; i < relations.get(startVertex).size(); i++) {
            dfs(relations.get(startVertex).get(i), relations, visitedVertex);
        }
    }

}
