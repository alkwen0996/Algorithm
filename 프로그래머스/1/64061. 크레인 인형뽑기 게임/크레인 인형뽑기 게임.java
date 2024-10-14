import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (final int move : moves) {
            int lineNumber = move - 1;

            for (int k = 0; k < board[0].length; k++) {
                if (board[k][lineNumber] == 0) {
                    continue;
                }

                if (stack.isEmpty()) {
                    stack.push(board[k][lineNumber]);
                } else {
                    if (stack.peek() == board[k][lineNumber]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[k][lineNumber]);
                    }
                }

                board[k][lineNumber] = 0;
                break;
            }
        }

        return answer;
    }
}