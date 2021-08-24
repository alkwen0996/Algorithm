package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        StringBuilder stringBuilder = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++){
            stringBuilder.append(input.indexOf(c)).append(" ");
        }
            System.out.print(stringBuilder.toString());
    }
}
