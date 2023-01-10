import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int k = Integer.parseInt(stringTokenizer.nextToken());

        final int[] prefixSum = new int[n + 1];
        final int[] numbers = new int[n + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
            prefixSum[i] = prefixSum[i - 1] + numbers[i];
        }

        solution(n, k, prefixSum, numbers);
    }

    private static void solution(final int n, final int k, final int[] prefixSum, final int[] numbers) {
        final Map<Integer, Integer> dp = new HashMap<>();

        long count = 0;
        for (int i = 1; i <= n; i++) {
            if(prefixSum[i] == k){
                count++;
            }

            count += dp.getOrDefault(prefixSum[i] - k, 0);
            dp.put(prefixSum[i], dp.getOrDefault(prefixSum[i], 0) + 1);
        }

        System.out.println(count);
    }

}

