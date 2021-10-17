package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_17944 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int T = Integer.parseInt(stringTokenizer.nextToken());

        solve(N, T);
    }

    private static void solve(final int n, final int t) {
        int count = 0;
        int index = 0;
        boolean upDownCheck = false;

        while (count != t) {
            if (index == 2 * n) {
                upDownCheck = true;
            }else if (index == 1) {
                upDownCheck = false;
            }

            if (upDownCheck) {
                index--;
            } else {
                index++;
            }
            count++;
        }

        System.out.println(index);
    }
}
