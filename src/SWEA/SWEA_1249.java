package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_1249 {

    private static final String SHARP = "#";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    private static int[][] board;
    private static int[][] costBoard;
    private static boolean[][] visited;
    private static int[] width = {0, 1, 0, -1};
    private static int[] height = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception, IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int numberOfTestCase = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numberOfTestCase; i++) {
            final int lengthOfBoard = Integer.parseInt(bufferedReader.readLine());
            board = new int[lengthOfBoard][lengthOfBoard];
            costBoard = new int[lengthOfBoard][lengthOfBoard];
            visited = new boolean[board.length][board.length];

            for (int j = 0; j < board.length; j++) {
                final String line = bufferedReader.readLine();

                for (int k = 0; k < line.length(); k++) {
                    board[j][k] = Character.getNumericValue(line.charAt(k));
                }
            }

            stringBuilder.append(SHARP).append(i + 1).append(SPACE).append(bfs()).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int bfs() {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Position position = queue.poll();

            for (int i = 0; i < width.length; i++) {
                int x = position.x + width[i];
                int y = position.y + height[i];

                if (x < 0 || y < 0 || x >= board.length || y >= board.length) {
                    continue;
                }

                if (!visited[x][y] || costBoard[x][y] > costBoard[position.x][position.y] + board[x][y]) {
                    costBoard[x][y] = costBoard[position.x][position.y] + board[x][y];
                    visited[x][y] = true;
                    queue.add(new Position(x, y));
                }
            }

        }

        return costBoard[costBoard.length - 1][costBoard.length - 1];
    }

    static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }

}
