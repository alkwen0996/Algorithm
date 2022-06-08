package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1927 {

    private static final String ZERO = "0";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int countOfOperation = Integer.parseInt(bufferedReader.readLine());

        final Queue<Integer> priorityQueue = new PriorityQueue<>();
        final int[] inputNumbers = new int[countOfOperation];

        for (int i = 0; i < countOfOperation; i++) {
            inputNumbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        final StringBuilder stringBuilder = new StringBuilder();

        for (int inputNumber : inputNumbers) {
            if (inputNumber == 0) {
                if (priorityQueue.size() == 0) {
                    stringBuilder.append(ZERO).append(NEW_LINE);
                    continue;
                }

                stringBuilder.append(priorityQueue.poll()).append(NEW_LINE);
                continue;
            }

            priorityQueue.add(inputNumber);
        }

        System.out.println(stringBuilder);
    }
}
