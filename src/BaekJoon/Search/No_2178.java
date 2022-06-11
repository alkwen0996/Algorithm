package BaekJoon.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_2178 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] widthSearch = {1, 0, -1, 0};
    private static int[] heightSearch = {0, 1, 0, -1};
    private static Queue<Node> route;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int M = Integer.parseInt(stringTokenizer.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] mapLine = bufferedReader.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(mapLine[j]));
            }
        }

        int shortestRoute = bfs(N, M);
        System.out.println(shortestRoute);
    }

    private static int bfs(final int N, final int M) {
        visited[0][0] = true;
        route = new LinkedList<>();
        route.add(new Node(0, 0));

        while (!route.isEmpty()) {
            Node node = route.poll();

            for (int i = 0; i < widthSearch.length; i++) {
                int positionX = node.x + widthSearch[i];
                int positionY = node.y + heightSearch[i];

                if (positionX >= 0 && positionY >= 0 && positionX < N && positionY < M) {
                    if (map[positionX][positionY] == 1 && !visited[positionX][positionY]) {
                        visited[positionX][positionY] = true;
                        map[positionX][positionY] = map[node.x][node.y] + 1;
                        route.add(new Node(positionX, positionY));
                    }
                }
            }
        }

        return map[N - 1][M - 1];
    }

    static class Node {
        private int x;
        private int y;

        public Node(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }

}
