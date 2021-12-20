package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_23057 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(bufferedReader.readLine());
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final List<Integer> cardNumbers = new ArrayList<>();

        int M = 0;
        while (stringTokenizer.hasMoreTokens()) {
            int cardNumber = Integer.parseInt(stringTokenizer.nextToken());
            cardNumbers.add(cardNumber);
            M += cardNumber;
        }

        int result = solve(M, cardNumbers);
        System.out.println(result);
    }

    private static int solve(final int maximumNumber, final List<Integer> cardNumbers) {
        boolean[] noCreateNumber = new boolean[maximumNumber + 1];
        noCreateNumber[0] = true;

        int canNotCreateNumber = 0;
        for (int i = 1; i < noCreateNumber.length; i++) {
            if (!noCreateNumber[i]) {
                canNotCreateNumber++;
            }
        }

        return canNotCreateNumber;
    }
}

// 1 3 4 5 7 8