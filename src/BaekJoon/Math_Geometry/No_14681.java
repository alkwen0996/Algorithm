package BaekJoon.Math_Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_14681 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int x = Integer.parseInt(bufferedReader.readLine());
        final int y = Integer.parseInt(bufferedReader.readLine());

        int result = solve(x, y);
        System.out.println(result);
    }

    private static int solve(final int x, final int y) {
        int quadrant = 0;

        if (x > 0 && y > 0) {
            quadrant = 1;
        } else if (x < 0 && y > 0) {
            quadrant = 2;
        } else if (x < 0 && y < 0) {
            quadrant = 3;
        } else {
            quadrant = 4;
        }

        return quadrant;
    }
}
