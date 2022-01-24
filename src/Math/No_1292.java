package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1292 {
    private static int[] progression;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int a = Integer.parseInt(stringTokenizer.nextToken());
        final int b = Integer.parseInt(stringTokenizer.nextToken());
        progression = new int[1001];

        int result = solve(a, b, progression);
        System.out.println(result);
    }

    private static int solve(final int a, final int b, final int[] progression) {
        int number = 1;
        int count = 1;

        for (int i = 1; i < progression.length; i++) {
            progression[i] = number;

            if (number == count) {
                number++;
                count = 1;
            } else {
                count++;
            }
        }

        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += progression[i];
        }

        return sum;
    }
}
