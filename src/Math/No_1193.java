package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1193 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int x = Integer.parseInt(bufferedReader.readLine());

        String result = solve(x);
        System.out.println(result);
    }

    private static String solve(final int x) {
        int cross_count = 1; // 현재 대각선 원소의 개수
        int prev_count_sum = 0; // 직전 대각선 원소의 개수 and 분모 또는 분자의 값.
        final StringBuilder stringBuilder = new StringBuilder();

        while (x > (prev_count_sum + cross_count)) {
            prev_count_sum += cross_count;
            cross_count++;
        }

        // 분자와 분모는 반비례, 대각선이 홀수번째 일때 아래에서 위로 진행
        // 대각선이 짝수일 때 위에서 아래로 진행.
        if (cross_count % 2 == 1) {
            stringBuilder.append(cross_count - (x - prev_count_sum) + 1).append("/").append(x - prev_count_sum);
        }

        if (cross_count % 2 == 0) {
            stringBuilder.append((x - prev_count_sum)).append("/").append(cross_count - (x - prev_count_sum) + 1);
        }

        return stringBuilder.toString();
    }
}
