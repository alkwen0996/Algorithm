import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] numbers = new int[n];
        int[] permutations = new int[m];
        boolean[] isSelected = new boolean[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        permutation(numbers, permutations, isSelected, 0, 0);
    }

    private static void permutation(final int[] numbers, final int[] permutations, final boolean[] isSelected, final int count, final int start) {
        if (count == permutations.length) {
            StringBuilder stringBuilder = new StringBuilder();

            for (final int permutation : permutations) {
                stringBuilder.append(permutation).append(" ");
            }

            System.out.println(stringBuilder);

            return;
        }

        for (int i = start; i < numbers.length; i++) {
            if (isSelected[i]) {
                continue;
            }

            permutations[count] = numbers[i];
            isSelected[i] = true;
            permutation(numbers, permutations, isSelected, count + 1, i + 1);
            isSelected[i] = false;
        }
    }

} // class
