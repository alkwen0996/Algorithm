package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16194 {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int cardNumberToPurchase = Integer.parseInt(bufferedReader.readLine());

        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] eachCardPacksCardNumbers = new int[cardNumberToPurchase + 1];
        int[] memorization = new int[cardNumberToPurchase + 1];

        for (int i = 1; i <= cardNumberToPurchase; i++) {
            eachCardPacksCardNumbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(calculateToPurchaseCardCost(eachCardPacksCardNumbers, memorization, cardNumberToPurchase));
    }

    private static int calculateToPurchaseCardCost(final int[] eachCardPacksCardNumbers, final int[] memorization, int cardNumberToPurchase) {
        for (int i = 1; i <= cardNumberToPurchase; i++) {
            for (int j = 1; j <= i; j++) {
                if (memorization[i] == 0) {
                    memorization[i] = memorization[i - j] + eachCardPacksCardNumbers[j];
                    continue;
                }

                memorization[i] = Math.min(memorization[i], memorization[i - j] + eachCardPacksCardNumbers[j]);
            }
        }

        return memorization[cardNumberToPurchase];
    }

}
