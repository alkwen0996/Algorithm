package Fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_14503 {
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;
    private static int[][] totalArea;
    private static Vacuum vacuum;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final int row = Integer.parseInt(stringTokenizer.nextToken());
        final int column = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        vacuum = new Vacuum(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken()));

        totalArea = new int[row][column];
        for (int i = 0; i < row; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < column; j++) {
                totalArea[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int result = solution();
        System.out.println(result);
    }

    private static int solution() {
        int cleanAreaCount = 0;
        boolean checkNoCleanArea = true;

        while (checkNoCleanArea) {
            if (checkCleanArea()) {
                cleanArea();
                cleanAreaCount += 1;
            } else {
                checkNoCleanArea = searchNoCleanArea();
            }
        }

        return cleanAreaCount;
    }

    private static boolean searchNoCleanArea() {
        int checkMoveArea = 1;
        boolean checkCleanArea = true;

        while (checkMoveArea == 1) {
            if (vacuum.d == NORTH) {
                checkMoveArea = totalArea[vacuum.r - 1][vacuum.c];
            } else if (vacuum.d == EAST) {
                checkMoveArea = totalArea[vacuum.r][vacuum.c - 1];
            } else if (vacuum.d == SOUTH) {
                checkMoveArea = totalArea[vacuum.r + 1][vacuum.c];
            } else if (vacuum.d == WEST) {
                checkMoveArea = totalArea[vacuum.r][vacuum.c + 1];
            }

            if (checkMoveArea == 0) {
                changeVacuumDirectionAndLocation();
                checkCleanArea = false;
            }
        }

        return checkCleanArea;
    }

    private static void changeVacuumDirectionAndLocation() {
        int direction = vacuum.d;
        int row = vacuum.r;
        int column = vacuum.c;

        if (direction == NORTH) {
            direction = WEST;
            row -= 1;
        } else {
            direction -= 1;
            if (direction == EAST) {
                column -= 1;
            } else if (direction == SOUTH) {
                row += 1;
            } else if (direction == WEST) {
                column += 1;
            }
        }

        vacuum = new Vacuum(row, column, direction);
    }

    private static boolean checkCleanArea() {
        return totalArea[vacuum.r][vacuum.c] == 0;
    }

    private static void cleanArea() {
        totalArea[vacuum.r][vacuum.c] = 1;
    }

    private static class Vacuum {
        private int r; // 북쪽에서 떨어진 칸의 개수
        private int c; // 서쪽에서 떨어진 칸의 개수
        private int d; // 방향

        public Vacuum(final int r, final int c, final int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }
}
