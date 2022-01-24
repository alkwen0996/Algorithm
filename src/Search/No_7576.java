package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_7576 {
    private static final int STATUS_NO_RIPEN = 0;
    private static final int STATUS_RIPEN = 1;
    private static int[][] tomatoField;
    private static Queue<Tomato> ripenTomatoes;
    private static int[] searchWidth = {1, 0, -1, 0};
    private static int[] searchHeight = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int M = Integer.parseInt(stringTokenizer.nextToken());

        ripenTomatoes = new LinkedList<>();
        tomatoField = new int[M][N];

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                tomatoField[i][j] = Integer.parseInt(stringTokenizer.nextToken());

                if (tomatoField[i][j] == STATUS_RIPEN) {
                    ripenTomatoes.add(new Tomato(i, j, 0));
                }
            }
        }

        int count = solve(M, N);
        System.out.println(count);
    }

    private static int solve(final int m, final int n) {
        int day = 0;

        while (!ripenTomatoes.isEmpty()) {
            Tomato tomato = ripenTomatoes.poll();
            day = tomato.day;

            for (int i = 0; i < searchWidth.length; i++) {
                int x = tomato.x + searchWidth[i];
                int y = tomato.y + searchHeight[i];

                if (x < m && y < n && x >= 0 && y >= 0) {
                    if (tomatoField[x][y] == STATUS_NO_RIPEN) {
                        tomatoField[x][y] = STATUS_RIPEN;
                        ripenTomatoes.add(new Tomato(x, y, day + 1));
                    }
                }
            }

        }

        if (searchNoRipen(m, n)) {
            return -1;
        }

        return day;
    }

    private static boolean searchNoRipen(final int m, final int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tomatoField[i][j] == STATUS_NO_RIPEN) {
                    return true;
                }
            }
        }

        return false;
    }

    static class Tomato {
        private int x;
        private int y;
        private int day;

        public Tomato(final int x, final int y, final int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

}
