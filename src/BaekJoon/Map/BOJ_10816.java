package BaekJoon.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10816 {

    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int numberCardCount = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int[] cardNumbers = new int[20_000_001];

        for (int i = 0; i < numberCardCount; i++) {
            int cardNumber = Integer.parseInt(stringTokenizer.nextToken());

            if (cardNumber < 0) {
                cardNumber = Math.abs(cardNumber) + 10_000_000;
            }

            cardNumbers[cardNumber]++;
        }

        final int findNumberCardCount = Integer.parseInt(bufferedReader.readLine());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int[] findCardNumbers = new int[findNumberCardCount];

        for (int i = 0; i < findNumberCardCount; i++) {
            findCardNumbers[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(countFindCard(cardNumbers, findCardNumbers));
    }

    private static StringBuilder countFindCard(final int[] cardNumbers, final int[] findCardNumbers) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int findCardNumber : findCardNumbers) {
            if (findCardNumber < 0) {
                findCardNumber = Math.abs(findCardNumber) + 10_000_000;
            }

            stringBuilder.append(cardNumbers[findCardNumber]).append(SPACE);
        }

        return stringBuilder;
    }

}
