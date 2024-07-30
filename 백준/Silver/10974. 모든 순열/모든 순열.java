import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[] numbers = new int[n];
        int[] permutations = new int[n];
        boolean[] isSelected = new boolean[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        permutation(numbers, permutations, isSelected, 0);
        System.out.println(stringBuilder);
    }

    private static void permutation(final int[] numbers, final int[] permutations, final boolean[] isSelected, final int depth) {
        if (depth == permutations.length) {
            for (final int permutation : permutations) {
                stringBuilder.append(permutation).append(" ");
            }

            stringBuilder.append("\n");

            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (isSelected[i]) {
                continue;
            }

            permutations[depth] = numbers[i];
            isSelected[i] = true;
            permutation(numbers, permutations, isSelected, depth + 1);
            isSelected[i] = false;
        }
    }

} // class
