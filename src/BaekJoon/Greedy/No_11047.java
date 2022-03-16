package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_11047 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int K = Integer.parseInt(stringTokenizer.nextToken());
        final List<Integer> coins = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            coins.add(Integer.parseInt(bufferedReader.readLine()));
        }

        int result = solve(coins, K);
        System.out.println(result);
    }

    private static int solve(final List<Integer> coins, final int k) {
        int minimumCoinCount = 0;

        int money = k;
        for (int i = coins.size() - 1; i >= 0; i--) {
            if (coins.get(i) <= money) {
                minimumCoinCount += (money / coins.get(i));
                money = k % coins.get(i);
            }
        }

        return minimumCoinCount;
    }
}
