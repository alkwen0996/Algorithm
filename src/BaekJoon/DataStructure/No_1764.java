package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_1764 {
    static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        final List<String> inputNoHeardSeen = new ArrayList<>();
        for (int i = 0; i < n + m; i++) {
            inputNoHeardSeen.add(bufferedReader.readLine());
        }

        String result = solve(inputNoHeardSeen);
        System.out.println(result);

    }

    private static String solve(final List<String> inputNoHeardSeen) throws IOException {
        final Set<String> noHeardSeen = new HashSet<>();
        final List<String> result = new ArrayList<>();
        final StringBuilder stringBuilder = new StringBuilder();

        for (String s : inputNoHeardSeen) {
            if (noHeardSeen.contains(s)) {
                result.add(s);
            }
            noHeardSeen.add(s);
        }

        System.out.println(result.size());

        Collections.sort(result);
        for (String s : result) {
            stringBuilder.append(s).append("\n");
        }

        return stringBuilder.toString();
    }
}
