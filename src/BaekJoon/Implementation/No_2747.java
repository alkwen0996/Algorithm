package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_2747 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int fibonacciCount = Integer.parseInt(bufferedReader.readLine());

        int result = solution(fibonacciCount);
        System.out.println(result);
    }

    private static int solution(final int fibonacciCount) {
        final List<Integer> numbers = new ArrayList<>(fibonacciCount);
        numbers.add(0);
        numbers.add(1);

        for (int i = 2; i <= fibonacciCount; i++) {
            int number = numbers.get(i - 2) + numbers.get(i - 1);
            numbers.add(number);
        }

        return numbers.get(fibonacciCount);
    }
}
