package BasicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_11653 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        String result = solve(N);
        System.out.println(result);
    }

    private static String solve(final int N) {

        // 1. N의 인수 중 소수인 것들을 구한다.
        // 2. N을 나누어 나머지가 0인 소수들중 가장 작은수로 나눈다.
        // 3. 몫이 소수가 나올때까지 2번 작업 반복한다. ( 몫이 1또는 0이면 정지 )
        // 4. N이 1인경우 아무것도 출력하지 않는다.
        if (N == 1) {
            return "";
        }

        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (N % i == 0) {
                if (isPrimeFactor(i)) {
                    factors.add(i);
                }
            }
        }

        return factorization(N, factors);
    }

    private static String factorization(int N, final List<Integer> factors) {
        final StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        int share = factors.get(0);

        while (!isPrimeFactor(N / share)) {
            if (N % share != 0) {
                share = factors.get(index++);
            }
            if (N % share == 0) {
                stringBuilder.append(share).append("\n");
                N = N / share;
            }
        }
        stringBuilder.append(share).append("\n");
        if (isPrimeFactor(N / share) && !isPrimeFactor(N)) {
            stringBuilder.append(N / share).append("\n");
        }

        return stringBuilder.toString();
    }

    private static boolean isPrimeFactor(final Integer factor) {
        for (int i = 2; i < factor; i++) {
            if (factor % i == 0) {
                return false;
            }
        }
        return true;
    }
}
