package BaekJoon.Brute_Force.BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723 {
    private static final String ALL = "all";
    private static final String ADD = "add";
    private static final String REMOVE = "remove";
    private static final String CHECK = "check";
    private static final String TOGGLE = "toggle";
    private static final String EMPTY = "empty";
    private static final String NEW_LINE = "\n";
    private static final int ZERO = 0;
    private static final int ONE = 1;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder stringBuilder = new StringBuilder();

        final int operationCount = Integer.parseInt(bufferedReader.readLine());
        final int maximumNumber = 20;
        int bitMask = 0;

        for (int i = 0; i < operationCount; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            final String operation = stringTokenizer.nextToken();

            if (operation.equals(ALL)) {
                bitMask = (1 << maximumNumber) - 1;
                continue;
            }

            if (operation.equals(EMPTY)) {
                bitMask = 0;
                continue;
            }

            final int data = Integer.parseInt(stringTokenizer.nextToken()) - 1;

            if (operation.equals(ADD)) {
                bitMask = (bitMask | (1 << data));
            } else if (operation.equals(REMOVE)) {
                bitMask = (bitMask & ~(1 << data));
            } else if (operation.equals(CHECK)) {
                int result = (bitMask & (1 << data));

                if (result == 0) {
                    stringBuilder.append(ZERO).append(NEW_LINE);
                } else {
                    stringBuilder.append(ONE).append(NEW_LINE);
                }
            } else if (operation.equals(TOGGLE)) {
                bitMask = (bitMask ^ (1 << data));
            }
        }

        System.out.println(stringBuilder);
    }

}
