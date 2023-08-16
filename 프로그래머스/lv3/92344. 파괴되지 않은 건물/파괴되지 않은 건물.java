class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] prefixSum = attackAndRecover(board, skill);
        countDamage(board, prefixSum);

        return countSurviveBuildings(board);
    }

    public void countDamage(final int[][] board, final int[][] prefixSum) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] + prefixSum[i][j];
            }
        }

    }

    public int[][] attackAndRecover(final int[][] board, final int[][] skill) {
        int[][] prefixSum = new int[board.length + 1][board[0].length + 1];

        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int row1 = skill[i][1];
            int col1 = skill[i][2];
            int row2 = skill[i][3];
            int col2 = skill[i][4];
            int degree = skill[i][5];

            if (type == 1) {
                prefixSum[row1][col1] -= degree;
                prefixSum[row1][col2 + 1] += degree;
                prefixSum[row2 + 1][col1] += degree;
                prefixSum[row2 + 1][col2 + 1] -= degree;
            } else {
                prefixSum[row1][col1] += degree;
                prefixSum[row1][col2 + 1] -= degree;
                prefixSum[row2 + 1][col1] -= degree;
                prefixSum[row2 + 1][col2 + 1] += degree;
            }
        }

        for (int i = 1; i < prefixSum.length; i++) {
            for (int j = 0; j < prefixSum[0].length; j++) {
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j];
            }
        }

        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = 1; j < prefixSum[0].length; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + prefixSum[i][j];
            }
        }

        return prefixSum;
    }

    public int countSurviveBuildings(final int[][] board) {
        int answer = 0;

        for (final int[] boardLine : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (boardLine[j] <= 0) {
                    continue;
                }

                answer++;
            }
        }

        return answer;
    }
    
}