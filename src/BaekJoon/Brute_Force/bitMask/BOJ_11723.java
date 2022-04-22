package BaekJoon.Brute_Force.bitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723 {
    private static final String ADD = "add";
    private static final String CHECK = "check";
    private static final String ALL = "all";
    private static final String EMPTY = "empty";
    private static final String REMOVE = "remove";
    private static final String TOGGLE = "toggle";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int operationsCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();
        int bitMask = 0;
        int maximum = 20;

        for (int i = 0; i < operationsCount; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            final String order = stringTokenizer.nextToken();

            if (order.equals(EMPTY)) {
                bitMask = 0;
                continue;
            }

            if (order.equals(ALL)) {
                bitMask = (1 << maximum) - 1;
                continue;
            }

            int data = Integer.parseInt(stringTokenizer.nextToken()) - 1;

            if (order.equals(ADD)) {
                bitMask |= (1 << data);
            } else if (order.equals(CHECK)) {
                int result = bitMask & (1 << data);

                if (result == 0) {
                    stringBuilder.append(0).append(NEW_LINE);
                } else {
                    stringBuilder.append(1).append(NEW_LINE);
                }
            } else if (order.equals(REMOVE)) {
                bitMask = bitMask & ~(1 << data);
            } else if (order.equals(TOGGLE)) {
                bitMask = bitMask ^ (1 << data);
            }

        }

        System.out.println(stringBuilder);
    }
}
