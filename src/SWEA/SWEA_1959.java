package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1959 {

    private static final String SIGNAL = "#";
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int countOfTestCase = Integer.parseInt(bufferedReader.readLine());

        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < countOfTestCase; i++) {
            final List<Integer> firstArray = new ArrayList<>();
            final List<Integer> secondArray = new ArrayList<>();

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            final int countOfFirstNumbers = Integer.parseInt(stringTokenizer.nextToken());
            final int countOfSecondNumbers = Integer.parseInt(stringTokenizer.nextToken());

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < countOfFirstNumbers; j++) {
                firstArray.add(Integer.parseInt(stringTokenizer.nextToken()));
            }

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            for (int j = 0; j < countOfSecondNumbers; j++) {
                secondArray.add(Integer.parseInt(stringTokenizer.nextToken()));
            }

            stringBuilder.append(SIGNAL)
                    .append(i + 1)
                    .append(SPACE)
                    .append(solve(firstArray, secondArray))
                    .append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }

    private static int solve(final List<Integer> firstArray, final List<Integer> secondArray) {
        int maximumSum = 0;

        final int maximumStartIndex = Math.abs(firstArray.size() - secondArray.size());

        for (int i = 0; i <= maximumStartIndex; i++) {
            maximumSum = Math.max(maximumSum, getMaximumSum(i, firstArray, secondArray));
        }

        return maximumSum;
    }

    private static int getMaximumSum(final int i, final List<Integer> firstArray, final List<Integer> secondArray) {
        final int lastIndex = Math.min(firstArray.size(), secondArray.size());
        int sum = 0;

        if (firstArray.size() > secondArray.size()) {
            for (int j = 0; j < lastIndex; j++) {
                sum += (firstArray.get(j + i) * secondArray.get(j));
            }

            return sum;
        }

        if (firstArray.size() < secondArray.size()) {
            for (int j = 0; j < lastIndex; j++) {
                sum += (firstArray.get(j) * secondArray.get(j + i));
            }

            return sum;
        }

        for (int j = 0; j < lastIndex; j++) {
            sum += (firstArray.get(j) * secondArray.get(j));
        }

        return sum;
    }

}
