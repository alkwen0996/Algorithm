import java.awt.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int height = Integer.parseInt(stringTokenizer.nextToken());
        final int width = Integer.parseInt(stringTokenizer.nextToken());
        final int[][] array = new int[height + 1][width + 1];
        final int[][] sum = new int[height + 1][width + 1];

        for (int i = 1; i <= height; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 1; j <= width; j++) {
                array[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                sum[i][j] = array[i][j] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        final int lineCount = Integer.parseInt(bufferedReader.readLine());
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < lineCount; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());


            final int x1 = Integer.parseInt(stringTokenizer.nextToken());
            final int y1 = Integer.parseInt(stringTokenizer.nextToken());
            final int x2 = Integer.parseInt(stringTokenizer.nextToken());
            final int y2 = Integer.parseInt(stringTokenizer.nextToken());

            stringBuilder.append(sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

}
