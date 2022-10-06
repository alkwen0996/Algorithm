
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            final int permutationLength = Integer.parseInt(bufferedReader.readLine());
            final int[] permutation = new int[permutationLength];

            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < permutationLength; j++) {
                permutation[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            stringBuilder.append("#").append(i).append(" ").append(findIncreasingSubSet(permutation)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int findIncreasingSubSet(final int[] permutation) {
        final int[] lis = new int[permutation.length];
        
        for (int i = 0; i < permutation.length; i++) {
            lis[i] = 1;

            for (int j = 0; j < i; j++) {
                if (permutation[j] < permutation[i] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        return Arrays.stream(lis)
                .max()
                .getAsInt();
    }

}