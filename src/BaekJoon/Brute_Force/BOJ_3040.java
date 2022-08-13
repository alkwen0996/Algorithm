package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3040 {

    private static final int DWARFS_COUNT = 9;
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int[] dwarfs = new int[DWARFS_COUNT];

        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.println(findDwarf(dwarfs));
    }

    private static StringBuilder findDwarf(final int[] dwarfs) {
        int sum = Arrays.stream(dwarfs).sum();
        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = 0; i < dwarfs.length; i++) {
            for (int j = i; j < dwarfs.length; j++) {
                if (i != j) {
                    if (sum - (dwarfs[i] + dwarfs[j]) == 100) {
                        firstIndex = i;
                        secondIndex = j;
                        break;
                    }
                }
            }
        }

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < dwarfs.length; i++) {
            if (i != firstIndex && i != secondIndex) {
                stringBuilder.append(dwarfs[i]).append(NEW_LINE);
            }
        }

        return stringBuilder;
    }

}
