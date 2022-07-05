package BaekJoon.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int countOfNumber = Integer.parseInt(stringTokenizer.nextToken());
        final int countOfSelectNumber = Integer.parseInt(stringTokenizer.nextToken());

        final Queue<Integer> numbers = new LinkedList<>();
        final List<Integer> orderOfExtraction = new ArrayList<>();

        for (int i = 1; i <= countOfNumber; i++) {
            numbers.offer(i);
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < countOfSelectNumber; i++) {
            orderOfExtraction.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        System.out.println(solve(numbers, orderOfExtraction));
        ;
    }

    private static int solve(final Queue<Integer> numbers, final List<Integer> orderOfExtraction) {
        int numberOfOperation = 0;

        for (Integer number : orderOfExtraction) {
            if (number.equals(numbers.peek())) {
                numbers.poll();
                continue;
            }

            int changeOrderCount = 0;

            while (!numbers.isEmpty() && !number.equals(numbers.peek())) {
                numbers.offer(numbers.poll());
                changeOrderCount++;
            }

            changeOrderCount = Math.min(changeOrderCount, Math.abs(numbers.size() - changeOrderCount));

            numbers.poll();
            numberOfOperation += changeOrderCount;
        }

        return numberOfOperation;
    }

}
