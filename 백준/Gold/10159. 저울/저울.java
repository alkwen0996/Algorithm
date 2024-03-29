import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(bufferedReader.readLine());
        final int M = Integer.parseInt(bufferedReader.readLine());

        final int[][] graph = new int[N + 1][N + 1];
        final int[][] reverseGraph = new int[N + 1][N + 1];
        StringTokenizer stringTokenizer;

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int heavy = Integer.parseInt(stringTokenizer.nextToken());
            final int light = Integer.parseInt(stringTokenizer.nextToken());

            graph[heavy][light] = 1;
            reverseGraph[light][heavy] = 1;
        }

        FloydWarshall(graph, reverseGraph);
    }

    private static void FloydWarshall(final int[][] graph, final int[][] reverseGraph) {
        for (int k = 1; k < graph.length; k++) {
            for (int i = 1; i < graph.length; i++) {
                for (int j = 1; j < graph[0].length; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }

                    if (reverseGraph[i][k] == 1 && reverseGraph[k][j] == 1) {
                        reverseGraph[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 1; i < reverseGraph.length; i++) {
            for (int j = 1; j < reverseGraph[0].length; j++) {
                if (reverseGraph[i][j] == 1) {
                    graph[i][j] = 1;
                }
            }
        }

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i < graph.length; i++) {
            int count = 0;

            for (int j = 1; j < graph[0].length; j++) {
                if (i == j) {
                    continue;
                }

                if (graph[i][j] != 1) {
                    count++;
                }
            }

            stringBuilder.append(count).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

}
