
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] permutation = new int[n];

        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            permutation[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        String result = solution(permutation);
        System.out.println(result);
    }

    private static String solution(final int[] permutation) {
        final StringBuilder stringBuilder = new StringBuilder();

        if (nextPermutation(permutation)) {
            for (final int j : permutation) {
                stringBuilder.append(j).append(SPACE);
            }
        } else {
            stringBuilder.append(-1);
        }

        return stringBuilder.toString();
    }

    private static boolean nextPermutation(final int[] permutation) {
        int index = permutation.length - 1;

        while (index > 0 && (permutation[index - 1] >= permutation[index])) {
            index--;
        }

        if (index <= 0) {
            return false;
        }

        int changeIndex = permutation.length - 1;

        while (changeIndex > 0 && permutation[changeIndex] <= permutation[index - 1]) {
            changeIndex--;
        }

        int temp = permutation[index - 1];
        permutation[index - 1] = permutation[changeIndex];
        permutation[changeIndex] = temp;

        changeIndex = permutation.length - 1;

        while (index < changeIndex) {
            temp = permutation[index];
            permutation[index] = permutation[changeIndex];
            permutation[changeIndex] = temp;

            index++;
            changeIndex--;
        }

        return true;
    }

}
