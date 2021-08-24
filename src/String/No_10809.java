package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_10809 {
    public static final int ALPHABET_COUNT = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        char[] inputCharsArray = input.toCharArray();

        String result = solve(inputCharsArray);

        System.out.println(result);

    }

    private static String solve(char [] inputCharsArray) {
        List<Character> inputChars = new ArrayList<>();

        for (char c : inputCharsArray) {
            inputChars.add(c);
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < ALPHABET_COUNT; i++){
            if(!inputChars.contains((char) (97 + i))){
                stringBuilder.append(-1).append(" ");
            }
            if(inputChars.contains((char) (97 + i))){
                stringBuilder.append(inputChars.indexOf((char) (97 + i))).append(" ");
            }
        }

        return stringBuilder.toString();
    }
}
