package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_17087 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int s = Integer.parseInt(stringTokenizer.nextToken());

        final List<Integer> siblingLocation = new ArrayList<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            siblingLocation.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int result = solve(n, s, siblingLocation);
        System.out.println(result);
    }

    private static int solve(final int n, final int s, final List<Integer> siblingLocation) {
        final List<Integer> distanceDifference = new ArrayList<>();

        for (int brother : siblingLocation) {
            distanceDifference.add(Math.abs(s - brother));
        }

        int gcd = distanceDifference.get(0);

        for (int i = 1; i < distanceDifference.size(); i++) {
            gcd = gcd(gcd, distanceDifference.get(i));
        }

        return gcd;
    }

    private static int gcd(int bro1, int bro2) {
        while (bro2 != 0) {
            int r = bro1 % bro2;
            bro1 = bro2;
            bro2 = r;
        }

        return bro1;
    }
}
