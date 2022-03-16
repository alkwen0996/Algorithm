package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10809 {
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String word = bufferedReader.readLine();

        final StringBuilder stringBuilder = new StringBuilder();

        for (char i = 'a'; i <= 'z'; i++) {
            stringBuilder.append(word.indexOf(i)).append(SPACE);
        }

        System.out.println(stringBuilder);
    }
}
