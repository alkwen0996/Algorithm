package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No_1032 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final List<String> fileNames = new ArrayList<>();
        int N = Integer.parseInt(bufferedReader.readLine());

        while (N-- > 0) {
            fileNames.add(bufferedReader.readLine());
        }

        String result = solve(fileNames);
        System.out.println(result);
    }

    private static String solve(final List<String> fileNames) {
        final StringBuilder stringBuilder = new StringBuilder();

        int fileLength = fileNames.get(0).length();
        char[] firstFileNameCharacters = fileNames.get(0).toCharArray();

        for (int j = 0; j < fileLength; j++) {
            for (int i = 1; i < fileNames.size(); i++) {
                if (fileNames.get(i).charAt(j) != firstFileNameCharacters[j]) {
                    firstFileNameCharacters[j] = '?';
                }
            }
        }

        for (final char firstFileNameCharacter : firstFileNameCharacters) {
            stringBuilder.append(firstFileNameCharacter);
        }

        return stringBuilder.toString();
    }
}
