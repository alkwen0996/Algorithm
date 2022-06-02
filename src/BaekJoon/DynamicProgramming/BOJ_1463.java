package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1463 {

    private static int[] memorization;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        memorization = new int[n + 1];
        Arrays.fill(memorization, -1);

        int result = createOne(n);
        System.out.println(result);
    }

    private static int createOne(int n) {
        if (n == 1) {
            return 0;
        }

        if (memorization[n] != -1) {
            return memorization[n];
        }

        memorization[n] = createOne(n - 1) + 1;

        if (n % 3 == 0) {
            int temp = createOne(n / 3) + 1;

            if(memorization[n] > temp){
                memorization[n] = temp;
            }
        }

        if (n % 2 == 0) {
            int temp = createOne(n / 2) + 1;

            if(memorization[n] > temp){
                memorization[n] = temp;
            }
        }

        return memorization[n];
    }

}
