package Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1436 {
    private static final String END_NUMBER = "666";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String N = bufferedReader.readLine();

        int result = solve(N);
        System.out.println(result);
    }

    private static int solve(final String N) {
        final String endNumber = END_NUMBER;
        final int findMovieNameCount = Integer.parseInt(N);

        if (Integer.parseInt(N) == 1) {
            return Integer.parseInt(endNumber);
        }

        int movieName = Integer.parseInt(endNumber);
        int count = 1;

        do {
            movieName = movieName + 1;

            if (String.valueOf(movieName).contains(endNumber)) {
                count++;
            }
        } while (count != findMovieNameCount);

        return movieName;
    }
}
