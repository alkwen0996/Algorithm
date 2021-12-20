package Breadth_First_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_2178 {
    private static int[][] maze;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int rowSize = Integer.parseInt(stringTokenizer.nextToken());
        final int columnSize = Integer.parseInt(stringTokenizer.nextToken());

        maze = new int[rowSize + 1][columnSize + 1];
        visited = new boolean[101];

        for (int i = 0; i < rowSize; i++) {
            String inputLine = bufferedReader.readLine();
            for (int j = 0; j < columnSize; j++) {
                maze[i][j] = Integer.parseInt(String.valueOf(inputLine.charAt(j)));
            }
        }

        int result = solution();
        System.out.println(result);
    }

    private static int solution() {
        int startPoint = 1;

        return bfs(startPoint);
    }

    private static int bfs(final int startPoint) {
        int visitedAreaCount = 0;
        final Queue<Integer> areas = new LinkedList<>();

        areas.add(startPoint);
        visited[1] = true;

        while (!areas.isEmpty()) {
            int visitedArea = areas.poll();
            for (int i = 1; i < maze.length; i++) {
                if (maze[visitedArea][i] == 1 && !visited[i]) {
                    areas.add(i);
                    visited[i] = true;
                    visitedAreaCount++;
                }
            }
        }

        System.out.println("visitedAreaCount: " + visitedAreaCount);

        return visitedAreaCount;
    }
}
