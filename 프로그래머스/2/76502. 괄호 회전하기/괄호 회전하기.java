import java.util.ArrayDeque;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int sLength = s.length();

        for (int i = 0; i < sLength; i++) {
            ArrayDeque<Character> deque = new ArrayDeque<>();

            for (int j = 0; j < sLength; j++) {
                deque.add(s.charAt(j));
            }

            for (int j = 0; j < i; j++) {
                deque.add(deque.poll());
            }

            Stack<Character> stack = new Stack<>();

            // 괄호 짝 확인
            while (!deque.isEmpty()) {
                Character poll = deque.poll();

                if (stack.isEmpty()) {
                    stack.push(poll);
                } else if (poll == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (poll == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (poll == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(poll);
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}