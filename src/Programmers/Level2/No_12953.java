package Programmers.Level2;

import java.util.Arrays;

public class No_12953 {
    public static void main(String[] args) {
//        int[] arr = {2, 6, 8, 14};
        int[] arr = {1, 2, 3};

        int result = solution(arr);
        System.out.println(result);
    }

    private static int solution(final int[] arr) {
        Arrays.stream(arr).sorted();

        int lcm = arr[0];

        for (int i = 1; i < arr.length; i++) {
            lcm = getLcm(lcm, arr[i]);
        }

        return lcm;
    }

    private static int getLcm(final int x, final int y) {
        return x * y / getGcd(x, y);
    }

    private static int getGcd(final int x, final int y) {
        int minimum = Math.min(x, y);
        int gcd = 0;

        for (int i = 1; i <= minimum; i++) {
            if (x % i == 0 && y % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }
}
