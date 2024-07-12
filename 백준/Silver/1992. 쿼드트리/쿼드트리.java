import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] line = bufferedReader.readLine().toCharArray();

            for (int j = 0; j < n; j++) {
                map[i][j] = line[j];
            }
        }

        stringBuilder = new StringBuilder();
        quadTree(map, n, 0, 0);

        System.out.println(stringBuilder);
    } // main

    private static void quadTree(final char[][] map, final int size, final int row, final int column) {
        if (isSame(map, size, row, column)) {
            stringBuilder.append(map[row][column]);

            return;
        }

        int newSize = size / 2;

        stringBuilder.append("(");

        quadTree(map, newSize, row, column);
        quadTree(map, newSize, row, column + newSize);
        quadTree(map, newSize, row + newSize, column);
        quadTree(map, newSize, row + newSize, column + newSize);

        stringBuilder.append(")");
    }

    private static boolean isSame(final char[][] map, final int size, final int row, final int column) {
        for (int i = row; i < row + size; i++) {
            for (int j = column; j < column + size; j++) {
                if (map[row][column] != map[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

} // class
