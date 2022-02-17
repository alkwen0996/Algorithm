package Programmers.Level1;

import java.util.Arrays;

public class No_12954 {
    public static void main(String[] args) {
        int x = 10000000;
        int n = 1000;

        long[] result = solution(x, n);
        System.out.println(Arrays.toString(result));
    }

    private static long[] solution(final int x, final int n) {
        long[] answer = new long[n];

        int index = 0;
        long sum = x;

        while (index < n) {
            answer[index] = sum;
            sum += x;
            index++;
        }

        return answer;
    }
}
