import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {

    /*
     * 1. 주어진 나무의 키가 모두 같은지 확인한다.
     * 2. 키가 다르다면 가장 높은 나무의 높이를 구한다.
     * 3. 나무에 물을 준다.
     *   3-1. 하루에 하나의 나무에만 물을 줄 수 있다.
     *   3-2. 물을 주지 않을수도 있다.
     * 4. 3보다 큰 경우 3미만이 될때까지 3씩 빼주고 날짜를 2씩 추가한다.
     * 5. 2가 하나남아있다면 짝수날이 올때까지 기다린다.
     * 6. 1이 하나남아있다면 홀수날이 올때까지 기다린다.
     * 7. 5,6의 경우 이외의 경우에는 홀수날에는
     *  7-1. 1이 있다면 1먼저 빼고 1이 없다면 2짜리에서 1을뺀다.
     *  7-2. 2가 있다면 2를빼고 1밖에 없다면 빼지 않는다.
     * */

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            final int treeCount = Integer.parseInt(bufferedReader.readLine());
            final Integer[] treesHeight = new Integer[treeCount];

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < treeCount; j++) {
                treesHeight[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            Arrays.sort(treesHeight, Collections.reverseOrder());
            stringBuilder.append("#").append(i).append(" ").append(countDays(treesHeight)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int countDays(final Integer[] treesHeight) {
        Integer highestTree = Arrays.stream(treesHeight).max(Comparator.comparingInt(o -> o)).get();

        for (int i = 0; i < treesHeight.length; i++) {
            treesHeight[i] = highestTree - treesHeight[i];
        }

        int day = 0;
        while (isAllTreeSame(treesHeight)) {
            day++;

            for (int i = 0; i < treesHeight.length; i++) {
                if (treesHeight[i] != 0) {
                    if ((day % 2 == 0) && (treesHeight[i]) >= 2) {
                        treesHeight[i] -= 2;
                        break;
                    }

                    if (day % 2 == 1) {
                        if (treesHeight[i] == 1 || treesHeight[i] >= 3) {
                            treesHeight[i] -= 1;
                            break;
                        }
                    }
                }
            }
        }

        return day;
    }

    private static boolean isAllTreeSame(final Integer[] treesHeight) {
        for (final int treeHeight : treesHeight) {
            if (treeHeight != 0) {
                return true; // 아직 모든나무가 자라지 않았다면 true반환해서 while문 동작.
            }
        }

        return false; // 모든나무가 자랐다면 true 반환해서 while문 종료
    }

}
