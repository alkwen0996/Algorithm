
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {

    private static int minimumCount, passCondition;
    private static int[][] film, copyFilm;
    private static int[] chemicalA, chemicalB;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int depth = Integer.parseInt(stringTokenizer.nextToken());
            final int width = Integer.parseInt(stringTokenizer.nextToken());
            passCondition = Integer.parseInt(stringTokenizer.nextToken());

            film = new int[depth][width];
            copyFilm = new int[depth][width];

            for (int j = 0; j < depth; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                for (int k = 0; k < width; k++) {
                    film[j][k] = Integer.parseInt(stringTokenizer.nextToken());
                    copyFilm[j][k] = film[j][k];
                }
            }

            if (isPass()) {
                stringBuilder.append("#").append(i).append(" ").append(0).append("\n");
                continue;
            }

            minimumCount = Integer.MAX_VALUE;

            chemicalA = new int[film[0].length];
            chemicalB = new int[film[0].length];

            Arrays.fill(chemicalA, 0);
            Arrays.fill(chemicalB, 1);

            selectLines(new boolean[film.length], 0);
            stringBuilder.append("#").append(i).append(" ").append(minimumCount).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static void selectLines(final boolean[] isSelected, final int depth) {
        if (depth == film.length) {
            inputChemical(isSelected, 0, 0);
            revertMap();

            return;
        }

        isSelected[depth] = true;
        selectLines(isSelected, depth + 1);
        isSelected[depth] = false;
        selectLines(isSelected, depth + 1);
    }

    private static void revertMap() {
        for (int i = 0; i < copyFilm.length; i++) {
            film[i] = copyFilm[i].clone();
        }

    }

    private static void inputChemical(final boolean[] isSelected, final int depth, final int count) {
        if (count >= minimumCount) {
            return;
        }

        if (depth == film.length) {
            if (isPass()) {
                minimumCount = count;
            }

            return;
        }

        if (isSelected[depth]) {
            film[depth] = chemicalA;
            inputChemical(isSelected, depth + 1, count + 1);

            film[depth] = chemicalB;
            inputChemical(isSelected, depth + 1, count + 1);
        } else {
            inputChemical(isSelected, depth + 1, count);
        }

    }

    private static boolean isPass() {
        for (int i = 0; i < film[0].length; i++) {
            int sameCount = 1;
            int prevCell = film[0][i];

            for (int j = 1; j < film.length; j++) {
                if (sameCount == passCondition) {
                    break;
                }

                if (prevCell == film[j][i]) {
                    sameCount++;
                    continue;
                }

                prevCell = film[j][i];
                sameCount = 1;
            }

            if (sameCount < passCondition) {
                return false;
            }
        }

        return true;
    }

}
