package Basic_Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_1712 {
    public static void main(String[] args) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;

        int fixedCost = bufferedReader.read();
        int variableCost = bufferedReader.read();
        int notebookCost = bufferedReader.read();
        System.out.println(solve(fixedCost, variableCost, notebookCost, count));
    }

    private static int solve(int fixedCost, int variableCost, int notebookCost, int count) {
        if (variableCost > notebookCost) {
            return -1;
        }
//      while (fixedCost + (variableCost * count) >= notebookCost * count) {
        if (fixedCost / (notebookCost - variableCost) > count) {
            count++;
            return solve(fixedCost, variableCost, notebookCost, count);
        } else{
            return count;
        }

    }
}
