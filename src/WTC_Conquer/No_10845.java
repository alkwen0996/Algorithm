package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No_10845 {
    public static final String PUSH = "push";
    public static final String FRONT = "front";
    public static final String BACK = "back";
    public static final String SIZE = "size";
    public static final String EMPTY = "empty";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        final Deque<Integer> queue = new ArrayDeque<>();

        while (N-- > 0) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String order = stringTokenizer.nextToken();
            switch (order) {
                case PUSH:
                    queue.push(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case FRONT:
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.getLast());
                    }
                    break;
                case BACK:
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.getFirst());
                        ;
                    }
                    break;
                case SIZE:
                    System.out.println(queue.size());
                    break;
                case EMPTY:
                    if (queue.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                default:
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.pollLast());
                    }
                    break;
            }
        }

    }
}
