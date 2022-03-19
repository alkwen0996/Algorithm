package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {
    private static final int NOW_CHANNEL = 100;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final String targetChannel = bufferedReader.readLine();
        final int brokenButtonNumberCount = Integer.parseInt(bufferedReader.readLine());

        final boolean[] brokenNumbers = new boolean[10];

        if (brokenButtonNumberCount > 0) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int i = 0; i < brokenButtonNumberCount; i++) {
                int brokenNumber = Integer.parseInt(stringTokenizer.nextToken());
                brokenNumbers[brokenNumber] = true;
            }
        }

        int result = solution(targetChannel, brokenNumbers, brokenButtonNumberCount);
        System.out.println(result);
    }

    private static int solution(final String targetChannel, final boolean[] brokenNumbers, final int brokenButtonNumberCount) {
        int answer = Math.abs(Integer.parseInt(targetChannel) - 100);

        for (int i = 0; i <= 1_000_000; i++) {
            String number = String.valueOf(i);
            int moveChannelLength = String.valueOf(i).length();

            boolean isCheck = true;
            for (int j = 0; j < moveChannelLength; j++) {
                if (brokenNumbers[number.charAt(j) - '0']) {
                    isCheck = false;
                    break;
                }
            }

            if (isCheck) {
                int pushButtonCount = Math.abs(Integer.parseInt(targetChannel) - i) + moveChannelLength;
                answer = Math.min(answer, pushButtonCount);
            }
        }

        return answer;
    }
}
