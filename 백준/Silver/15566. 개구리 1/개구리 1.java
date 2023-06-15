import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final String SPACE = " ";
    public static final String NEW_LINE = "\n";
    private static int[][] flog, like, tree;
    private static int[] sel;
    private static boolean[] visited;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        flog = new int[N][4];
        like = new int[N][2];
        tree = new int[M][3];

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < 4; j++) {
                flog[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            like[i][0] = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            like[i][1] = Integer.parseInt(stringTokenizer.nextToken()) - 1;

            if (like[i][0] == like[i][1]) {
                like[i][1] = -1;
            }
        }

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < 3; j++) {
                tree[i][j] = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            }
        }

        sel = new int[N];
        visited = new boolean[N];
        dfs(0);

//        if (answer.equals(NO)) {
        System.out.println("NO");
//        } else {
//            final StringBuilder stringBuilder = new StringBuilder();
//
//            for (final int flog : flogs) {
//                stringBuilder.append(flog).append(SPACE);
//            }
//
//            System.out.println(answer + NEW_LINE + stringBuilder);
//        }

    }

    private static void dfs(final int depth) {
        if (sel.length == depth) {
            if (isAllCheck()) {
                String answer = "YES";

                final StringBuilder stringBuilder = new StringBuilder();

                for (final int flog : sel) {
                    stringBuilder.append(flog + 1).append(SPACE);
                }

                System.out.println(answer + NEW_LINE + stringBuilder);
                System.exit(0);
            }

            return;
        }

        for (int j = 0; j < 2; j++) {
            if (like[depth][j] == -1) {
                continue;
            }

            int index = like[depth][j];

            if (visited[index]) {
                continue;
            }

            visited[index] = true;
            sel[index] = depth;
            dfs(depth + 1);
            visited[index] = false;
        }
    }

    private static boolean isAllCheck() {
        for (final int[] relation : tree) {
            final int flowerA = relation[0];
            final int flowerB = relation[1];
            final int topic = relation[2];

            final int flogA = sel[flowerA];
            final int flogB = sel[flowerB];

            if (flog[flogA][topic] != flog[flogB][topic]) {
                return false;
            }
        }

        return true;
    }

}
