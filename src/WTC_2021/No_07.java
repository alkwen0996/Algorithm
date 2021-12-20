package WTC_2021;

public class No_07 {
    public static void main(String[] args) {
        String[] grid = {"A", "MAN", "DRINK", "WATER11"};
        boolean clockwise = false;

        String[] result = solution(grid, clockwise);
        for (final String s : result) {
            System.out.println(s);
        }
    }

    private static String[] solution(final String[] grid, final boolean clockwise) {
        int size = grid[grid.length - 1].length();
        char[][] triangle = new char[size][size];

        int point = triangle.length / 2;
        for (int i = 0; i <= triangle.length / 2; i++) {
            char[] gridCharacters = grid[i].toCharArray();
            int index = point;

            for (final char gridCharacter : gridCharacters) {
                triangle[i][index++] = gridCharacter;
            }
            point--;
        }

        String[] answer = new String[(triangle.length / 2) + 1];
        StringBuilder stringBuilder;

        if (clockwise) {
            int row = triangle.length / 2;
            int column = 0;
            for (int i = 0; i <= row; i++) {
                stringBuilder = new StringBuilder();
                int usingRow = row;
                int usingColumn = column + (i * 2);
                int count = 0;

                while (checkRange(usingRow, usingColumn, size) && checkZero(usingRow, usingColumn, triangle)) {
                    stringBuilder.append(triangle[usingRow][usingColumn]);
                    if (count % 2 == 0) {
                        usingColumn--;
                    } else {
                        usingRow--;
                    }
                    count++;
                }
                answer[i] = stringBuilder.toString();
            }
        } else {
            int row = triangle.length / 2;
            int column = triangle.length - 1;
            for (int i = 0; i <= row; i++) {
                stringBuilder = new StringBuilder();
                int usingRow = row - i;
                int usingColumn = column - i;
                int count = 0;

                while (checkRange(usingRow, usingColumn, size) && checkZero(usingRow, usingColumn, triangle)) {
                    stringBuilder.append(triangle[usingRow][usingColumn]);
                    if (count % 2 == 0) {
                        usingRow++;
                    } else {
                        usingColumn--;
                    }
                    count++;
                }
                answer[i] = stringBuilder.toString();
            }
        }

        return answer;
    }

    private static boolean checkZero(final int usingRow, final int usingColumn, final char[][] triangle) {
        return triangle[usingRow][usingColumn] != 0;
    }

    private static boolean checkRange(int usingRow, int usingColumn, int size) {
        return usingRow >= 0 && usingColumn >= 0 && usingRow <= (size / 2) && usingColumn <= size;
    }
}
