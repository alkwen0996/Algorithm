package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_14503 {
    private static int[][] board;
    private static Vacuum vacuum;
    private static int row;
    private static int column;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        row = Integer.parseInt(stringTokenizer.nextToken());
        column = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        final int vacuumRow = Integer.parseInt(stringTokenizer.nextToken());
        final int vacuumColumn = Integer.parseInt(stringTokenizer.nextToken());
        final int vacuumDirection = Integer.parseInt(stringTokenizer.nextToken());

        vacuum = new Vacuum(vacuumRow, vacuumColumn, vacuumDirection);
        board = new int[row][column];

        System.out.println();
        for (int i = 0; i < row; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < column; j++) {
                System.out.println("i: " + i + " / j: " + j);
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int result = solution();
        System.out.println(result);
    }

    private static int solution() {
        int count = 0;

        while (true) {
            if (checkCurrentCleanStatus()) {
                cleanArea();
                count++;
            }

            if (!findMoveArea() && !checkBackward()) {
                break;
            }
        }

        return count;
    }

    private static boolean checkBackward() {
        boolean checkWell = true;
        int moveBackArea = 0;

        if (vacuum.direction == 0) {
            moveBackArea = board[vacuum.row][vacuum.column + 1];
        } else if (vacuum.direction == 1) {
            moveBackArea = board[vacuum.row - 1][vacuum.column];
        } else if (vacuum.direction == 2) {
            moveBackArea = board[vacuum.row][vacuum.column - 1];
        } else {
            moveBackArea = board[vacuum.row + 1][vacuum.column];
        }

        if (moveBackArea == 1) {
            checkWell = false;
        }

        return checkWell;
    }

    private static boolean findMoveArea() {
        int moveArea = 0;
        int moveRow = 0;
        int moveColumn = 0;

        boolean checkMoveArea = true;

        for (int i = 0; i < 4; i++) {
            if (vacuum.direction == 0 && vacuum.row > 0) {
                moveArea = board[vacuum.row - 1][vacuum.column];
                moveRow = vacuum.row - 1;
                moveColumn = vacuum.column;
            } else if (vacuum.direction == 1 && vacuum.column > 0) {
                moveArea = board[vacuum.row][vacuum.column - 1];
                moveRow = vacuum.row;
                moveColumn = vacuum.column - 1;
            } else if (vacuum.direction == 2 && vacuum.row < row) {
                moveArea = board[vacuum.row + 1][vacuum.column];
                moveRow = vacuum.row + 1;
                moveColumn = vacuum.column;
            } else if (vacuum.direction == 3 && vacuum.column < column) {
                moveArea = board[vacuum.row][vacuum.column + 1];
                moveRow = vacuum.row;
                moveColumn = vacuum.column + 1;
            }


            if (moveArea == 0) {
                vacuum.row = moveRow;
                vacuum.column = moveColumn;
                break;
            } else {
                checkMoveArea = false;
                if (vacuum.direction == 0) {
                    vacuum.direction = 3;
                } else {
                    vacuum.direction = vacuum.direction - 1;
                }
            }

        }

        return checkMoveArea;
    }

    private static void cleanArea() {
        board[vacuum.row][vacuum.column] = 1;
    }

    private static boolean checkCurrentCleanStatus() {
        return board[vacuum.row][vacuum.column] == 0;
    }

    private static class Vacuum {
        private int row;
        private int column;
        private int direction;

        public Vacuum(final int row, final int column, final int direction) {
            this.row = row;
            this.column = column;
            this.direction = direction;
        }
    }
}
