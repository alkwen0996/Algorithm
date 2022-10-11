
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
            final int studentCount = Integer.parseInt(bufferedReader.readLine());
            final int compareCount = Integer.parseInt(bufferedReader.readLine());

            final int[][] relations = new int[studentCount + 1][studentCount + 1];
            StringTokenizer stringTokenizer;

            for (int j = 1; j <= compareCount; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                final int smallTall = Integer.parseInt(stringTokenizer.nextToken());
                final int bigTall = Integer.parseInt(stringTokenizer.nextToken());

                relations[smallTall][bigTall] = 1;
            }

            int result = 0;

            for (int j = 1; j <= studentCount; j++) { //경유 500
                for (int k = 1; k <= studentCount; k++) { // 출발 500
                    if (j == k) {
                        continue;
                    }

                    for (int l = 1; l <= studentCount; l++) { // 도착 500
                        if (relations[k][l] == 1) {
                            continue;
                        }

                        relations[k][l] = relations[k][j] & relations[j][l];
                    }
                }
            }

            for (int j = 1; j <= studentCount; j++) {
                for (int k = 1; k <= studentCount; k++) {
                    relations[j][0] += relations[j][k]; // i보다 큰 j가 카운트에 누적
                    relations[0][k] += relations[j][k]; // j보다 작은 i가 카운트에 누적
                }
            } // 0행 0열에 큰, 작은 학생수를 각각 저장.

            for (int j = 1; j <= studentCount; j++) {
                if (relations[0][j] + relations[j][0] == studentCount - 1) {
                    result++;
                }
            }

            stringBuilder.append("#").append(i).append(" ").append(result).append("\n");
        }

        System.out.println(stringBuilder);
    }

}