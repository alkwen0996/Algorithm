package BaekJoon.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10866 {
    private static final String NEW_LINE = "\n";
    private static final String BACK = "back";
    private static final String FRONT = "front";
    private static final String EMPTY = "empty";
    private static final String SIZE = "size";
    private static final String POP_BACK = "pop_back";
    private static final String POP_FRONT = "pop_front";
    private static final String PUSH_BACK = "push_back";
    private static final String PUSH_FRONT = "push_front";
    private static final String PUSH = "push";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(bufferedReader.readLine());

        final List<Order> orders = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            final String order = stringTokenizer.nextToken();
            int number = 0;

            if (order.contains(PUSH)) {
                number = Integer.parseInt(stringTokenizer.nextToken());
            }

            orders.add(new Order(order, number));
        }

        String result = solution(orders);
        System.out.println(result);
    }

    private static String solution(final List<Order> orders) {
        final StringBuilder stringBuilder = new StringBuilder();
        final Deque<Integer> deque = new ArrayDeque<>();

        for (Order value : orders) {
            String order = value.order;
            int number = value.number;

            switch (order) {
                case PUSH_FRONT:
                    deque.addFirst(number);
                    break;

                case PUSH_BACK:
                    deque.addLast(number);
                    break;

                case POP_FRONT:
                    if (checkEmpty(stringBuilder, deque, -1)) {
                        continue;
                    }

                    stringBuilder.append(deque.pollFirst()).append(NEW_LINE);
                    break;

                case POP_BACK:
                    if (checkEmpty(stringBuilder, deque, -1)) {
                        continue;
                    }

                    stringBuilder.append(deque.pollLast()).append(NEW_LINE);
                    break;

                case SIZE:
                    stringBuilder.append(deque.size()).append(NEW_LINE);
                    break;

                case EMPTY:
                    if (checkEmpty(stringBuilder, deque, -1)) {
                        continue;
                    }

                    stringBuilder.append(0).append(NEW_LINE);
                    break;

                case FRONT:
                    if (checkEmpty(stringBuilder, deque, -1)) {
                        continue;
                    }

                    stringBuilder.append(deque.getFirst()).append(NEW_LINE);
                    break;

                case BACK:
                    if (checkEmpty(stringBuilder, deque, -1)) {
                        continue;
                    }

                    stringBuilder.append(deque.getLast()).append(NEW_LINE);
                    break;
            }
        }

        return stringBuilder.toString();
    }

    private static boolean checkEmpty(final StringBuilder stringBuilder, final Deque<Integer> deque, final int i) {
        if (deque.isEmpty()) {
            stringBuilder.append(i).append(NEW_LINE);
            return true;
        }

        return false;
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
