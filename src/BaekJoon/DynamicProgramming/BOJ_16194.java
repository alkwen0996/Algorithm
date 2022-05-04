package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16194 {
    private static int[] eachCardPacksCardNumbers;
    private static int[] memorization;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int cardNumberToPurchase = Integer.parseInt(bufferedReader.readLine());

        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        eachCardPacksCardNumbers = new int[cardNumberToPurchase + 1];
        memorization = new int[cardNumberToPurchase + 1];

        for (int i = 1; i <= cardNumberToPurchase; i++) {
            eachCardPacksCardNumbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        memorization[1] = eachCardPacksCardNumbers[1];
        System.out.println(calculateToPurchaseCardCost(cardNumberToPurchase));
    }

    private static int calculateToPurchaseCardCost(int cardNumberToPurchase) {
        if (memorization[cardNumberToPurchase] > 0) {
            return memorization[cardNumberToPurchase];
        }

        for (int i = 1; i <= cardNumberToPurchase; i++) {
            if (memorization[cardNumberToPurchase] == 0) {
                memorization[cardNumberToPurchase] = calculateToPurchaseCardCost(cardNumberToPurchase - i) + eachCardPacksCardNumbers[i];
            }

            if (memorization[cardNumberToPurchase] != 0) {
                memorization[cardNumberToPurchase] = Math.min(memorization[cardNumberToPurchase],
                        calculateToPurchaseCardCost(cardNumberToPurchase - i) + eachCardPacksCardNumbers[i]
                );
            }
        }

        return memorization[cardNumberToPurchase];
    }

}
