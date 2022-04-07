package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10819 {
    private static int maximum = Integer.MIN_VALUE;
    private static int[] arrayA;
    private static int[] changeArray;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        arrayA = new int[n];
        changeArray = new int[n];
        visited = new boolean[n];
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            arrayA[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int index = 0;
        Arrays.sort(arrayA);

        findMaximumPermutation(index);
        System.out.println(maximum);
    }

    private static void findMaximumPermutation(final int index) {
        if (index == arrayA.length) {
            int sum = 0;

            for (int i = 0; i < changeArray.length - 1; i++) {
                sum += Math.abs(changeArray[i] - changeArray[i + 1]);
            }

            maximum = Math.max(sum, maximum);

            return;
        }

        for (int i = 0; i < arrayA.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            changeArray[index] = arrayA[i];
            findMaximumPermutation(index + 1);
            visited[i] = false;
        }

    }

}
