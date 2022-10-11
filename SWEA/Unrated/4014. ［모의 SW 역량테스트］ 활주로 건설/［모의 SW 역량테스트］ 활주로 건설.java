
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    private static int lengthOfMap, lengthOfRamp;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= testCaseCount; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            lengthOfMap = Integer.parseInt(stringTokenizer.nextToken());
            lengthOfRamp = Integer.parseInt(stringTokenizer.nextToken());

            final int[][] verticalMap = new int[lengthOfMap][lengthOfMap];
            final int[][] horizontalMap = new int[lengthOfMap][lengthOfMap];

            for (int j = 0; j < lengthOfMap; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                for (int k = 0; k < lengthOfMap; k++) {
                    verticalMap[j][k] = Integer.parseInt(stringTokenizer.nextToken());
                    horizontalMap[k][j] = verticalMap[j][k];
                }
            }

            stringBuilder.append("#").append(i).append(" ").append(countRunway(verticalMap, horizontalMap)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static int countRunway(final int[][] verticalMap, final int[][] horizontalMap) {
        int runwayCount = 0;

        for (int i = 0; i < lengthOfMap; i++) {
            if (makeRoad(verticalMap[i])) {
                runwayCount++;
            }

            if (makeRoad(horizontalMap[i])) {
                runwayCount++;
            }
        }

        return runwayCount;
    }

    // 해당 지 정보로 활주로 건설이 가능하면 true, 불가능하면 false
    private static boolean makeRoad(final int[] road) {
        int beforeHeight = road[0];
        int size = 0;
        int index = 0;

        while (index < lengthOfMap) {
            if (beforeHeight == road[index]) { // 동일높이
                size++;
                index++;
            } else if (beforeHeight + 1 == road[index]) { // 이전높이보다 1높음 : 오르막 경사로 설치 체크
                if (size < lengthOfRamp) { // 경사로 길이 미만이면 활주로 건설 불가.
                    return false;
                }

                beforeHeight++;
                size = 0;
            } else if (beforeHeight - 1 == road[index]) { // 이전높이보다 1작음.
                int count = 0;

                for (int i = index; i < lengthOfMap; i++) {
                    if (road[i] != beforeHeight - 1) {
                        return false;
                    }

                    if (++count == lengthOfRamp) {
                        break;
                    }
                }

                if (count < lengthOfRamp) {
                    return false;
                }

                beforeHeight--;
                index += lengthOfRamp;
                size = 0;
            } else { // 높이가 2이상 차이
                return false;
            }
        }

        return true;
    }

}
