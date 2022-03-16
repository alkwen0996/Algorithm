package BaekJoon.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int countLine = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < countLine; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            stringBuilder.append(solve(stringTokenizer));
        }
        System.out.println(stringBuilder.toString());
    }

    private static String solve(StringTokenizer stringTokenizer) {
        StringBuilder stringBuilder = new StringBuilder();

        while (stringTokenizer.hasMoreTokens()) {
            int number = Integer.parseInt(stringTokenizer.nextToken());
            String input = stringTokenizer.nextToken();

                stringBuilder.append(createResultString(input, number)).append("\n");
        }
        return stringBuilder.toString();
    }

    private static String createResultString(String input, int number) {
        char[] chars = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : chars) {
            for (int i = 0; i < number; i ++){
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }

}
