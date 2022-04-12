package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
    private static final String EOF = "0";
    private static final String NEW_LINE = "\n";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String SPACE = " ";

    private static int[] totalNumbers, selectedLottoNumbers;
    private static boolean[] useNumbers;
    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        stringBuilder = new StringBuilder();

        String readLine;
        while (!(readLine = bufferedReader.readLine()).equals(EOF)) {
            final StringTokenizer stringTokenizer = new StringTokenizer(readLine);
            final int totalNumberCount = Integer.parseInt(stringTokenizer.nextToken());

            totalNumbers = new int[totalNumberCount];
            useNumbers = new boolean[totalNumberCount];
            selectedLottoNumbers = new int[LOTTO_NUMBER_COUNT];

            for (int i = 0; i < totalNumberCount; i++) {
                totalNumbers[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            int index = 0;
            selectLottoNumber(index);
            stringBuilder.append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static void selectLottoNumber(final int index) {
        if (index == LOTTO_NUMBER_COUNT) {
            for (final int selectedLottoNumber : selectedLottoNumbers) {
                stringBuilder.append(selectedLottoNumber).append(SPACE);
            }

            stringBuilder.append(NEW_LINE);

            return;
        }

        for (int i = index; i < totalNumbers.length; i++) {
            if (useNumbers[i]) {
                continue;
            }

            if (index > 0 && selectedLottoNumbers[index - 1] > totalNumbers[i]) {
                continue;
            }

            useNumbers[i] = true;
            selectedLottoNumbers[index] = totalNumbers[i];
            selectLottoNumber(index + 1);
            useNumbers[i] = false;
        }
    }

}
