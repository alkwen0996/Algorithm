package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10953 {
    public static final String DELIMITER = ",";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        final StringBuilder stringBuilder = new StringBuilder();

        int sum = 0;
        while(T-->0){
            final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), DELIMITER);
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            sum = (a+b);
            stringBuilder.append(sum).append("\n");
        }

        System.out.println(stringBuilder);

    }
}
