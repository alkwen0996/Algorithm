import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        long a = Integer.parseInt(stringTokenizer.nextToken());
        long b = Integer.parseInt(stringTokenizer.nextToken());
        long c = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println(calculate(a, b, c));
    } // main

    private static long calculate(long a, long b, long c) {
        if (b == 1) {
            return a % c;
        }

        long result = calculate(a, b / 2, c);

        if (b % 2 == 1) {
            return result * result % c * a % c;
        }

        return result * result % c;
    }
} // class
