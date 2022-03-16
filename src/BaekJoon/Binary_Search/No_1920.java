package BaekJoon.Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No_1920 {

    private static final String NEW_LINE = "\n";
    private static final String CONTAINS = "1";
    private static final String NOT_CONTAINS = "0";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(bufferedReader.readLine());
        Map<Integer, Boolean> compareNumbers = new LinkedHashMap<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            compareNumbers.put(Integer.parseInt(stringTokenizer.nextToken()), true);
        }

        final int M = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < M; i++) {
            if (compareNumbers.containsKey(Integer.parseInt(stringTokenizer.nextToken()))) {
                stringBuilder.append(CONTAINS).append(NEW_LINE);
            } else {
                stringBuilder.append(NOT_CONTAINS).append(NEW_LINE);
            }
        }

        System.out.println(stringBuilder);
    }
}
