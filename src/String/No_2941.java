package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_2941 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputData = bufferedReader.readLine();

        int result = solve(inputData);
        System.out.println(result);
    }

    private static int solve(final String inputData) {
        final String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        int count = 0;

        String newInputData = inputData;
        for (String str : croatia) {
            if (newInputData.contains(str)) {
                newInputData = newInputData.replaceAll(str, "1");
            }
        }
        char [] inputDataChars = newInputData.toCharArray();
        for (final char inputDataChar : inputDataChars) {
            if (inputDataChar == '1') {
                count++;
            }
        }
        newInputData = newInputData.replace("1","");
        count += newInputData.length();

        return count;
    }
}
