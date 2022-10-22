import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private static int minimumInput, passCondition;
    private static int[][] film, copyMap;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int filmThickness = Integer.parseInt(stringTokenizer.nextToken()); // 필름두께
            final int width = Integer.parseInt(stringTokenizer.nextToken()); // 필름 너비 사이즈
            passCondition = Integer.parseInt(stringTokenizer.nextToken()); // 통과 기준

            film = new int[filmThickness][width];
            copyMap = new int[filmThickness][width];

            for (int j = 0; j < filmThickness; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                for (int k = 0; k < width; k++) {
                    film[j][k] = Integer.parseInt(stringTokenizer.nextToken());
                    copyMap[j][k] = film[j][k];
                }
            }

            minimumInput = Integer.MAX_VALUE; // 최소약품 투입횟수를 저장할 변수.
            final boolean[] isSelected = new boolean[film.length];

            if (isPass()) { // 합격기준 조건검사
                minimumInput = 0; // 조건에 합격시 0출력
            } else {
                countMinimumInput(isSelected, 0); // 조건에 불합격시 최소약품투입횟수를 계산한다.
            }

            stringBuilder.append("#").append(i).append(" ").append(minimumInput).append("\n");
        }

        System.out.println(stringBuilder); // 결과출력
    }

    private static void countMinimumInput(final boolean[] isSelected, final int count) {
        if (count == film.length) {
            inputChemical(isSelected, 0, 0);
            revertMap();

            return;
        }

        isSelected[count] = true;
        countMinimumInput(isSelected, count + 1);

        isSelected[count] = false;
        countMinimumInput(isSelected, count + 1);
    }

    private static void inputChemical(final boolean[] isSelected, final int count, final int depth) {
        if (count >= minimumInput) {
            return;
        }

        if (depth == film.length) {
            if (isPass()) {
                minimumInput = count;
            }

            return;
        }

        if (isSelected[depth]) {
            Arrays.fill(film[depth], 0);
            inputChemical(isSelected, count + 1, depth + 1);

            Arrays.fill(film[depth], 1);
            inputChemical(isSelected, count + 1, depth + 1);
        } else {
            inputChemical(isSelected, count, depth + 1);
        }

    }

    private static void revertMap() {
        for (int i = 0; i < film.length; i++) {
            film[i] = copyMap[i].clone();
        }

    }

    private static boolean isPass() {
        for (int i = 0; i < film[0].length; i++) {
            int sameCount = 1;
            int beforeCell = film[0][i];

            for (int j = 1; j < film.length; j++) {
                if (sameCount >= passCondition) {
                    break;
                }

                if (beforeCell == film[j][i]) {
                    sameCount++;
                    continue;
                }

                beforeCell = film[j][i];
                sameCount = 1;
            }

            if (sameCount < passCondition) {
                return false;
            }
        }

        return true;
    }

}