package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_23080 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final int K = Integer.parseInt(bufferedReader.readLine());
        final String cryptogram = bufferedReader.readLine();

        System.out.println(solve(K, cryptogram));
    }

    private static StringBuilder solve(final int k, final String cryptogram) {
        char[] cryptogramCharacters = cryptogram.toCharArray();
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < cryptogramCharacters.length; i += k) {
            stringBuilder.append(cryptogramCharacters[i]);
        }

        return stringBuilder;
    }
}
