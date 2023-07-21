import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static final char OPEN_BRACKET = '(';
    public static final char CLOSE_BRACKET = ')';
    public static final String EMPTY_STRING = "";
    
    public static String solution(final String p) {
        return dfs(p);
    }

    public static String dfs(final String w) {
        if (w.length() == 0) {
            return EMPTY_STRING;
        }

        StringBuilder u = new StringBuilder();
        String v = "";
        int openCount = 0;
        int closeCount = 0;

        for (int i = 0; i < w.length(); i++) {
            u.append(w.charAt(i));

            if (w.charAt(i) == '(') {
                openCount++;
            } else {
                closeCount++;
            }

            if (openCount == closeCount) {
                v = w.substring(i + 1);
                break;
            }
        }

        if (isCorrectString(u.toString())) {
            return u.append(dfs(v)).toString();
        }

        StringBuilder temp = new StringBuilder("(");
        temp.append(dfs(v));
        temp.append(")");

        u = new StringBuilder(u.substring(1, u.length() - 1));

        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                temp.append(")");
                continue;
            }

            temp.append("(");
        }

        return temp.toString();
    }

    public static boolean isCorrectString(final String p) {
        Deque<Character> stack = new ArrayDeque<>();

        for (final char bracket : p.toCharArray()) {
            if (bracket == OPEN_BRACKET) {
                stack.push(bracket);
                continue;
            }

            if (bracket == CLOSE_BRACKET) {
                if (stack.isEmpty() || stack.peek() == CLOSE_BRACKET) {
                    return false;
                }

                if (stack.peek() == OPEN_BRACKET) {
                    stack.pop();
                }
            }
        }

        return stack.size() == 0;
    }
}