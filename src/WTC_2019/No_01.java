package WTC_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_01 {
    public static final int SIZE = 9;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(bufferedReader.readLine());

        int[] result = solve(money);

        for (final int j : result) {
            System.out.print(j);
        }
    }

    private static int[] solve(int money) {
        int[] result = new int[SIZE];
        int[] currencies = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < currencies.length; i++) {
            int share = money / currencies[i];
            result[i] = Math.max(share, 0);
            money = money % currencies[i];
        }

        return result;
    }
}
