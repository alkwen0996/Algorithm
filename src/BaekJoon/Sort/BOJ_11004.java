package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11004 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int k = Integer.parseInt(stringTokenizer.nextToken());

        final int[] array = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(array);
        System.out.println(array[k-1]);
    }
}
