import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        count = 0;
        searchMap((int) Math.pow(2, n), r, c);
        System.out.println(count);
    } // main

    private static void searchMap(final int size, final int row, final int column) {
        if (size == 1) {
            return;
        }

        if (row < size / 2 && column < size / 2) {
            searchMap(size / 2, row, column);
        } else if (row < size / 2 && column >= size / 2) {
            count += size * size / 4;
            searchMap(size / 2, row, column - (size / 2));
        } else if (row >= size / 2 && column < size / 2) {
            count += (size * size / 4) * 2;
            searchMap(size / 2, row - (size / 2), column);
        } else {
            count += (size * size / 4) * 3;
            searchMap(size / 2, row - (size / 2), column - (size / 2));
        }
    }

} // class
