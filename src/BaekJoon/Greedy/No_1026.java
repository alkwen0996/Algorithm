package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1026 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final Queue<Integer> arrayA = new PriorityQueue<>();
        final Deque<Integer> arrayB = new ArrayDeque<>();
        final int N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            arrayA.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int j = 0; j < N; j++) {
            arrayB.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int result = solution(arrayA, arrayB);
        System.out.println(result);
    }

    private static int solution(final Queue<Integer> arrayA, final Deque<Integer> arrayB) {
        int minimum = 0;

        while (!arrayA.isEmpty()) {
            int minA = arrayA.poll();
            int maxB = arrayB.stream()
                    .mapToInt(a -> a)
                    .max()
                    .getAsInt();

            minimum = minimum + (minA * maxB);

            removeArrayBMaxValue(arrayB, maxB);
        }

        return minimum;
    }

    private static void removeArrayBMaxValue(final Deque<Integer> arrayB, final int maxB) {
        int checkMaxNumber = arrayB.poll();

        while (maxB != checkMaxNumber) {
            arrayB.add(checkMaxNumber);
            checkMaxNumber = arrayB.poll();
        }

    }
}

