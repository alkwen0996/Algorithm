package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class No_1406 {
    private static final String MOVE_RIGHT = "D";
    private static final String MOVE_LEFT = "L";
    private static final String ADD_DATA = "P";
    private static final String REMOVE_DATA = "B";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String editLine = bufferedReader.readLine();

        final Stack<Character> left = new Stack<>();
        final Stack<Character> right = new Stack<>();

        final int M = Integer.parseInt(bufferedReader.readLine()); // 명령어 개수

        for (int i = 0; i < editLine.length(); i++) {
            left.add(editLine.charAt(i));
        }

        for (int i = 0; i < M; i++) {
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String order = stringTokenizer.nextToken();

            if (ADD_DATA.equals(order)) {
                left.push(stringTokenizer.nextToken().charAt(0));
            } else if (MOVE_LEFT.equals(order)) {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if (REMOVE_DATA.equals(order)) {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else if (MOVE_RIGHT.equals(order)) {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            }
        }

        final StringBuilder stringBuilder = new StringBuilder();

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            stringBuilder.append(right.pop());
        }

        System.out.println(stringBuilder);
    }
}
