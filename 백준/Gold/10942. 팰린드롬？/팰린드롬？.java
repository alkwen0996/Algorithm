import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        numbers = new int[n + 1];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        int start, end;

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            start = Integer.parseInt(stringTokenizer.nextToken());
            end = Integer.parseInt(stringTokenizer.nextToken());

            stringBuilder.append(isPalindrome(start, end)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int isPalindrome(final int start, final int end) {
        int mid = (end - start) / 2;

        for (int i = 0; i <= mid; i++) {
            if (numbers[start + i] != numbers[end - i]) {
                return 0;
            }
        }

        return 1;
    }

}
