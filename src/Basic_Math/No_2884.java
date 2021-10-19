package Basic_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2884 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int H = Integer.parseInt(stringTokenizer.nextToken());
        final int M = Integer.parseInt(stringTokenizer.nextToken());

        solve(H, M);
    }

    private static void solve(final int h, final int m) {

        int resultHour = h;
        int resultMinute = m;

        resultMinute = resultMinute - 45;

        if (resultMinute < 0) {
            if (resultHour <= 0) {
                resultHour = resultHour + 24;
            }
            resultHour = resultHour - 1;
            resultMinute = resultMinute + 60;
        }

        System.out.println(resultHour + " " + resultMinute);

    }
}
