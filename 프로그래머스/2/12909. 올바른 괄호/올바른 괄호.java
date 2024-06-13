import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        Deque<Character> checkStack = new ArrayDeque<>();

        while (!stack.isEmpty()) {
            Character firstPop = stack.pop();

            if (checkStack.isEmpty() || firstPop == ')') {
                checkStack.push(firstPop);
                continue;
            }

            if (checkStack.peek() == ')' && firstPop == '(') {
                checkStack.pop();
                continue;
            }

            checkStack.push(firstPop);
        }

        if (checkStack.isEmpty()) {
            answer = true;
        }

        return answer;
    }
}