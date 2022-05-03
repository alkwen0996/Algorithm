package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
    private static int[] memorization;
    private static int[] cardPacksCount;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int purchaseCardCount = Integer.parseInt(bufferedReader.readLine());

        cardPacksCount = new int[purchaseCardCount + 1];
        memorization = new int[10_001];

        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= purchaseCardCount; i++) {
            cardPacksCount[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(calculateMoney(purchaseCardCount));
    }

    private static int calculateMoney(int cardPackCount) {
        if(memorization[cardPackCount] > 0){
            return memorization[cardPackCount];
        }

        for (int i = 1; i <= cardPackCount; i++) {
            memorization[cardPackCount] = Math.max(memorization[cardPackCount],
                    calculateMoney(cardPackCount - i) + cardPacksCount[i]
            );
        }

        return memorization[cardPackCount];
    }

}
