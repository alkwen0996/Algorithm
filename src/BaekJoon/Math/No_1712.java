package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1712 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int fixedCost = Integer.parseInt(stringTokenizer.nextToken());
        int variableCost = Integer.parseInt(stringTokenizer.nextToken());
        int notebookCost = Integer.parseInt(stringTokenizer.nextToken());
        System.out.println(solve(fixedCost, variableCost, notebookCost));
    }

    private static int solve(int fixedCost, int variableCost, int notebookCost) {
        if (variableCost >= notebookCost) {
            return -1;
        }

      return fixedCost / (notebookCost - variableCost)+1;
    }
}
