package BaekJoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int haveCountCable = Integer.parseInt(stringTokenizer.nextToken());
        int needCountCable = Integer.parseInt(stringTokenizer.nextToken());

        final int[] cablesLength = new int[haveCountCable];

        for (int i = 0; i < haveCountCable; i++) {
            cablesLength[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.println(getMaxCableLength(haveCountCable, needCountCable, cablesLength));
    }

    private static long getMaxCableLength(final int haveCountCable, final int needCountCable, final int[] cablesLength) {
        Arrays.sort(cablesLength);

        long start = 1;
        long end = cablesLength[haveCountCable - 1];

        while (start <= end) {
            long mid = (start + end) / 2;
            long cableCount = 0;

            for (final int cableLength : cablesLength) {
                cableCount += cableLength / mid;
            }

            if (cableCount < needCountCable) {
                end = mid - 1;
            } else if (cableCount >= needCountCable) {
                start = mid + 1;
            }
        }

        return end;
    }
}
