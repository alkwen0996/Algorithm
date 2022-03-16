package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class No_10757 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        final BigInteger A = new BigInteger(stringTokenizer.nextToken());
        final BigInteger B = new BigInteger(stringTokenizer.nextToken());
        final BigInteger sum = A.add(B);

        System.out.println(sum);
    }
}
