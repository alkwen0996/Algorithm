package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No_2309 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List<Integer> dwarfs = new ArrayList<>();

        int DwarfCount = 9;
        int tallSum = 0;

        while (DwarfCount-- > 0) {
            int tall = Integer.parseInt(bufferedReader.readLine());
            dwarfs.add(tall);
            tallSum += tall;
        }

        String result = solution(dwarfs, tallSum);
        System.out.println(result);
    }

    private static String solution(final List<Integer> dwarfs, int tallSum) {
        final StringBuilder stringBuilder = new StringBuilder();

        int fakeDwarfFirst = 0;
        int fakeDwarfSecond = 0;

        Collections.sort(dwarfs);

        for (int i = 0; i < dwarfs.size() - 1; i++) {
            for (int j = i + 1; j < dwarfs.size(); j++) {
                int checkHundred = tallSum - (dwarfs.get(i) + dwarfs.get(j));

                if (checkHundred == 100) {
                    fakeDwarfFirst = i;
                    fakeDwarfSecond = j;
                }
            }
        }

        for (int i = 0; i < dwarfs.size(); i++) {
            if (i != fakeDwarfFirst && i != fakeDwarfSecond) {
                stringBuilder.append(dwarfs.get(i)).append(NEW_LINE);
            }
        }


        return stringBuilder.toString();
    }
}
