package BaekJoon.Loop_While;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class No_1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int copy = N;
        int count = 0;

        do {
            N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
            count++;
        } while (copy != N);

        System.out.println(count);

    }
}
