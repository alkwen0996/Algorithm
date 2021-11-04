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
    public static final String ORDER_BACK = "back";
    public static final String ORDER_EMPTY = "empty";
    public static final String ORDER_SIZE = "size";
    public static final String ORDER_POP = "pop";
    public static final Deque<Integer> orderNumbers = new ArrayDeque<>();

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

        for (Order value : orders) {
            String order = value.order;
            int orderNumber = value.number;

            if (order.contains(ORDER_PUSH) && orderNumber > 0) {
                push(orderNumber);
            } else if (order.contains(ORDER_FRONT)) {
                stringBuilder.append(front()).append(NEW_LINE);
            } else if (order.contains(ORDER_BACK)) {
                stringBuilder.append(back()).append(NEW_LINE);
            } else if (order.contains(ORDER_SIZE)) {
                stringBuilder.append(size()).append(NEW_LINE);
            } else if (order.contains(ORDER_EMPTY)) {
                stringBuilder.append(empty()).append(NEW_LINE);
            } else if (order.contains(ORDER_POP)) {
                stringBuilder.append(pop()).append(NEW_LINE);
            }
        }

        return stringBuilder.toString();
    }

    private static int size() {
        return orderNumbers.size();
    }

    private static int back() {
        int result = 0;
        if (empty() == 1) {
            result = -1;
        } else {
            result = orderNumbers.getLast();
        }

        return result;
    }

    private static int front() {
        int result = 0;
        if (empty() == 1) {
            result = -1;
        } else {
            result = orderNumbers.getFirst();
        }

        return result;
    }

    public static void push(final int orderNumber) {
        if (orderNumber > 0) {
            orderNumbers.add(orderNumber);
        }
    }

    public static int pop() {
        int result = 0;
        if (!orderNumbers.isEmpty()) {
            result = orderNumbers.pollFirst();
        } else {
            result = -1;
        }

        return result;
    }

    public static int empty() {
        int result = 0;
        if (orderNumbers.isEmpty()) {
            result = 1;
        }
        return result;
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
