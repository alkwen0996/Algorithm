package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_2798 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List<Integer> cards = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int N = Integer.parseInt(stringTokenizer.nextToken());
        final int M = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        while (stringTokenizer.hasMoreTokens()) {
            cards.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int result = solve(cards, M);
        System.out.println(result);
    }

    private static int solve(final List<Integer> cards, final int m) {
        int cardsSumMaximumNumber = 0;

        for (int i = 0; i < cards.size(); i++) {
            for (int j = i + 1; j < cards.size(); j++) {
                for (int k = j + 1; k < cards.size(); k++) {
                    int cardsSum = cards.get(i) + cards.get(j) + cards.get(k);;
                    if (cardsSum <= m) {
                        if (cardsSum > cardsSumMaximumNumber) {
                            cardsSumMaximumNumber = cards.get(i) + cards.get(j) + cards.get(k);
                        }
                    }
                }
            }
        }

        return cardsSumMaximumNumber;
    }
}
