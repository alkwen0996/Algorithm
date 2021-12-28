package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class No_2935 {
    private static final String PLUS = "+";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        BigInteger a = new BigInteger(bufferedReader.readLine());
        final String symbol = bufferedReader.readLine();
        BigInteger b = new BigInteger(bufferedReader.readLine());

        BigInteger result = new BigInteger(solve(a, symbol, b));
        System.out.println(result);
    }

    private static String solve(final BigInteger a, final String symbol, final BigInteger b) {
        if (symbol.equals(PLUS)) {
            return String.valueOf(a.add(b));
        }

        return String.valueOf(a.multiply(b));
    }
}
