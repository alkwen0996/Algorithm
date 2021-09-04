package Basic_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2292 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bufferedReader.readLine());

        int result = solve(input);
        System.out.println(result);
    }

    private static int solve(final int input) {
        int sum = 1;
        int idx = 1;
        while (sum < input) {
            sum = sum + (6 * idx);
            idx++;
        }

        return idx;
    }
}
