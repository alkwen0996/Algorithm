package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_2667 {
    private static final String NEW_LINE = "\n";
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[] widthSearch = {1, 0, -1, 0};
    private static final int[] heightSearch = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String homesLine = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(homesLine.charAt(j)));
            }
        }

        String result = solve(N);
        System.out.println(result);
    }

    private static String solve(final int N) {
        final List<Integer> homeCountInComplex = new ArrayList<>();
        final Queue<Complex> apartmentComplex = new LinkedList<>();

        int complexCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    complexCount++;
                    apartmentComplex.add(new Complex(i, j));

                    homeCountInComplex.add(dfs(apartmentComplex, N));
                }
            }
        }

        final StringBuilder stringBuilder = createPrintFormat(complexCount, homeCountInComplex);

        return stringBuilder.toString();
    }

    private static StringBuilder createPrintFormat(final int complexCount, final List<Integer> homeCountInComplex) {
        final StringBuilder stringBuilder = new StringBuilder();

        homeCountInComplex.sort((o1, o2) -> {
            if (o1 > o2) {
                return 1;
            } else if (o1 < o2) {
                return -1;
            }
            return 0;
        });

        stringBuilder.append(complexCount).append(NEW_LINE);

        for (int homeCount : homeCountInComplex) {
            stringBuilder.append(homeCount).append(NEW_LINE);
        }

        return stringBuilder;
    }

    private static int dfs(final Queue<Complex> apartmentComplex, final int N) {
        int homeCount = 1;

        while (!apartmentComplex.isEmpty()) {
            Complex complex = apartmentComplex.poll();

            for (int i = 0; i < widthSearch.length; i++) {
                int x = complex.x + widthSearch[i];
                int y = complex.y + heightSearch[i];

                if (x >= 0 && y >= 0 && x < N && y < N) {
                    if (map[x][y] == 1 && !visited[x][y]) {
                        visited[x][y] = true;
                        homeCount++;
                        apartmentComplex.add(new Complex(x, y));
                    }
                }

            }

        }

        return homeCount;
    }

    static class Complex {
        private int x;
        private int y;

        public Complex(final int x, final int y) {
            this.x = x;
            this.y = y;
        }

    }
}
