import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int x = Integer.parseInt(bufferedReader.readLine());

        Arrays.sort(numbers);
        System.out.println(solution(numbers, x));
    }

    private static int solution(final int[] numbers, final int x) {
        int count = 0;
        int front = 0;
        int end = numbers.length - 1;
        int sum;

        while (front < end) {
            sum = numbers[front] + numbers[end];

            if (sum == x) {
                count++;
            }

            if (sum <= x) {
                front++;
            } else {
                end--;
            }
        }

        return count;
    }
} // class

// 5
// 1 2 3 4 5
// 6
