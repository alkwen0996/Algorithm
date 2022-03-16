package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No_2947 {
    public static final String SPACE = " ";
    public static final String NEW_LINE = "\n";
    private static final List<Integer> numbersOrder = new ArrayList<>();
    private static final List<Integer> compareOrder = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        while (stringTokenizer.hasMoreTokens()) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            numbersOrder.add(number);
            compareOrder.add(number);
        }

        String result = solution();
        System.out.println(result);
    }

    private static String solution() {
        compareOrder.sort((integer1, integer2) -> {
            if (integer1 > integer2) {
                return 1;
            } else {
                return -1;
            }
        });

        StringBuilder result = new StringBuilder();
        while (!checkOrder()) {
            String sortNumbers = changeOrder();
            if (sortNumbers.length() > 0) {
                result.append(sortNumbers);
            }
        }

        return result.toString();
    }

    private static String saveOrder() {
        final StringBuilder stringBuilder = new StringBuilder();

        for (Integer integer : numbersOrder) {
            stringBuilder.append(integer).append(SPACE);
        }
        stringBuilder.append(NEW_LINE);

        return stringBuilder.toString();
    }

    private static String changeOrder() {
        final StringBuilder stringBuilder = new StringBuilder();
        
        for (int i = 1; i < numbersOrder.size(); i++) {
            int compareNumber = numbersOrder.get(i - 1);

            if (compareNumber > numbersOrder.get(i)) {
                numbersOrder.set(i - 1, numbersOrder.get(i));
                numbersOrder.set(i, compareNumber);
                stringBuilder.append(saveOrder());
            }
        }

        return stringBuilder.toString();
    }

    private static boolean checkOrder() {
        boolean checkOrder = true;

        for (int i = 0; i < numbersOrder.size(); i++) {
            if (!compareOrder.get(i).equals(numbersOrder.get(i))) {
                checkOrder = false;
                break;
            }
        }

        return checkOrder;
    }
}
