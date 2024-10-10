import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int sLength = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < sLength; i++) {
            char character = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == character) {
                stack.pop();
            } else {
                stack.push(character);
            }
        }

        if (stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }
}