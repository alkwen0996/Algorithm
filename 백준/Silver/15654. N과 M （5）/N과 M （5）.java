import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] numbers = new int[n];
        boolean[] isSelected = new boolean[n];
        int[] permutation = new int[m];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(numbers);
        stringBuilder = new StringBuilder();
        permutation(numbers, isSelected, permutation, 0);

        System.out.println(stringBuilder);
    }

    private static void permutation(final int[] numbers, final boolean[] isSelected, final int[] permutation, final int count) {
        if (count == permutation.length) {
            for (int i = 0; i < permutation.length; i++) {
                stringBuilder.append(permutation[i]).append(" ");
            }

            stringBuilder.append("\n");

            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (isSelected[i]) {
                continue;
            }

            permutation[count] = numbers[i];
            isSelected[i] = true;
            permutation(numbers, isSelected, permutation, count + 1);
            isSelected[i] = false;
        }
    }
} // class
