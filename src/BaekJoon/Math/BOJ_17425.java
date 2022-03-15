package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_17425 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        final int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            final int number = Integer.parseInt(bufferedReader.readLine());

            int sum = 0;

            for (int j = 1; j <= number; j++) {
                sum += (number / j) * j;
            }

            bufferedWriter.write(sum);
        }
    }
}
