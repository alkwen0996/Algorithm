package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1748 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String n = bufferedReader.readLine();

        int result = solution(n);
        System.out.println(result);
    }

    private static int solution(final String n) {
        int totalNumberLength = 0;
        int maxNumber = Integer.parseInt(n);
        int eachNumberLength = 1;
        int unit = 10;

        for (int i = 1; i <= maxNumber; i++) {
            if (i % unit == 0) {
                eachNumberLength++;
                unit *= 10;
            }

            totalNumberLength += eachNumberLength;
        }

        return totalNumberLength;
    }
}
