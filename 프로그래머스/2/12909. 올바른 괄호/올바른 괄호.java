import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = false;

        Stack<Character> stack = new Stack<>();
        Stack<Character> pairStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        while (!stack.isEmpty()) {
            Character pop = stack.pop();

            if (pairStack.isEmpty()) {
                pairStack.push(pop);
                continue;
            }

            Character peek = pairStack.peek();

            if (peek == ')' && pop == '(') {
                pairStack.pop();
                continue;
            }

            pairStack.push(pop);
        }

        if (pairStack.isEmpty()) {
            answer = true;
        }

        return answer;
    }
}