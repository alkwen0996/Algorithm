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
            final int treeCount = Integer.parseInt(bufferedReader.readLine());
            final int[] treesHeight = new int[treeCount];

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < treeCount; j++) {
                treesHeight[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            stringBuilder.append("#").append(i).append(" ").append(countDays(treesHeight)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int countDays(final int[] treesHeight) {
        Arrays.sort(treesHeight);
        countRemainGrowHeight(treesHeight, findMaximumTree(treesHeight));
        // 제일 높은 나무를 구해서 해당 나무 기준으로 각 나무들이 얼만큼 성장해야 제일 높은 나무만큼 성장하는지 남은 길이를 계산한다.

        int day = 0;
        while (isAllTreeSame(treesHeight)) {
            day++;

            for (int i = treesHeight.length - 1; i >= 0; i--) {
                if (treesHeight[i] > 0) {
                    if (day % 2 == 1) {
                        if (treesHeight[i] == 1 || treesHeight[i] >= 3) {
                            treesHeight[i] -= 1;
                            break;
                        }
                    }

                    if (day % 2 == 0) {
                        if (treesHeight[i] >= 2 || treesHeight[i] >= 3) {
                            treesHeight[i] -= 2;
                            break;
                        }
                    }
                }
            }
        }

        return day;
    }

    private static int findMaximumTree(final int[] treesHeight) {
        return Arrays.stream(treesHeight)
                .max()
                .getAsInt();

    }

    private static int countRemainGrowHeight(final int[] treesHeight, final int highestTree) {
        int remainCount = 0;

        for (int i = 0; i < treesHeight.length; i++) {
            treesHeight[i] = highestTree - treesHeight[i];
        }

        return remainCount;
    }

    private static boolean isAllTreeSame(final int[] treesHeight) {
        for (final int treeHeight : treesHeight) {
            if (treeHeight != 0) {
                return true; // 아직 모든나무가 자라지 않았다면 true반환해서 while문 동작.
            }
        }

        return false; // 모든나무가 자랐다면 true 반환해서 while문 종료
    }

}

