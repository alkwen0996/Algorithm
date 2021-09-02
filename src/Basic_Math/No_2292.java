package Basic_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2292 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bufferedReader.readLine());

        int result = solve(input);
        System.out.println(result);
    }

    private static int solve(final int input) {
        int countRoom = 0;

        // 1, 6, 12, 18, 24
        // 1, 7, 19, 37, 61
        if (input == 1) {
            countRoom = 1;
        }



        return countRoom;
    }
}
