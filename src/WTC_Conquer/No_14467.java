package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_14467 {
    public static final int TOTAL_COW_COUNT = 10;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        final List<Cow> cows = new ArrayList<>(TOTAL_COW_COUNT + 1);
        for (int i = 1; i <= TOTAL_COW_COUNT + 1; i++) {
            cows.add(new Cow(i, -1, false, 0));
        }

        while (N-- > 0) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int cowNumber = Integer.parseInt(stringTokenizer.nextToken());
            int cowPosition = Integer.parseInt(stringTokenizer.nextToken());

            if (!cows.get(cowNumber).cowMoveCheck) {
                cows.get(cowNumber).cowPosition = cowPosition;
                cows.get(cowNumber).cowMoveCheck = true;
            } else {
                if (cowPosition != cows.get(cowNumber).cowPosition) {
                    cows.get(cowNumber).cowPosition = cowPosition;
                    cows.get(cowNumber).cowMoveCount++;
                }
            }
        }

        int totalMoveCount = 0;
        for (Cow cow : cows) {
            if (cow.cowMoveCount == 0) {
                continue;
            }

            totalMoveCount += cow.cowMoveCount;
        }

        System.out.println(totalMoveCount);
    }

    private static class Cow {
        private int cowNumber;
        private int cowPosition;
        private int cowMoveCount;
        private boolean cowMoveCheck;

        public Cow(final int cowNumber, final int cowPosition, final boolean cowMoveCheck, final int cowMoveCount) {
            this.cowNumber = cowNumber;
            this.cowPosition = cowPosition;
            this.cowMoveCheck = cowMoveCheck;
            this.cowMoveCount = cowMoveCount;
        }
    }
}
