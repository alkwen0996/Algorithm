package BaekJoon.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 이분탐색으로 다시 풀기
public class BOJ_2512 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int numberOfRegion = Integer.parseInt(bufferedReader.readLine());

        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int[] budgetForEachRegion = new int[numberOfRegion];

        for (int i = 0; i < numberOfRegion; i++) {
            budgetForEachRegion[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        final int totalNationalBudget = Integer.parseInt(bufferedReader.readLine());

        int result = solution(numberOfRegion, budgetForEachRegion, totalNationalBudget);
        System.out.println(result);
    }

    private static int solution(final int numberOfRegion, final int[] budgetForEachRegion, final int totalNationalBudget) {
        int sumAllEachRegionBudget = Arrays.stream(budgetForEachRegion).sum();
        Arrays.sort(budgetForEachRegion);

        if (totalNationalBudget > sumAllEachRegionBudget) {
            return budgetForEachRegion[numberOfRegion - 1];
        }

        int findMaximumBudget = totalNationalBudget / budgetForEachRegion.length;
        int sumEachRegionBudget = 0;

        for (int i = 0; i < budgetForEachRegion.length; i++) {
            sumEachRegionBudget += budgetForEachRegion[i];
            int temp = totalNationalBudget - sumEachRegionBudget;
            int budgetMeasurement;

            if (i < budgetForEachRegion.length - 1) {
                budgetMeasurement = temp / (budgetForEachRegion.length - (i + 1));
            } else {
                budgetMeasurement = temp / budgetForEachRegion.length;
            }

            findMaximumBudget = Math.max(findMaximumBudget, budgetMeasurement);
        }

        return findMaximumBudget;
    }
}
