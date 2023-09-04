import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static final String NEW_LINE = "\n";
    public static final String SPACE = " ";

    public static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        count = 0;

        find((int) Math.pow(2, N), r, c);
        System.out.println(count);
    }

    private static void find(final int size, final int r, final int c) {
        if (size == 1) {
            return;
        }

        int half = size / 2;

        if (r < half && c < half) {
            find(size / 2, r, c);
        } else if (r < half) {
            count += (size * size / 4);
            find(size / 2, r, c - (size / 2));
        } else if (c < half) {
            count += (size * size / 4) * 2;
            find(size / 2, r - (size / 2), c);
        } else {
            count += (size * size / 4) * 3;
            find(size / 2, r - (size / 2), c - (size / 2));
        }

    }

}