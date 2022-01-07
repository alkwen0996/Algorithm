package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class No_2164 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());

        Deque<Integer> numbers = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            numbers.add(i);
        }

        int result = solve(numbers);
        System.out.println(result);
    }

    private static int solve(final Deque<Integer> numbers) {
        while (numbers.size() > 1) {
            numbers.pop();
            numbers.add(numbers.pop());
        }

        return numbers.pop();
    }
}
