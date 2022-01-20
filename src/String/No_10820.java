package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10820 {
    private static final String SPACE = " ";
    private static final String BLANK = "";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder stringBuilder = new StringBuilder();

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            final int[] count = new int[4];

            for (int i = 0; i < line.length(); i++) {
                if (Character.isLowerCase(line.charAt(i))) {
                    count[0]++;
                }

                if (Character.isUpperCase(line.charAt(i))) {
                    count[1]++;
                }

                if (Character.isDigit(line.charAt(i))) {
                    count[2]++;
                }

                if (Character.isWhitespace(line.charAt(i))) {
                    count[3]++;
                }
            }

            for (final int j : count) {
                stringBuilder.append(j).append(SPACE);
            }

            stringBuilder.append(NEW_LINE);
        }


        System.out.println(stringBuilder);
    }
}
