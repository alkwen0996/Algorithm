package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1978 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        bufferedReader.readLine();
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int count = 0;
        while (stringTokenizer.hasMoreTokens()) {
            boolean check = isPrime(Integer.parseInt(stringTokenizer.nextToken()));
            if (check) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isPrime(final int number) {
        boolean checkPrime = true;
        if (number > 3) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    checkPrime = false;
                    break;
                }
            }
        }
        if (number == 1) {
            checkPrime = false;
        }
        return checkPrime;
    }
}
