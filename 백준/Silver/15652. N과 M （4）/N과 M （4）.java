import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] numbers = new int[n + 1];
        int[] permutation = new int[m];

        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = i;
        }

        stringBuilder = new StringBuilder();
        permutation(numbers, permutation, 0, 1);

        System.out.println(stringBuilder);
    }

    private static void permutation(final int[] numbers, final int[] permutation, final int count, int start) {
        if (count == permutation.length) {
            for (int i = 0; i < permutation.length; i++) {
                stringBuilder.append(permutation[i]).append(" ");
            }

            stringBuilder.append("\n");

            return;
        }

        for (int i = start; i < numbers.length; i++) {
            permutation[count] = i;
            permutation(numbers, permutation, count + 1, i);
        }
    }

} // class
