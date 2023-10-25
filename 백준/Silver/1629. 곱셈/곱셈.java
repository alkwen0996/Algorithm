import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println(pow(a, b, c));
    }

    private static long pow(final int a, int b, final int c) {
        if (b == 1) {
            return a % c;
        }

        long result = pow(a, b / 2, c);
        result = result * result % c;

        if(b % 2 == 0){
            return result;
        }

        return result * a % c;
    }

}
