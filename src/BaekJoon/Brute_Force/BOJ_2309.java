package BaekJoon.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_2309 {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int dwarfCount = 9;

        final List<Integer> dwarfsHeight = new ArrayList<>();

        while (dwarfCount-- > 0) {
            dwarfsHeight.add(Integer.parseInt(bufferedReader.readLine()));
        }

        String result = solution(dwarfsHeight);
        System.out.println(result);
    }

    private static String solution(final List<Integer> dwarfsHeight) {
        Collections.sort(dwarfsHeight);

        int allDwarfHeight = dwarfsHeight.stream()
                .mapToInt(a -> a)
                .sum();

        int firstOutDwarfIndex = 0, secondOutDwarfIndex = 0;
        boolean checkOut = false;

        for (int i = 0; i < dwarfsHeight.size() - 1; i++) {
            for (int j = i + 1; j < dwarfsHeight.size(); j++) {
                int sevenDwarfHeight = allDwarfHeight - (dwarfsHeight.get(i) + dwarfsHeight.get(j));

                if (sevenDwarfHeight == 100) {
                    firstOutDwarfIndex = i;
                    secondOutDwarfIndex = j;
                    checkOut = true;
                    break;
                }
            }

            if (checkOut) {
                break;
            }
        }

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < dwarfsHeight.size(); i++) {
            int dwarfHeight = dwarfsHeight.get(i);
            if (i != firstOutDwarfIndex && i != secondOutDwarfIndex) {
                stringBuilder.append(dwarfHeight)
                        .append(NEW_LINE);
            }
        }

        return stringBuilder.toString();
    }
}
