import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int m = Integer.parseInt(stringTokenizer.nextToken());

        final int[] input = new int[n];
        final int[] permutation = new int[m];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(input);
        generatePermutation(input, permutation, m, 0, 0);
        System.out.println(stringBuilder);
    }

    private static void generatePermutation(final int[] input, final int[] permutation, final int m, final int count, final int flag) {
        if (count == m) {
            for (final int element : permutation) {
                stringBuilder.append(element).append(" ");
            }

            stringBuilder.append("\n");

            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (count > 0) {
                if (input[i] < permutation[count - 1]) {
                    continue;
                }
            }

            permutation[count] = input[i];
            generatePermutation(input, permutation, m, count + 1, flag | 1 << i);
        }

    }

}
