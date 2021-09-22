package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_9012 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringBuilder stringBuilder = new StringBuilder();
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            stringBuilder.append(solve(bufferedReader.readLine())).append("\n");
        }

        System.out.println(stringBuilder.toString());
    }

    private static String solve(final String inputData) {
        final char[] parentheses = inputData.toCharArray();

        int VPSFlag = 0;
        for (final char parenthesis : parentheses) {
            if (parenthesis == '(') {
                VPSFlag++;
            }
            if (parenthesis == ')') {
                VPSFlag--;
            }
            if (VPSFlag < 0) {
                return "NO";
            }
        }

        if (VPSFlag == 0) {
            return "YES";
        }

        return "NO";
    }
}
