package BaekJoon.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2667 {

    private static final String NEW_LINE = "\n";
    private static int[][] board;
    private static boolean[][] visitedHome;
    private static final int[] width = {1, 0, -1, 0};
    private static final int[] height = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int lineLength = Integer.parseInt(bufferedReader.readLine());

        board = new int[lineLength][lineLength];
        visitedHome = new boolean[lineLength][lineLength];

        for (int i = 0; i < lineLength; i++) {
            String line = bufferedReader.readLine();

            for (int j = 0; j < line.length(); j++) {
                final int home = Character.getNumericValue(line.charAt(j));
                board[i][j] = home;
            }
        }

        System.out.println(solution());
    }

    private static StringBuilder solution() {
        final List<Integer> homeCountInComplex = new ArrayList<>();
        final Queue<Complex> complexes = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1 && !visitedHome[i][j]) {
                    visitedHome[i][j] = true;

                    complexes.add(new Complex(i, j));
                    homeCountInComplex.add(bfs(complexes));
                }
            }
        }

        return writeResultFormat(homeCountInComplex);
    }

    private static int bfs(final Queue<Complex> complexes) {
        int complexCount = 1;

        while (!complexes.isEmpty()) {
            final Complex complex = complexes.poll();

            for (int i = 0; i < width.length; i++) {
                int x = complex.x + width[i];
                int y = complex.y + height[i];

                if (x >= 0 && y >= 0 && x < board.length && y < board.length) {
                    if (board[x][y] > 0 && !visitedHome[x][y]) {
                        visitedHome[x][y] = true;
                        complexCount++;

                        complexes.add(new Complex(x, y));
                    }
                }
            }
        }

        return complexCount;
    }

    private static StringBuilder writeResultFormat(final List<Integer> homeCountInComplex) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(homeCountInComplex.size()).append(NEW_LINE);

        Collections.sort(homeCountInComplex);

        for (Integer integer : homeCountInComplex) {
            stringBuilder.append(integer).append(NEW_LINE);
        }

        return stringBuilder;
    }

    private static class Complex {
        private int x;
        private int y;

        public Complex(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }

}
