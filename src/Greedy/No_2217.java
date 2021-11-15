package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_2217 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());
        final List<Integer> ropes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            ropes.add(Integer.parseInt(bufferedReader.readLine()));
        }

        int result = solution(ropes);
        System.out.println(result);
    }

    private static int solution(final List<Integer> ropes) {
        final List<Integer> weights = new ArrayList<>();

        ropes.sort((rope1, rope2) -> -rope1.compareTo(rope2));

        int count = 1;
        for (Integer rope : ropes) {
            weights.add(calculateWeight(rope, count));
            count++;
        }

        return weights.stream()
                .mapToInt(a -> a)
                .max()
                .getAsInt();
    }

    private static Integer calculateWeight(final int rope, final int count) {
        return rope * count;
    }
}
