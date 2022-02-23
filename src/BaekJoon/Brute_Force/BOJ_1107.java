package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {
    private static final int TOTAL_BUTTON_COUNT = 10;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int targetChannel = Integer.parseInt(bufferedReader.readLine());
        final int brokenButtonCount = Integer.parseInt(bufferedReader.readLine());

        boolean[] isBrokenButtons = new boolean[TOTAL_BUTTON_COUNT];

        if (brokenButtonCount > 0) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int i = 0; i < brokenButtonCount; i++) {
                int buttonNumber = Integer.parseInt(stringTokenizer.nextToken());
                isBrokenButtons[buttonNumber] = true;
            }
        }

        int result = solution(targetChannel, isBrokenButtons);
        System.out.println(result);

    }

    private static int solution(final int targetChannel, boolean[] isBrokenButtons) {
        int pushButtonCount = Math.abs(targetChannel - 100);

        for (int i = 0; i < 1000000; i++) {
            String number = String.valueOf(i);

            if (isBreak(isBrokenButtons, number)) {
                int minimum = Math.abs(targetChannel - i) + number.length();
                pushButtonCount = Math.min(pushButtonCount, minimum);
            }
        }

        return pushButtonCount;
    }

    private static boolean isBreak(final boolean[] isBrokenButtons, final String number) {
        boolean isBreak = true;

        for (int j = 0; j < number.length(); j++) {
            if (isBrokenButtons[number.charAt(j) - '0']) {
                isBreak = false;
                break;
            }
        }

        return isBreak;
    }
}
