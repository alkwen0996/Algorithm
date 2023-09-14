import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int count = 0;
        createOne(n, count);

        System.out.println(result);
    }

    private static void createOne(int n, int count) {
        if (n == 1) {
            result = Math.min(count, result);

            return;
        }

        if (count >= result) {
            return;
        }

        if (n % 3 == 0) {
            createOne(n / 3, count + 1);
        }

        if (n % 2 == 0) {
            createOne(n / 2, count + 1);
        }

        createOne(n - 1, count + 1);
    }

}
