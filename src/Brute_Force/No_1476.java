package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1476 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int earth = Integer.parseInt(stringTokenizer.nextToken());
        final int sun = Integer.parseInt(stringTokenizer.nextToken());
        final int moon = Integer.parseInt(stringTokenizer.nextToken());

        int result = solution(earth, sun, moon);
        System.out.println(result);
    }

    private static int solution(final int earth, final int sun, final int moon) {
        int earthIndex = 1;
        int sunIndex = 1;
        int moonIndex = 1;
        int count = 1;

        while (!(earthIndex == earth && sunIndex == sun && moonIndex == moon)) {
            if (earthIndex == 15) {
                earthIndex = 0;
            }
            if (sunIndex == 28) {
                sunIndex = 0;
            }
            if (moonIndex == 19) {
                moonIndex = 0;
            }
            earthIndex++;
            sunIndex++;
            moonIndex++;
            count++;
        }

        return count;
    }
}
