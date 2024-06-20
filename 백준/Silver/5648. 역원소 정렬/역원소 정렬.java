import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        long[] numbers = new long[n];
        StringBuilder stringBuilder;

        for (int i = 0; i < n; i++) {
            char[] charArray = scanner.next().toCharArray();
            stringBuilder = new StringBuilder();

            for (int j = charArray.length - 1; j >= 0; j--) {
                stringBuilder.append(charArray[j]);
            }

            numbers[i] = Long.parseLong(stringBuilder.toString());
        }

        Arrays.sort(numbers);
        stringBuilder = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            stringBuilder.append(numbers[i]).append("\n");
        }

        System.out.println(stringBuilder);
    }
} // class
