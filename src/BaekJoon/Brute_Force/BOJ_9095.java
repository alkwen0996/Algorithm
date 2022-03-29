package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            int sum = 0;
            stringBuilder.append(solution(sum, Integer.parseInt(bufferedReader.readLine()))).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int solution(int sum, final int readLine) {
        if (sum > readLine) {
            return 0;
        }

        if (sum == readLine) {
            return 1;
        }

        int now = 0;
        for (int i = 1; i <= 3; i++) {
            now += solution(sum + i, readLine);
        }

        return now;
    }
}
