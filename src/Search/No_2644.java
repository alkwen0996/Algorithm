package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_2644 {
    private static int[][] people;
    private static int[] checked;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int person1 = Integer.parseInt(stringTokenizer.nextToken());
        final int person2 = Integer.parseInt(stringTokenizer.nextToken());

        final int relationCount = Integer.parseInt(bufferedReader.readLine());

        people = new int[n + 1][n + 1];
        checked = new int[n + 1];

        for (int i = 0; i < relationCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            people[x][y] = people[y][x] = 1;
        }

        int result = solve(person1, person2, n);

        if (checked[person2] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

    private static int solve(final int person1, final int person2, final int n) {
        final Queue<Integer> relations = new LinkedList<>();
        relations.add(person1);

        while (!relations.isEmpty()) {
            final int relation = relations.poll();

            if (relation == person2) {
                break;
            }

            for (int i = 0; i <= n; i++) {
                if (people[relation][i] == 1 && checked[i] == 0) {
                    relations.add(i);
                    checked[i] = checked[relation] + 1;
                }
            }
        }

        return checked[person2];
    }
}
