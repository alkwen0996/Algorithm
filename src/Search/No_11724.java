package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_11724 {
    private static int[][] peeks;
    private static boolean[] checkVisited;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int peekCount = Integer.parseInt(stringTokenizer.nextToken());
        final int linkCount = Integer.parseInt(stringTokenizer.nextToken());

        peeks = new int[peekCount + 1][peekCount + 1];
        checkVisited = new boolean[peekCount + 1];

        for (int i = 0; i < linkCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int peek1 = Integer.parseInt(stringTokenizer.nextToken());
            int peek2 = Integer.parseInt(stringTokenizer.nextToken());
            peeks[peek1][peek2] = peeks[peek2][peek1] = 1;
        }

        int result = solution();
        System.out.println(result);
    }

    private static int solution() {
        int start = 1;
        int count = 0;

        for (int i = 1; i < checkVisited.length; i++) {
            if (!checkVisited[i]) {
                start = i;
                if (bfs(start)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean bfs(final int start) {
        final Queue<Integer> visitPeeks = new LinkedList<>();

        visitPeeks.add(start);
        checkVisited[start] = true;

        if (!checkVisited[start]) {
            return false;
        } else {
            while (!visitPeeks.isEmpty()) {

                int visitPeek = visitPeeks.poll();
                for (int i = 1; i < peeks.length; i++) {

                    if (peeks[visitPeek][i] == 1 && !checkVisited[i]) {
                        visitPeeks.add(i);
                        checkVisited[i] = true;
                    }
                }
            }
            return true;
        }

    }
}
