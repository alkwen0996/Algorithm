package BaekJoon.Function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_15596 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int arrayLength = Integer.parseInt(bufferedReader.readLine());
        int[] a = new int[arrayLength];
        long sum = sum(a);
        System.out.println(sum);
    }

    private static long sum(int[] a) {
        return Arrays.stream(a)
                .mapToObj(Long::valueOf)
                .reduce(0L,Long::sum);
    }
}
