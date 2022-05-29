package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class SWEA_1859 {

    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";
    private static final String SIGNAL = "#";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < testCaseCount; i++) {
            final int dayCount = Integer.parseInt(bufferedReader.readLine());

            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            final Stack<Integer> stack = new Stack<>();

            for (int j = 0; j < dayCount; j++) {
                stack.push(Integer.parseInt(stringTokenizer.nextToken()));
            }

            stringBuilder.append(SIGNAL)
                    .append(i + 1)
                    .append(SPACE)
                    .append(eachCaseSolution(stack))
                    .append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static long eachCaseSolution(final Stack<Integer> pricesOfEachDay) {
        if (pricesOfEachDay.size() == 1) {
            return 0;
        }

        long maximumRevenue = 0;
        int sellPrice = pricesOfEachDay.pop();

        while (!pricesOfEachDay.isEmpty()) {
            final int spendPrice = pricesOfEachDay.pop();

            if (spendPrice < sellPrice) {
                maximumRevenue += sellPrice - spendPrice;
                continue;
            }

            sellPrice = spendPrice;
        }

        return maximumRevenue;
    }
}
