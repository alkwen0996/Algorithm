package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_17103 {
    static final int primeNumberSize = 1_000_000;
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean[] primeNumbers = new boolean[primeNumberSize + 1];

        primeNumbers[0] = primeNumbers[1] = true;

        for (int i = 2; i * i <= primeNumberSize; i++) {
            if (!primeNumbers[i]) {
                for (int j = i + i; j <= primeNumberSize; j += i) {
                    primeNumbers[j] = true;
                }
            }
        }

        int lineCnt = Integer.parseInt(bufferedReader.readLine());
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < lineCnt; i++) {
            int count = 0;
            int num = Integer.parseInt(bufferedReader.readLine());

            for (int j = 2; j <= num / 2; j++) {
                if (!primeNumbers[j] && !primeNumbers[num - j])
                    count++;
            }

            stringBuilder.append(count).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }//main
}
