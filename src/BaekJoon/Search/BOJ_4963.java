package BaekJoon.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {

    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int width = Integer.parseInt(stringTokenizer.nextToken());
        int height = Integer.parseInt(stringTokenizer.nextToken());

        final StringBuilder stringBuilder = new StringBuilder();

        while (width != 0 && height != 0) {
            final int[][] board = new int[height][width];
            int islandCount = 0;

            if (width == 1 && height == 1) {
                if (Integer.parseInt(bufferedReader.readLine()) == 1) {
                    islandCount = 1;
                }

                stringBuilder.append(islandCount).append(NEW_LINE);
            } else {
                stringBuilder.append(bfs(board)).append(NEW_LINE);
            }

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            width = Integer.parseInt(stringTokenizer.nextToken());
            height = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(stringBuilder);
    }

    private static int bfs(final int[][] board) {
        final Queue<Position> queue = new LinkedList<>();


        while(!queue.isEmpty()){

        }

        return 0;
    }

    static class Position{
        private int x;
        private int y;

        public Position(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }

}
