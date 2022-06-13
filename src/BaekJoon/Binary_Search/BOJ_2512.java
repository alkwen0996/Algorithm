package BaekJoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2512 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int numberOfRegion = Integer.parseInt(bufferedReader.readLine());

        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int[] regionBudget = new int[numberOfRegion];

        for (int i = 0; i < numberOfRegion; i++) {
            regionBudget[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        final int totalBudget = Integer.parseInt(bufferedReader.readLine());

        int result = solution(numberOfRegion, regionBudget, totalBudget);
        System.out.println(result);
    }

    private static int solution(final int numberOfRegion, final int[] regionBudget, final int totalBudget) {
        Arrays.sort(regionBudget);
        int sumAllEachRegionBudget = Arrays.stream(regionBudget).sum();

        if (totalBudget >= sumAllEachRegionBudget) {
            return regionBudget[numberOfRegion - 1];
        }

        int start = 0;
        int end = totalBudget;

        while (start <= end) {
            int estimatedBudget = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < numberOfRegion; i++) {
                estimatedBudget += Math.min(regionBudget[i], mid);
            }

            if (estimatedBudget > totalBudget) {
                end = mid - 1;
            } else if (estimatedBudget < totalBudget) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return end;
    }
}
