package WTC_2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_01 {
    public static void main(String[] args) {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        int[] arr = {2, 1, 3, 1, 2, 1};
//        int[] arr = {3, 3, 3, 3, 3, 3};
        int[] arr = {1,2,3};

        int[] result = solution(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] solution(final int[] arr) {
        int[] result = new int[3];
        int[] input = {1, 2, 3};
        int[] count = new int[4];


        for (final int j : arr) {
            if (j == input[0]) {
                count[1]++;
            } else if (j == input[1]) {
                count[2]++;
            } else {
                count[3]++;
            }
        }

        int max = Arrays.stream(count).max().getAsInt();

        for (int i = 1; i < count.length; i++) {
            int eachDifference = max - count[i];
            result[i - 1] = eachDifference;
        }

        return result;
    }
}
