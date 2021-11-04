package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 큐
public class No_18258 {
    public static final String ORDER_PUSH = "push";
    public static final String ORDER_FRONT = "front";
    public static final String NEW_LINE = "\n";
    public static final String EMPTY_EXCEPTION = "-1";
    public static final String ORDER_BACK = "back";
    public static final String ORDER_EMPTY = "empty";
    public static final String ORDER_SIZE = "size";
    public static final int NO_EMPTY_SIGNAL = 0;
    public static final int EMPTY_SIGNAL = 1;
    public static final String ORDER_POP = "pop";


    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List<Order> orders = new ArrayList<>();
        int N = Integer.parseInt(bufferedReader.readLine());

        while (N-- > 0) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            if (stringTokenizer.countTokens() == 2) {
                orders.add(new Order(stringTokenizer.nextToken(), Integer.parseInt(stringTokenizer.nextToken())));
            } else {
                orders.add(new Order(stringTokenizer.nextToken(), 0));
            }
        }

        String result = solve(orders);
        System.out.println(result);
    }

    private static String solve(final List<Order> orders) {
        final StringBuilder stringBuilder = new StringBuilder();
        final Deque<Integer> orderNumbers = new ArrayDeque<>();

        for (Order value : orders) {
            String order = value.order;
            int orderNumber = value.number;

            if (order.contains(ORDER_PUSH) && orderNumber > 0) {
                orderNumbers.add(orderNumber);
            } else if (order.contains(ORDER_FRONT)) {
                if (!orderNumbers.isEmpty()) {
                    stringBuilder.append(orderNumbers.getFirst()).append(NEW_LINE);
                } else {
                    stringBuilder.append(EMPTY_EXCEPTION).append(NEW_LINE);
                }
            } else if (order.contains(ORDER_BACK)) {
                if (!orderNumbers.isEmpty()) {
                    stringBuilder.append(orderNumbers.getLast()).append(NEW_LINE);
                } else {
                    stringBuilder.append(EMPTY_EXCEPTION).append(NEW_LINE);
                }
            } else if (order.contains(ORDER_SIZE)) {
                stringBuilder.append(orderNumbers.size()).append(NEW_LINE);
            } else if (order.contains(ORDER_EMPTY)) {
                if (!orderNumbers.isEmpty()) {
                    stringBuilder.append(NO_EMPTY_SIGNAL).append(NEW_LINE);
                } else {
                    stringBuilder.append(EMPTY_SIGNAL).append(NEW_LINE);
                }
            } else if (order.contains(ORDER_POP)) {
                if (!orderNumbers.isEmpty()) {
                    stringBuilder.append(orderNumbers.pollFirst()).append(NEW_LINE);
                } else {
                    stringBuilder.append(EMPTY_EXCEPTION).append(NEW_LINE);
                }
            }

        }

        return stringBuilder.toString();
    }

    private static class Order {
        private String order;
        private int number;

        public Order(final String order, final int number) {
            this.order = order;
            this.number = number;
        }
    }
}
