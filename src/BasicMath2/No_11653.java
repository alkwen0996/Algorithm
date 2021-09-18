package BasicMath2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_11653 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        String result = solve(N);
        System.out.println(result);
    }

    private static String solve(int N) {
        final StringBuilder stringBuilder = new StringBuilder();

        int x = 2;
        while (N != 1) {
            if (N % x == 0) {
                stringBuilder.append(x).append("\n");
                N /= x;
            }else{
                x++;
            }
        }

        return stringBuilder.toString();
    }
}
