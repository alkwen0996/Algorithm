import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(final int m, final int n, final String[] board) {
        final char[][] copyMap = createCardMap(m, n, board);
        boolean[][] isVisited = new boolean[m][n];
        int deleteTotalCardCount = 0;
        boolean flag = true;

        while (flag) {
            flag = false;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (copyMap[i][j] == '*') {
                        continue;
                    }
                    
                    if (i + 1 >= m || j + 1 >= n) {
                        continue;
                    }

                    if (checkCard(i, j, copyMap)) {
                        isVisited[i][j] = true;
                        isVisited[i + 1][j] = true;
                        isVisited[i][j + 1] = true;
                        isVisited[i + 1][j + 1] = true;
                        flag = true;
                    }
                }
            }

            deleteTotalCardCount += deleteCard(copyMap, isVisited);
            moveBlock(copyMap);
            isVisited = new boolean[m][n];
        }

        return deleteTotalCardCount;
    }

    public void moveBlock(final char[][] copyMap) {
        for (int i = 0; i < copyMap[0].length; i++) {
            final Queue<Character> queue = new LinkedList<>();

            for (int j = copyMap.length - 1; j >= 0; j--) {
                if (copyMap[j][i] == '*') {
                    continue;
                }

                queue.add(copyMap[j][i]);
            }

            int index = copyMap.length - 1;

            while (!queue.isEmpty()) {
                copyMap[index--][i] = queue.poll();
            }

            for (int j = index; j >= 0; j--) {
                copyMap[j][i] = '*';
            }
        }
    }

    public boolean checkCard(final int i, final int j, final char[][] copyMap) {
        char icon = copyMap[i][j];

        return icon == copyMap[i + 1][j] && icon == copyMap[i][j + 1] && icon == copyMap[i + 1][j + 1];
    }

    public int deleteCard(final char[][] copyMap, final boolean[][] isVisited) {
        int deleteCount = 0;

        for (int i = 0; i < copyMap.length; i++) {
            for (int j = 0; j < copyMap[0].length; j++) {
                if (isVisited[i][j]) {
                    copyMap[i][j] = '*';
                    deleteCount++;
                }
            }
        }

        return deleteCount;
    }

    public char[][] createCardMap(final int m, final int n, final String[] board) {
        final char[][] cardMap = new char[m][n];

        for (int i = 0; i < board.length; i++) {
            char[] line = board[i].toCharArray();
            System.arraycopy(line, 0, cardMap[i], 0, line.length);
        }

        return cardMap;
    }
}