package Basic_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2775 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder stringBuilder = new StringBuilder();
        int lineCount = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < lineCount; i++){
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(),"\n");
            int k = Integer.parseInt(stringTokenizer.nextToken());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int result = solve(k,n);
            stringBuilder.append(result).append("\n");
        }

        System.out.println(stringBuilder);

    }

    private static int solve(final int k, final int n) {
        // a층 b호에 살려면
        // a-1층 1~b호 사람들 수를 합한것만큼 사람들을 데려와 살아야함.
        // k층 n호에 몇명이 사는지 출력.
        // 아파트는 0층부터 있고 1호부터 있다.
        // 0층의 i호에는 i명이 산다.

        return 0;
    }
}
