
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
    private static int count;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            final int studentCount = Integer.parseInt(bufferedReader.readLine());
            final int compareCount = Integer.parseInt(bufferedReader.readLine());

            final int[][] relations = new int[studentCount + 1][studentCount + 1];
            final int[][] reverseRelations = new int[studentCount + 1][studentCount + 1];
            StringTokenizer stringTokenizer;

            for (int j = 1; j <= compareCount; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                final int smallTall = Integer.parseInt(stringTokenizer.nextToken());
                final int bigTall = Integer.parseInt(stringTokenizer.nextToken());

                relations[smallTall][bigTall] = 1;
                reverseRelations[bigTall][smallTall] = 1;
            }

            int result = 0;

            for (int j = 1; j <= studentCount; j++) {
                count = 0;
                bfs(relations, j);
                bfs(reverseRelations, j);
/*dfs 코드
                count = 0;
                dfs(relations, j, new boolean[relations.length]);
                dfs(reverseRelations, j, new boolean[relations.length]);
*/
                if (count == studentCount - 1) {
                    result++;
                }
            }

            stringBuilder.append("#").append(i).append(" ").append(result).append("\n");
        }

        System.out.println(stringBuilder);
    }
/*
    private static void dfs(final int[][] relations, final int vertex, final boolean[] visited) {
        visited[vertex] = true;

        for (int i = 1; i < relations.length; i++) {
            if (relations[i][vertex] == 0 || visited[i]) {
                continue;
            }

            count++;
            dfs(relations, i, visited);
        }
    }
*/

    private static void bfs(final int[][] relations, final int startVertex) {
        final Deque<Integer> queue = new ArrayDeque<>();
        final boolean[] visited = new boolean[relations.length];
        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            final Integer currentVertex = queue.poll();

            for (int i = 1; i < relations[currentVertex].length; i++) {
                if (visited[i] || relations[i][currentVertex] == 0) {
                    continue;
                }

                queue.add(i);
                visited[i] = true;
                count++;
            }
        }

    }

}
