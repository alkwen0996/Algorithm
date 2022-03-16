package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17425 {
    private static final int MAX_SIZE = 1_000_001;
    private static final String NEW_LINE = "\n";

    // 배수의 개념 이용
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCase = Integer.parseInt(bufferedReader.readLine());

        long[] sumDivisorsOfEachNumber = new long[MAX_SIZE + 1];
        // 전체 범위에 대하여 약수의 합을 구해두고 거기서 케이스별 약수의 합 값을 찾는다. = 문제에서 f(i)값
        // 시간복잡도 : NlogN

        for (int i = 1; i <= MAX_SIZE; i++) {
            sumDivisorsOfEachNumber[i] = 1;
        } // 모든수는 1을 약수로 갖기때문에 채워넣음

        for (int i = 2; i <= MAX_SIZE; i++) { // i를 약수로 갖는 모든 수
            for (int j = 1; i * j <= MAX_SIZE; j++) { // i의 배수를 모두 찾음.
                sumDivisorsOfEachNumber[i * j] += i; // f(N) 에서 N에 i의 배수 개념을 적용
            }
        }

        long[] sum = new long[MAX_SIZE + 1];
        // sum[i] = D[1]+D[2]+...D[i] 즉, sum[i] 는 D[1] ~ D[i] 까지의 합.
        // 문제에서 g(i)값

        for (int i = 1; i <= MAX_SIZE; i++) {
            sum[i] = sum[i - 1] + sumDivisorsOfEachNumber[i];
        }

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            int inputValue = Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(sum[inputValue]).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }
}
