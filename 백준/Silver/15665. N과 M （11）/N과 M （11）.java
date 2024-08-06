import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] numbers = new int[n];
        int[] permutation = new int[m];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(numbers);
        createPermutation(numbers, permutation, 0);
        System.out.println(stringBuilder);
    }

    private static void createPermutation(final int[] numbers, final int[] permutation, final int step) {
        if (step == permutation.length) {

            for (int i = 0; i < permutation.length; i++) {
                stringBuilder.append(permutation[i]).append(" ");
            }

            stringBuilder.append("\n");

            return;
        }

        int prev = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (prev == numbers[i]) {
                continue;
            }

            prev = numbers[i];
            permutation[step] = numbers[i];
            createPermutation(numbers, permutation, step + 1);
        }
    }

} // class
