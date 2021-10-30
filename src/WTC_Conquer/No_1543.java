package WTC_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1543 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String document = bufferedReader.readLine();
        String word = bufferedReader.readLine();

        int result = solve(document, word);
        System.out.println(result);
    }

    private static int solve(String document, final String word) {
        int count = 0;

        if (!document.contains(word)) {
            return count;
        }

        while (document.length() >= word.length()) {
            if (document.contains(word)) {
                document = document.substring(document.indexOf(word) + word.length());
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}
