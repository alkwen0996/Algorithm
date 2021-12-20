package Basic_Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1085 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int x = Integer.parseInt(stringTokenizer.nextToken());
        int y = Integer.parseInt(stringTokenizer.nextToken());
        int w = Integer.parseInt(stringTokenizer.nextToken());
        int h = Integer.parseInt(stringTokenizer.nextToken());

        int result = borderDistance(x, y, w, h);
        System.out.println(result);
    }

    private static int borderDistance(final int x, final int y, final int w, final int h) {
        int width = Math.min(Math.abs(w - x), x);
        int height = Math.abs(Math.min(Math.abs(h - y), y));

        int result = Math.min(width, height);
        return result;
    }
}
