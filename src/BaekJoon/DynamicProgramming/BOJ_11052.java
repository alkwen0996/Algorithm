package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int purchaseCardCount = Integer.parseInt(bufferedReader.readLine());

        int[] cardPacksCount = new int[purchaseCardCount + 1];
        int[] memorization = new int[purchaseCardCount + 1];

        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= purchaseCardCount; i++) {
            cardPacksCount[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(calculateMoney(cardPacksCount, memorization, purchaseCardCount));
    }

    private static int calculateMoney(final int[] cardPacksCount, final int[] memorization, final int purchaseCardCount) {
        for (int i = 1; i <= purchaseCardCount; i++) {
            for (int j = 1; j <= i; j++) {
                memorization[i] = Math.max(memorization[i], memorization[i - j] + cardPacksCount[j]);
            }
        }

        return memorization[purchaseCardCount];
    }

}
