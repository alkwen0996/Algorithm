package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_2475 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final List<Integer> numbers = new ArrayList<>();

        while (stringTokenizer.hasMoreTokens()) {
            numbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        System.out.println(solve(numbers));

    }

    private static int solve(final List<Integer> numbers) {

        int verificationNumber = 0;
        for (Integer number : numbers) {
            verificationNumber = number * number + verificationNumber;
        }

        return verificationNumber % 10;
    }
}
