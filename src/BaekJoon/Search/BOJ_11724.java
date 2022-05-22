package BaekJoon.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724 {

    private static int connectedComponentCount = 0;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int vertex = Integer.parseInt(stringTokenizer.nextToken());
        final int edge = Integer.parseInt(stringTokenizer.nextToken());

        final List<List<Integer>> connectedComponents = new ArrayList<>();
        final boolean[] checkVertex = new boolean[vertex + 1];

        for (int i = 0; i <= vertex; i++) {
            connectedComponents.add(new ArrayList<>());
        }

        for (int i = 0; i < edge; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int first = Integer.parseInt(stringTokenizer.nextToken());
            final int second = Integer.parseInt(stringTokenizer.nextToken());

            connectedComponents.get(first).add(second);
            connectedComponents.get(second).add(first);
        }

        for (int i = 1; i < connectedComponents.size(); i++) {
            if (checkVertex[i]) {
                continue;
            }

            bfs(i, connectedComponents, checkVertex);
            connectedComponentCount++;
        }

        System.out.println(connectedComponentCount);
    }

    private static void bfs(final int startIndex, final List<List<Integer>> connectedComponents, final boolean[] checkVertex) {
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex);

        if (checkVertex[startIndex]) {
            return;
        }

        while (!queue.isEmpty()) {
            final int vertexNumber = queue.poll();

            for (int i = 0; i < connectedComponents.get(vertexNumber).size(); i++) {
                final int nextConnection = connectedComponents.get(vertexNumber).get(i);

                if (checkVertex[nextConnection]) {
                    continue;
                }

                checkVertex[nextConnection] = true;
                queue.add(nextConnection);
            }
        }

    }

}
