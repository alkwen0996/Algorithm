package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_9093 {
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCase = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            while (stringTokenizer.hasMoreTokens()) {
                String word = stringTokenizer.nextToken();
                int range = word.length();

                while (range-- > 0) {
                    stringBuilder.append(word.charAt(range));
                }

                stringBuilder.append(SPACE);
            }
            stringBuilder.append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }
}
