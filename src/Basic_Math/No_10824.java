package Basic_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10824 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        String ab = stringTokenizer.nextToken() + stringTokenizer.nextToken();
        String cd = stringTokenizer.nextToken() + stringTokenizer.nextToken();

        System.out.println(Long.parseLong(ab) + Long.parseLong(cd));
    }
}
