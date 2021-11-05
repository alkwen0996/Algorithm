package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No_11399 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final List<Integer> times = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            times.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int result = solve(times);
        System.out.println(result);
    }

    private static int solve(final List<Integer> times) {
        final List<Integer> accumulatedTimes = new ArrayList<>();

        Collections.sort(times);
        accumulatedTimes.add(times.get(0));

        for (int i = 1; i < times.size(); i++) {
            accumulatedTimes.add(accumulatedTimes.get(i - 1) + times.get(i));
        }

        return accumulatedTimes.stream().mapToInt(a -> a).sum();
    }
}
