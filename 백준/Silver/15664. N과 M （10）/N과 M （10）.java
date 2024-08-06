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

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] numbers = new int[n];
        int[] permutation = new int[m];
        boolean[] isSelected = new boolean[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(numbers);
        createPermutation(numbers, permutation, isSelected, 0, 0);
    }

    private static void createPermutation(final int[] numbers, final int[] permutation, final boolean[] isSelected, final int step, final int start) {
        if (step == permutation.length) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < permutation.length; i++) {
                stringBuilder.append(permutation[i]).append(" ");
            }

            System.out.println(stringBuilder);

            return;
        }

        int prev = 0;
        for (int i = start; i < numbers.length; i++) {
            if (isSelected[i]) {
                continue;
            }

            if (prev == numbers[i]) {
                continue;
            }

            isSelected[i] = true;
            prev = numbers[i];
            permutation[step] = numbers[i];
            createPermutation(numbers, permutation, isSelected, step + 1, i + 1);
            isSelected[i] = false;
        }
    }

} // class
