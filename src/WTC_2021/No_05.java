package WTC_2021;

public class No_05 {
    public static void main(String[] args) {
//        int rows = 3;
//        int columns = 4;

        int rows = 3;
        int columns = 3;


        int[][] answer = solution(rows, columns);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] solution(final int rows, final int columns) {
        int answer[][] = new int[rows][columns];

        int r = 0;
        int c = 0;
        int previousWriteNumber = 1;

        while (!isTerminate(answer) && !isCycle(r, c, previousWriteNumber, answer)) {
            answer[r][c] = previousWriteNumber;
            if ((previousWriteNumber % 2) == 0) {
                r++;
                r %= rows;
            } else {
                c++;
                c %= columns;
            }
            previousWriteNumber = previousWriteNumber + 1;
        }

        return answer;
    }

    private static boolean isCycle(final int r, final int c, final int previousWriteNumber, final int[][] answer) {
        return answer[r][c] != 0 && (answer[r][c] % 2) == (previousWriteNumber % 2);
    }

    private static boolean isTerminate(int[][] answer) {
        boolean checkZero = true;
        for (final int[] ints : answer) {
            for (final int anInt : ints) {
                if (anInt == 0) {
                    checkZero = false;
                    break;
                }
            }
        }
        return checkZero;
    }

}
