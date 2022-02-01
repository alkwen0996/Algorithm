package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2745 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        String inputNumber = stringTokenizer.nextToken();
        final int numberType = Integer.parseInt(stringTokenizer.nextToken());

        int result = Integer.parseInt(inputNumber, numberType);
        System.out.println(result);
    }
}
