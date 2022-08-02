package BaekJoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2621 {

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final List<Card> cards = new ArrayList<>();
        final int numberOfTestCase = 5;

        for (int i = 0; i < numberOfTestCase; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final String color = stringTokenizer.nextToken();
            final int number = Integer.parseInt(stringTokenizer.nextToken());

            cards.add(new Card(number, color));
        }

        System.out.println(startGame(cards));
    }

    private static int startGame(final List<Card> cards) {
        Collections.sort(cards);

        final boolean isAllSameColor = countSameColor(cards);
        final boolean isSequenceCount = countSequenceNumber(cards);
        final int[] numberCount = new int[10];

        for (int i = 0; i < cards.size(); i++) {
            numberCount[cards.get(i).number]++;
        }

        int maxSameCount = Arrays.stream(numberCount).max().getAsInt();
        int secondMaxSameCount = 2;
        int maxNumber = -1;
        int nextMaxNumber = -1;

        for (int i = 1; i < numberCount.length; i++) {
            if (maxNumber == -1 && numberCount[i] == maxSameCount) {
                maxNumber = i;
            }

            if (i != maxNumber && numberCount[i] == secondMaxSameCount) {
                nextMaxNumber = i;
            }
        }

        int maximumScore;

        if (isAllSameColor && isSequenceCount) {
            maximumScore = cards.get(cards.size() - 1).number + 900;
        } else if (maxSameCount == 4) {
            maximumScore = maxNumber + 800;
        } else if (maxSameCount == 3) {
            if (nextMaxNumber > -1 && numberCount[nextMaxNumber] == 2) {
                maximumScore = (maxNumber * 10) + nextMaxNumber + 700;
            } else {
                maximumScore = maxNumber + 400;
            }
        } else if (isAllSameColor) {
            maximumScore = cards.get(cards.size() - 1).number + 600;
        } else if (isSequenceCount) {
            maximumScore = cards.get(cards.size() - 1).number + 500;
        } else if (maxSameCount == 2) {
            if (nextMaxNumber > -1 && numberCount[nextMaxNumber] == 2) {
                maximumScore = Math.max(maxNumber, nextMaxNumber) * 10 + Math.min(maxNumber, nextMaxNumber) + 300;
            } else {
                maximumScore = maxNumber + 200;
            }
        } else {
            maximumScore = cards.get(cards.size() - 1).number + 100;
        }

        return maximumScore;
    }

    private static boolean countSequenceNumber(final List<Card> cards) {
        int prevNumber = cards.get(0).number;

        for (int i = 1; i < cards.size(); i++) {
            int compareNumber = cards.get(i).number;
            if (prevNumber != compareNumber - 1) {
                return false;
            }

            prevNumber = compareNumber;
        }

        return true;
    }

    private static boolean countSameColor(final List<Card> cards) {
        String prevColor = cards.get(0).color;

        for (int i = 1; i < cards.size(); i++) {
            String compareColor = cards.get(i).color;
            if (!prevColor.equals(compareColor)) {
                return false;
            }
        }

        return true;
    }

    static class Card implements Comparable<Card> {
        private int number;
        private String color;

        public Card(final int number, final String color) {
            this.number = number;
            this.color = color;
        }


        @Override
        public int compareTo(final Card card) {
            if (this.number > card.number) {
                return 1;
            } else if (this.number < card.number) {
                return -1;
            }

            return 0;
        }
    }

}
