package BaekJoon.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {

    private static int[][] board;
    private static boolean[][] visited;
    private static int[] widthPosition = {1, 0, -1, 0};
    private static int[] heightPosition = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int height = Integer.parseInt(stringTokenizer.nextToken());
        final int width = Integer.parseInt(stringTokenizer.nextToken());

        board = new int[height][width];
        visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            String line = bufferedReader.readLine();

            for (int j = 0; j < width; j++) {
                board[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        bfs(height, width);
        System.out.println(board[height - 1][width - 1]);
    }

    private static void bfs(final int height, final int width) {
        final Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            final Position position = queue.poll();

            for (int i = 0; i < widthPosition.length; i++) {
                int positionX = position.x + widthPosition[i];
                int positionY = position.y + heightPosition[i];

                if (positionX >= 0 && positionY >= 0 && positionX < height && positionY < width) {
                    if (board[positionX][positionY] == 1 && !visited[positionX][positionY]) {
                        board[positionX][positionY] = board[position.x][position.y] + 1;
                        visited[positionX][positionY] = true;
                        queue.add(new Position(positionX, positionY));
                    }
                }
            }

        }

    }

    private static class Position {
        private int x;
        private int y;

        public Position(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}
