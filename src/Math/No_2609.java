package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2609 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int a = Integer.parseInt(stringTokenizer.nextToken());
        final int b = Integer.parseInt(stringTokenizer.nextToken());

        final int greatestCommonFactor = calculateGreatestCommonFactor(a, b);
        final int smallestCommonMultiple = (a * b) / greatestCommonFactor;

        System.out.println(greatestCommonFactor);
        System.out.println(smallestCommonMultiple);
    }

    private static int calculateGreatestCommonFactor(int a, int b) {

        while (b != 0) {
            int remain = a % b;
            a = b;
            b = remain;
        }

        return a;
    }
}
