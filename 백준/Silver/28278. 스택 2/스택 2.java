import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        StringTokenizer stringTokenizer;

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int order = Integer.parseInt(stringTokenizer.nextToken());

            if (order == 1) {
                stack.push(Integer.parseInt(stringTokenizer.nextToken()));
            } else if (order == 2) {
                if (stack.isEmpty()) {
                    stringBuilder.append(-1).append("\n");
                } else {
                    stringBuilder.append(stack.pop()).append("\n");
                }
            } else if (order == 3) {
                stringBuilder.append(stack.size()).append("\n");
            } else if (order == 4) {
                if (stack.isEmpty()) {
                    stringBuilder.append(1).append("\n");
                } else {
                    stringBuilder.append(0).append("\n");
                }
            } else {
                if (stack.isEmpty()) {
                    stringBuilder.append(-1).append("\n");
                } else {
                    stringBuilder.append(stack.peek()).append("\n");
                }
            }
        }

        System.out.println(stringBuilder);
    }
} // class
