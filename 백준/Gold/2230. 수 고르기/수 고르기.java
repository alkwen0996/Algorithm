import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(numbers);
        System.out.println(solution(numbers, m));
    }

    private static int solution(final int[] numbers, final int m) {
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;

        while (start <= end && end < numbers.length) {
            if (numbers[end] - numbers[start] >= m) {
                min = Math.min(min, numbers[end] - numbers[start]);
                start++;
                continue;
            }

            end++;
        }

        return min;
    }
} // class
