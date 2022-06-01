package BaekJoon.Brute_Force.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663 {

    private static int minimumNumberOfWay = 0;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int queenCount = Integer.parseInt(bufferedReader.readLine());

        visited = new int[queenCount];

        int depth = 0;
        countNumberOfWay(queenCount, depth);

        System.out.println(minimumNumberOfWay);
    }

    private static void countNumberOfWay(final int queenCount, final int depth) {
        if (depth == queenCount) {
            minimumNumberOfWay++;

            return;
        }

        for (int i = 0; i < queenCount; i++) {
            visited[depth] = i;

            if (checkPosition(depth)) {
                countNumberOfWay(queenCount, depth + 1);
            }
        }

    }

    private static boolean checkPosition(final int depth) {
        for (int i = 0; i < depth; i++) {
            if (visited[depth] == visited[i]) {
                return false;
            }

            if (Math.abs(depth - i) == Math.abs(visited[depth] - visited[i])) {
                return false;
            }
        }

        return true;
    }
}
