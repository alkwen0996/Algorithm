package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No_1158 {

    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String ANGLE_BRACKET_OPEN = "<";
    private static final String ANGLE_BRACKET_CLOSE = ">";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int n = Integer.parseInt(stringTokenizer.nextToken());
        final int k = Integer.parseInt(stringTokenizer.nextToken());

        String result = solve(n, k);
        System.out.println(result);
    }

    private static String solve(final int n, final int k) {
        final StringBuilder stringBuilder = new StringBuilder();
        final List<Integer> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            people.add(i + 1);
        }

        stringBuilder.append(ANGLE_BRACKET_OPEN);

        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            index = (index + k - 1) % people.size();

            stringBuilder.append(people.get(index)).append(COMMA).append(SPACE);
            people.remove(index);
        }

        stringBuilder.append(people.remove(0)).append(ANGLE_BRACKET_CLOSE);

        return stringBuilder.toString();
    }
}
