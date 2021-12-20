package Bruth_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1057 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int participantsCount = Integer.parseInt(stringTokenizer.nextToken());
        int jiMinKimNumber = Integer.parseInt(stringTokenizer.nextToken());
        int hanSooLimNumber = Integer.parseInt(stringTokenizer.nextToken());

        int result = solve(participantsCount, jiMinKimNumber, hanSooLimNumber);
        System.out.println(result);
    }

    private static int solve(final int participantsCount, final int jiMinKimNumber, final int hanSooLimNumber) {
        int roundNumber = 0;



        return roundNumber;
    }
}
